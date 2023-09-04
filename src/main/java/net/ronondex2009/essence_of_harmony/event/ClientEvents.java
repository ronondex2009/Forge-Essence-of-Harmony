package net.ronondex2009.essence_of_harmony.event;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.networking.ModPacketID;
import net.ronondex2009.essence_of_harmony.networking.packets.CheckSpellC2SPacket;
import net.ronondex2009.essence_of_harmony.networking.packets.PlayNoteC2CPacket;
import net.ronondex2009.essence_of_harmony.networking.packets.StopNoteC2CPacket;
import net.ronondex2009.essence_of_harmony.spell.ModSpells;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.ModKeyMappings;
import net.ronondex2009.essence_of_harmony.util.notes;

public class ClientEvents {
    
    public static boolean is_down_C = false;
    public static boolean is_down_CS = false;
    public static boolean is_down_D = false;
    public static boolean is_down_DS = false;
    public static boolean is_down_E = false;
    public static boolean is_down_F = false;
    public static boolean is_down_FS = false;
    public static boolean is_down_G = false;
    public static boolean is_down_GS = false;
    public static boolean is_down_A = false;
    public static boolean is_down_AS = false;
    public static boolean is_down_B = false;

    
    @Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id, value = Dist.CLIENT)
    public static class ClientForgeEvents 
    {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key key)
        {
            Minecraft instance = Minecraft.getInstance();
            if(ModKeyMappings.PLAYING_KEY_C.consumeClick() && !is_down_C) { playNote(notes.C, instance); is_down_C=true; }
            //if(ModKeyMappings.PLAYING_KEY_C_SHARP.consumeClick() && !is_down_CS) { playNote(notes.CS, instance); is_down_CS=true; }
            if(ModKeyMappings.PLAYING_KEY_D.consumeClick() && !is_down_D) { playNote(notes.D, instance); is_down_D=true; }
            //if(ModKeyMappings.PLAYING_KEY_D_SHARP.consumeClick() && !is_down_DS) { playNote(notes.DS, instance); is_down_DS=true; }
            if(ModKeyMappings.PLAYING_KEY_E.consumeClick() && !is_down_E) { playNote(notes.E, instance); is_down_E=true; }
            if(ModKeyMappings.PLAYING_KEY_F.consumeClick() && !is_down_F) { playNote(notes.F, instance); is_down_F=true; }
            //if(ModKeyMappings.PLAYING_KEY_F_SHARP.consumeClick() && !is_down_FS) { playNote(notes.FS, instance); is_down_FS=true; }
            if(ModKeyMappings.PLAYING_KEY_G.consumeClick() && !is_down_G) { playNote(notes.G, instance); is_down_G=true; }
            //if(ModKeyMappings.PLAYING_KEY_G_SHARP.consumeClick() && !is_down_GS) { playNote(notes.GS, instance); is_down_GS=true; }
            if(ModKeyMappings.PLAYING_KEY_A.consumeClick() && !is_down_A) { playNote(notes.A, instance); is_down_A=true; }
            //if(ModKeyMappings.PLAYING_KEY_A_SHARP.consumeClick() && !is_down_AS) { playNote(notes.AS, instance); is_down_AS=true; }
            if(ModKeyMappings.PLAYING_KEY_B.consumeClick() && !is_down_B) { playNote(notes.B, instance); is_down_B=true; }
        }
            @SubscribeEvent
        public static void tickEvent(ClientTickEvent event)
        {
            Minecraft instance = Minecraft.getInstance();
            if(!ModKeyMappings.PLAYING_KEY_C.isDown() && is_down_C) { stopNote(notes.C, instance); is_down_C=false; } 
            if(!ModKeyMappings.PLAYING_KEY_C_SHARP.isDown() && is_down_CS) { stopNote(notes.CS, instance); is_down_CS=false; } 
            if(!ModKeyMappings.PLAYING_KEY_D.isDown() && is_down_D) { stopNote(notes.D, instance); is_down_D=false; } 
            if(!ModKeyMappings.PLAYING_KEY_D_SHARP.isDown() && is_down_DS) { stopNote(notes.DS, instance); is_down_DS=false; } 
            if(!ModKeyMappings.PLAYING_KEY_E.isDown() && is_down_E) { stopNote(notes.E, instance); is_down_E=false; } 
            if(!ModKeyMappings.PLAYING_KEY_F.isDown() && is_down_F) { stopNote(notes.F, instance); is_down_F=false; } 
            if(!ModKeyMappings.PLAYING_KEY_F_SHARP.isDown() && is_down_FS) { stopNote(notes.FS, instance); is_down_FS=false; } 
            if(!ModKeyMappings.PLAYING_KEY_G.isDown() && is_down_G) { stopNote(notes.G, instance); is_down_G=false; } 
            if(!ModKeyMappings.PLAYING_KEY_G_SHARP.isDown() && is_down_GS) { stopNote(notes.GS, instance); is_down_GS=false; } 
            if(!ModKeyMappings.PLAYING_KEY_A.isDown() && is_down_A) { stopNote(notes.A, instance); is_down_A=false; } 
            if(!ModKeyMappings.PLAYING_KEY_A_SHARP.isDown() && is_down_AS) { stopNote(notes.AS, instance); is_down_AS=false; } 
            if(!ModKeyMappings.PLAYING_KEY_B.isDown() && is_down_B) { stopNote(notes.B, instance); is_down_B=false; } 
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

    public static List<notes> notesPlayed = new ArrayList<>();
    public static List<AbstractSymbol> stack = new ArrayList<>();

    private static void playNote(notes note, Minecraft instance)
    {
        if(instance.player==null) return;
        
        ModPacketID.INSTANCE.send(PacketDistributor.ALL.noArg(), new PlayNoteC2CPacket(note, instance.player.getUUID()));

        notesPlayed.add(note);
    }


    private static void stopNote(notes note, Minecraft instance)
    {
        if(instance.player==null) return;

        ModPacketID.INSTANCE.send(PacketDistributor.ALL.noArg(), new StopNoteC2CPacket(note, instance.player.getUUID())); 

        ModPacketID.INSTANCE.sendToServer(new CheckSpellC2SPacket(stack, notesPlayed));
        if(ModSpells.checkSpells(notesPlayed, stack, instance.player, instance.level))
            notesPlayed.clear();
    } 
    
}