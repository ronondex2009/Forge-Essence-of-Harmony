package net.ronondex2009.essence_of_harmony.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, essence_of_harmony.mod_id);

    public static final RegistryObject<SoundEvent> NOTIUMDAMAGE = registerSoundEvent("notium_sound_damage");
    public static final RegistryObject<SoundEvent> NOTIUMAGITATE = registerSoundEvent("notium_sound_agitate");
    public static final RegistryObject<SoundEvent> CORRUPT_DISC = registerSoundEvent("corrupt_disc");
    public static final RegistryObject<SoundEvent> FLUTE = registerSoundEvent("flute");
    public static final RegistryObject<SoundEvent> OCARINA = registerSoundEvent("ocarina");
    public static final RegistryObject<SoundEvent> GUITAR = registerSoundEvent("guitar");
    public static final RegistryObject<SoundEvent> OVERDRIVE_GUITAR = registerSoundEvent("overdrive_guitar");


    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUNDS.register(name, () -> new SoundEvent(new ResourceLocation(essence_of_harmony.mod_id, name)));
    }
    public static void register(IEventBus eventBus){
        SOUNDS.register(eventBus);
    }
    
}
