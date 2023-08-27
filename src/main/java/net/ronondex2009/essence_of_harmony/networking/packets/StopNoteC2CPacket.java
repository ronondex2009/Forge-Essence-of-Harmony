package net.ronondex2009.essence_of_harmony.networking.packets;

import java.util.*;
import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import net.ronondex2009.essence_of_harmony.util.notes;

public class StopNoteC2CPacket {
    
    public interface updateCurrentlyPlayingNotes {
        boolean shouldRemove();
        void updateNotes(UUID UUID, notes noteUpdate);
    }

    public static List<updateCurrentlyPlayingNotes> listeners = new ArrayList<updateCurrentlyPlayingNotes>();
    public notes note;
    public UUID uuid;
    
    public StopNoteC2CPacket(notes note, UUID uuid)
    {
        this.note = note;
        this.uuid = uuid;
    }

    public static void encode(StopNoteC2CPacket msg, FriendlyByteBuf buf)
    {
        buf.writeEnum(msg.note);
        buf.writeUUID(msg.uuid);
    }
    
    public static StopNoteC2CPacket decode(FriendlyByteBuf buf) 
    {
        return new StopNoteC2CPacket(buf.readEnum(notes.class), buf.readUUID());
    }

    public static void handle(StopNoteC2CPacket msg, Supplier<NetworkEvent.Context> context) 
    {
        context.get().enqueueWork(() -> {
            Minecraft instance = Minecraft.getInstance();
            for(updateCurrentlyPlayingNotes toUpdate : StopNoteC2CPacket.listeners)
                toUpdate.updateNotes(msg.uuid, msg.note);
            for(updateCurrentlyPlayingNotes toUpdate : StopNoteC2CPacket.listeners)
                if (toUpdate.shouldRemove()) StopNoteC2CPacket.listeners.remove(toUpdate);   
        });
    }
}

