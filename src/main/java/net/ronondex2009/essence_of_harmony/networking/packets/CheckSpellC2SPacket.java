package net.ronondex2009.essence_of_harmony.networking.packets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.apache.commons.lang3.SerializationUtils;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.ronondex2009.essence_of_harmony.spell.ModSpells;
import net.ronondex2009.essence_of_harmony.spell.symbols.IntSymbol;
import net.ronondex2009.essence_of_harmony.spell.symbols.TrashSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
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
        List<Integer> noteInteger = new ArrayList<>();
        for(notes note : msg.noteList) noteInteger.add(note.ordinal()); //convert enum list into int list

        byte[] stackBytes = convertObjectToBytes(msg.stack);
        byte[] noteBytes = convertObjectToBytes(noteInteger);

        buf.writeByteArray(stackBytes).writeByteArray(noteBytes);
    }

    public static CheckSpellC2SPacket decode(FriendlyByteBuf buf)
    {
        byte[] stackBytes = buf.readByteArray(); //read from packet
        byte[] noteBytes = buf.readByteArray(); //read from packet
        
        List<Integer> noteInteger = convertBytesToObject(noteBytes);
        List<AbstractSymbol> stackList = convertBytesToObject(stackBytes);

        List<notes> noteList = new ArrayList<>(); 

        for(int noteInt : noteInteger) noteList.add(notes.values()[noteInt]); //convert to enums

        return new CheckSpellC2SPacket(stackList, noteList);

    }

    public static void handle(CheckSpellC2SPacket msg, Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            ModSpells.checkSpells(msg.noteList, msg.stack, ctx.get().getSender(), ctx.get().getSender().getLevel());
        });
    }

    public static byte[] convertObjectToBytes(Object obj) {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(obj);
            return boas.toByteArray();
        } catch (IOException e) { return convertObjectToBytes(new TrashSymbol()); }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> T convertBytesToObject(byte[] bytes) {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (T) ois.readObject();
        } catch (IOException e) { return (T) new ArrayList<AbstractSymbol>(); } catch (ClassNotFoundException e) { return (T) new ArrayList<AbstractSymbol>(); }
    }
}
