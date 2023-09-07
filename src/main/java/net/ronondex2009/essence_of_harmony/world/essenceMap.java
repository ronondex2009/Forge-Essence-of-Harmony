package net.ronondex2009.essence_of_harmony.world;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;

public class essenceMap
{
    public static final String KEY = "essenceMap";
    public static final ConcurrentHashMap<ChunkPos, Integer> essenceConcurrentMap = new ConcurrentHashMap<>(); 
    public static Integer getEssence(ChunkPos pos) {return essenceConcurrentMap.get(pos);}
    public static void setEssence(ChunkPos pos, Integer value) {essenceConcurrentMap.put(pos, value);}

    public static void readData(ChunkAccess chunk, CompoundTag data)
    {
        if(data.contains(KEY))
            essenceConcurrentMap.put(chunk.getPos(), data.getInt(KEY));
        else
            essenceConcurrentMap.put(chunk.getPos(), 40);
        System.out.println("LOADED");
    }

    public static void makeEmptyChunk(ChunkPos chunk)
    {
        essenceConcurrentMap.putIfAbsent(chunk, 100);
    }

    public static void unloadData(ChunkAccess chunk)
    {
        essenceConcurrentMap.remove(chunk.getPos());
        System.out.println("UNLOADED");
    }
    
    public static void saveData(ChunkAccess chunk, CompoundTag data)
    {
        CompoundTag tag = new CompoundTag();
        System.out.println("SAVED");
        data.putInt(KEY, essenceConcurrentMap.get(chunk.getPos()));
    }
}

