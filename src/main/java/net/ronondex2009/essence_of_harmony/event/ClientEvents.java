package net.ronondex2009.essence_of_harmony.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.networking.ModPacketID;
import net.ronondex2009.essence_of_harmony.networking.packets.PlayNoteC2SPacket;
import net.ronondex2009.essence_of_harmony.util.ModKeyMappings;
import net.ronondex2009.essence_of_harmony.util.notes;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id, value = Dist.CLIENT)
    public static class ClientForgeEvents 
    {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key key)
        {
            Minecraft instance = Minecraft.getInstance();
            if(ModKeyMappings.PLAYING_KEY_C.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.C, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_C_SHARP.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.CS, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_D.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.D, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_D_SHARP.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.DS, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_E.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.E, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_F.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.F, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_F_SHARP.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.FS, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_G.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.G, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_G_SHARP.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.GS, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_A.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.A, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_A_SHARP.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.AS, instance.player.getMainHandItem()));
            if(ModKeyMappings.PLAYING_KEY_B.consumeClick()) ModPacketID.INSTANCE.sendToServer(new PlayNoteC2SPacket(notes.B, instance.player.getMainHandItem()));
        }
    }

    @Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents
    {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event)
        {
            event.register(ModKeyMappings.PLAYING_KEY_A);
            event.register(ModKeyMappings.PLAYING_KEY_A_SHARP);
            event.register(ModKeyMappings.PLAYING_KEY_B);
            event.register(ModKeyMappings.PLAYING_KEY_C);
            event.register(ModKeyMappings.PLAYING_KEY_C_SHARP);
            event.register(ModKeyMappings.PLAYING_KEY_D);
            event.register(ModKeyMappings.PLAYING_KEY_D_SHARP);
            event.register(ModKeyMappings.PLAYING_KEY_E);
            event.register(ModKeyMappings.PLAYING_KEY_F);
            event.register(ModKeyMappings.PLAYING_KEY_F_SHARP);
            event.register(ModKeyMappings.PLAYING_KEY_G);
            event.register(ModKeyMappings.PLAYING_KEY_G_SHARP);
        }
    }

}
