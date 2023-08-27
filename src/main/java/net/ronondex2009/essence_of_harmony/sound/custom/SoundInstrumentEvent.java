package net.ronondex2009.essence_of_harmony.sound.custom;

import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.networking.packets.StopNoteC2CPacket;
import net.ronondex2009.essence_of_harmony.networking.packets.StopNoteC2CPacket.updateCurrentlyPlayingNotes;
import net.ronondex2009.essence_of_harmony.util.PitchDict;
import net.ronondex2009.essence_of_harmony.util.notes;

public class SoundInstrumentEvent extends AbstractTickableSoundInstance implements updateCurrentlyPlayingNotes {

    boolean toStop = false;
    UUID player;
    notes note;
    SoundManager manager;
    Level level;

    public boolean shouldRemove()
    {
        return toStop;
    }

    @Override
    public void tick() 
    {
        if(level.getPlayerByUUID(player)==null) { this.stop(); this.toStop=true; return; } //prevent sounds from being kept on the server if player leaves.
        this.x = level.getPlayerByUUID(player).getEyePosition().x;
        this.y = level.getPlayerByUUID(player).getEyePosition().y;
        this.z = level.getPlayerByUUID(player).getEyePosition().z;
    }

    public void updateNotes(UUID uuid, notes noteUpdate)
    {
        if(uuid.equals(this.player) && noteUpdate == this.note)
        {
            this.stop();
            this.toStop = true;
        }
    }

    public SoundInstrumentEvent(SoundEvent soundEvent, SoundSource soundSource, RandomSource randomSource, notes note, UUID uuid, Level level) 
    {
        super(soundEvent, soundSource, SoundInstance.createUnseededRandom());
        this.attenuation = Attenuation.NONE;
        this.pitch = PitchDict.noteToPitch(note);
        this.volume = 1f;
        this.looping = true;
        this.player = uuid;
        this.note = note;
        this.delay = 0;
        this.level = level;
    }
    
    public boolean canPlaySound() {return true;}
}
