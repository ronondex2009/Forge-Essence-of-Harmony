package net.ronondex2009.essence_of_harmony.event;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.minecraft.world.level.ChunkPos;
import net.minecraftforge.event.level.ChunkDataEvent;
import net.minecraftforge.event.level.ChunkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;

@Mod.EventBusSubscriber(modid = essence_of_harmony.mod_id)
public class Events {
    @SubscribeEvent
    public static void chunkSaveEvent(ChunkDataEvent.Save save)
    {

    }

    @SubscribeEvent
    public static void chunkLoadEvent(ChunkDataEvent.Load load)
    {

    }

    @SubscribeEvent
    public static void chunkUnload(ChunkEvent.Unload unload)
    {

    }
}

class essenceMap
{
    public static final String KEY = "essenceMap";
    private static ConcurrentHashMap<ChunkPos, Integer> essencConcurrentMap = new ConcurrentHashMap<>(); 

    
}
