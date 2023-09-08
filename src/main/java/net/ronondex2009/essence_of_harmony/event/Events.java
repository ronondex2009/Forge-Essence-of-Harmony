package net.ronondex2009.essence_of_harmony.event;

import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.networking.ModPacketID;
import net.ronondex2009.essence_of_harmony.networking.packets.UpdateEssenceMapS2CPacket;
import net.ronondex2009.essence_of_harmony.world.essenceMap;

@Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id)
public class Events {
    @SubscribeEvent
    public static void chunkSaveEvent(ChunkDataEvent.Save save)
    {
        essenceMap.saveData(save.getChunk(), save.getData());
    }

    @SubscribeEvent
    public static void chunkDataLoadEvent(ChunkDataEvent.Load load)
    {
        essenceMap.readData(load.getChunk(), load.getData());
    }

    @SubscribeEvent
    public static void chunkLoadEvent(ChunkEvent.Load load)
    {
        essenceMap.makeEmptyChunk(load.getChunk().getPos());
    }


    @SubscribeEvent
    public static void chunkUnload(ChunkEvent.Unload unload)
    {
        essenceMap.unloadData(unload.getChunk());
    }
 
    @SubscribeEvent
    public static void tickUpdate(TickEvent event)
    {
        
        //justification: only updates by chunk, which I would argue
        essenceMap.essenceConcurrentMap.forEach((key, value) ->
        {
            if(value > 100) value = 100f; //prevent value from going beyond 100
            if(value != 100 || value >= 20) 
            {
                ChunkPos[] pos = new ChunkPos[] { 
                    new ChunkPos(key.x+1, key.z),
                    new ChunkPos(key.x, key.z+1),
                    new ChunkPos(key.x-1, key.z),
                    new ChunkPos(key.x, key.z-1),
                };

                for( ChunkPos posToGive : pos)
                {
                    if(essenceMap.getEssence(posToGive) == null) continue; //the chunk might not exist!
                    if(essenceMap.getEssence(posToGive) < (value-10))
                    {
                        essenceMap.setEssence(posToGive, essenceMap.getEssence(posToGive)+0.001f);
                        value-=0.001f;
                    }
                }

                if(essenceMap.getEssence(key) != null)
                    if(value < 100);
                        essenceMap.setEssence(key, value+0.00005f);
            }
            if(event.side.isServer())
                ModPacketID.INSTANCE.send(PacketDistributor.ALL.noArg(), new UpdateEssenceMapS2CPacket(key, value));
        });
  
    }
}
