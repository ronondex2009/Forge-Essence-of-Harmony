package net.ronondex2009.essence_of_harmony.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.networking.packets.CheckSpellC2SPacket;
import net.ronondex2009.essence_of_harmony.networking.packets.PlayNoteC2CPacket;
import net.ronondex2009.essence_of_harmony.networking.packets.StopNoteC2CPacket;

public class ModPacketID {
    private static int id = 0;
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(essence_of_harmony.mod_id, "main"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);

    public static void register()
    {
        INSTANCE.messageBuilder(CheckSpellC2SPacket.class, id++, NetworkDirection.PLAY_TO_SERVER).encoder(CheckSpellC2SPacket::encode).decoder(CheckSpellC2SPacket::decode).consumerMainThread(CheckSpellC2SPacket::handle).add();
        INSTANCE.messageBuilder(PlayNoteC2CPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT).encoder(PlayNoteC2CPacket::encode).decoder(PlayNoteC2CPacket::decode).consumerMainThread(PlayNoteC2CPacket::handle).add();
        INSTANCE.messageBuilder(StopNoteC2CPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT).encoder(StopNoteC2CPacket::encode).decoder(StopNoteC2CPacket::decode).consumerMainThread(StopNoteC2CPacket::handle).add();
    }
}
