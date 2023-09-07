package net.ronondex2009.essence_of_harmony.event;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
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
/* 
    @SubscribeEvent
    public static void tickUpdate(TickEvent event)
    {
        //justification: only updates by chunk, which I would argue
        //is far less than a lot of blocks and other logic.
        
        //loop through chunkMap:
            
            //skip if it is at 100 or below 5

            //go through every adjacent chunk;
                //if that chunk has 10 less than this chunk,
                    //give that chunk the difference between us, minus 10, divided by 10.
        
        //regenerate essence.
    }*/
}
