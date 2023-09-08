package net.ronondex2009.essence_of_harmony.util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;

@Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id, value = Dist.CLIENT, bus = Bus.MOD)
public class ModKeyMappings {

    public static final String KEY_CATEGORY_EOH = "key.category.essence_of_harmony.pianoKeys";
    
    public static final KeyMapping PLAYING_KEY_F_SHARP = new KeyMapping("key.essence_of_harmony.f#", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_G = new KeyMapping("key.essence_of_harmony.g", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_G_SHARP = new KeyMapping("key.essence_of_harmony.g#", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_A = new KeyMapping("key.essence_of_harmony.a", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_A_SHARP = new KeyMapping("key.essence_of_harmony.a#", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_J, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_B = new KeyMapping("key.essence_of_harmony.b", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_C = new KeyMapping("key.essence_of_harmony.c", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_C_SHARP = new KeyMapping("key.essence_of_harmony.c#", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_S, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_D = new KeyMapping("key.essence_of_harmony.d", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_X, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_D_SHARP = new KeyMapping("key.essence_of_harmony.d#", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_D, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_E = new KeyMapping("key.essence_of_harmony.e", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, KEY_CATEGORY_EOH);
    public static final KeyMapping PLAYING_KEY_F = new KeyMapping("key.essence_of_harmony.f", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V , KEY_CATEGORY_EOH);

}
