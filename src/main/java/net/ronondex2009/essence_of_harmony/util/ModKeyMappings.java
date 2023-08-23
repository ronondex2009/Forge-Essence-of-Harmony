package net.ronondex2009.essence_of_harmony.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.jarjar.util.Lazy;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;

@Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id, value = Dist.CLIENT, bus = Bus.MOD)
public class ModKeyMappings {

    public static final String CATEGORY_PIANO = "EOH Piano Keymappings";

    public static final Lazy<KeyMapping> NOTE_F_SHARP = Lazy.of(() -> new KeyMapping("key.essence_of_harmony.note.f#", KeyConflictContext.UNIVERSAL , InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, CATEGORY_PIANO));

    @SubscribeEvent
    public void register(RegisterKeyMappingsEvent event)
    {
        event.register(NOTE_F_SHARP.get());
    }
}
