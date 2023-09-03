package net.ronondex2009.essence_of_harmony.networking.packets;


import java.util.UUID;
import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.network.NetworkEvent;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.sound.custom.SoundInstrumentEvent;
import net.ronondex2009.essence_of_harmony.util.notes;

public class PlayNoteC2CPacket {
    
    public notes note;
    public UUID sender;

    public PlayNoteC2CPacket(notes note, UUID sender)
    {
        this.note = note;
        this.sender = sender;
    }

    public static void encode(PlayNoteC2CPacket msg, FriendlyByteBuf buf)
    {
        buf.writeEnum(msg.note);
        buf.writeUUID(msg.sender);
    }

    public static PlayNoteC2CPacket decode(FriendlyByteBuf buf)
    {
        return new PlayNoteC2CPacket(buf.readEnum(notes.class), buf.readUUID());
    }

    public static void handle(PlayNoteC2CPacket msg, Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> {
            Minecraft instance = Minecraft.getInstance();
            SoundEvent soundToUse = null;
            ItemStack item = instance.level.getPlayerByUUID(msg.sender).getMainHandItem();
            if(item.getItem()==ModItems.FLUTE.get()) soundToUse = ModSounds.FLUTE.get();
            if(item.getItem()==ModItems.OCARINA.get()) soundToUse = ModSounds.OCARINA.get();
            if(item.getItem()==ModItems.GUITAR.get()) soundToUse = ModSounds.GUITAR.get();
            if(item.getItem()==ModItems.OVERDRIVE_GUITAR.get()) soundToUse = ModSounds.OVERDRIVE_GUITAR.get();
            if(item.getItem()==Items.NOTE_BLOCK.asItem()) soundToUse = SoundEvents.NOTE_BLOCK_HARP;
            if(soundToUse!=null)
            {
                SoundInstrumentEvent instrument = new SoundInstrumentEvent(soundToUse, SoundSource.PLAYERS, null, msg.note, msg.sender, instance.level);
                instance.getSoundManager().play(instrument);
                StopNoteC2CPacket.listeners.add(instrument);
            }
        });
    }
}