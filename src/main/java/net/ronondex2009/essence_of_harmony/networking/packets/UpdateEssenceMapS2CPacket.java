package net.ronondex2009.essence_of_harmony.networking.packets;

import java.util.function.Supplier;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.network.NetworkEvent;
import net.ronondex2009.essence_of_harmony.world.essenceMap;

public class UpdateEssenceMapS2CPacket 
{

    ChunkPos key;
    Float value; 

    public UpdateEssenceMapS2CPacket(ChunkPos key, Float value)
    {
        this.key = key;
        this.value = value;
    }

    public static void encode(UpdateEssenceMapS2CPacket msg, FriendlyByteBuf buf)
    {
        buf.writeChunkPos(msg.key);
        buf.writeFloat(msg.value);
    }

    public static UpdateEssenceMapS2CPacket decode(FriendlyByteBuf buf)
    {
        return new UpdateEssenceMapS2CPacket(buf.readChunkPos(), buf.readFloat());
    }

    public static void handle(UpdateEssenceMapS2CPacket msg, Supplier<NetworkEvent.Context> context)
    {
        context.get().enqueueWork(() -> {
            //welcome to funky town
            essenceMap.setEssence(msg.key, msg.value);
        });
    }
}
