package net.ronondex2009.essence_of_harmony.event;

//import net.minecraft.client.Minecraft;
//import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent.KeyPressed;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.util.ModKeyMappings;

@Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id, value = Dist.CLIENT)
public class ModEventsKeybinding {
    @SubscribeEvent
    public static void keyPress(KeyPressed key){
        if(ModKeyMappings.NOTE_F_SHARP.get().consumeClick()) {
            //Minecraft.getInstance().player.sendSystemMessage(Component.literal("YOOOOOOOO"));
        }
    }
}
