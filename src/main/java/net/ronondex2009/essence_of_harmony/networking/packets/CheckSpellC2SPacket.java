package net.ronondex2009.essence_of_harmony.networking.packets;

import java.util.List;
import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.ronondex2009.essence_of_harmony.spell.ModSpells;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Serialization;
import net.ronondex2009.essence_of_harmony.util.notes;

public class CheckSpellC2SPacket 
{
    List<AbstractSymbol> stack;
    List<notes> noteList;
    
    public CheckSpellC2SPacket(List<AbstractSymbol> stack, List<notes> noteList)
    {
        this.noteList = noteList;
        this.stack = stack;
    }
    
    /*
     * SerializationUtils cannot handle enums. The solution to this
     * is to convert the enums into ints and back.
     */
    public static void encode(CheckSpellC2SPacket msg, FriendlyByteBuf buf)
    {
        byte[] stackBytes = Serialization.convertObjectToBytes(msg.stack);
        byte[] noteBytes = Serialization.convertObjectToBytes(msg.noteList);

        buf.writeByteArray(stackBytes).writeByteArray(noteBytes);
    }

    public static CheckSpellC2SPacket decode(FriendlyByteBuf buf)
    {
        byte[] stackBytes = buf.readByteArray(); //read from packet
        byte[] noteBytes = buf.readByteArray(); //read from packet
        
        List<notes> noteList = Serialization.convertBytesToObject(noteBytes);
        List<AbstractSymbol> stackList = Serialization.convertBytesToObject(stackBytes);

        return new CheckSpellC2SPacket(stackList, noteList);

    }

    public static void handle(CheckSpellC2SPacket msg, Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            ModSpells.checkSpells(msg.noteList, msg.stack, ctx.get().getSender(), ctx.get().getSender().getLevel());
        });
    }
}
