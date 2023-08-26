package net.ronondex2009.essence_of_harmony.networking.packets;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.util.PitchDict;
import net.ronondex2009.essence_of_harmony.util.notes;

public class PlayNoteC2SPacket {
    
    public notes note;
    public ItemStack item;
    
    public PlayNoteC2SPacket(notes note, ItemStack item)
    {
        this.note = note;
        this.item = item;
    }

    public static void encode(PlayNoteC2SPacket msg, FriendlyByteBuf buf)
    {
        buf.writeEnum(msg.note);
        buf.writeItem(msg.item);
    }
    
    public static PlayNoteC2SPacket decode(FriendlyByteBuf buf) 
    {
        return new PlayNoteC2SPacket(buf.readEnum(notes.class), buf.readItem());
    }

    public static void handle(PlayNoteC2SPacket msg, Supplier<NetworkEvent.Context> context) 
    {
        context.get().enqueueWork(() -> {
            //were on the server yoooooo
            ServerPlayer player = context.get().getSender();
            if(msg.item.getItem() == Items.ANDESITE.asItem())
            {
                player.getLevel().playSound(null, player.blockPosition(), ModSounds.FLUTE.get(), SoundSource.PLAYERS , 1, PitchDict.noteToPitch(msg.note));
                context.get().setPacketHandled(true);
            } else {
                context.get().setPacketHandled(true);
            }
        });
    }
}
