package net.ronondex2009.essence_of_harmony.world;

import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.ChunkAccess;

public class essenceMap
{
    public static final String KEY = "essenceMap";
    public static final ConcurrentHashMap<ChunkPos, Float> essenceConcurrentMap = new ConcurrentHashMap<>(); 
    public static Float getEssence(ChunkPos pos) {return essenceConcurrentMap.get(pos);}
    public static void setEssence(ChunkPos pos, Float value) {essenceConcurrentMap.put(pos, value);}

    public static void readData(ChunkAccess chunk, CompoundTag data)
    {
        if(data.contains(KEY))
            essenceConcurrentMap.put(chunk.getPos(), data.getFloat(KEY));
        else
            essenceConcurrentMap.put(chunk.getPos(), 100f);
    }

    public static void makeEmptyChunk(ChunkPos chunk)
    {
        essenceConcurrentMap.putIfAbsent(chunk, 100f);
    }

    public static void unloadData(ChunkAccess chunk)
    {
        essenceConcurrentMap.remove(chunk.getPos());
    }
    
    public static void saveData(ChunkAccess chunk, CompoundTag data)
    {
        CompoundTag tag = new CompoundTag();
        if(essenceConcurrentMap.get(chunk.getPos()) == null) makeEmptyChunk(chunk.getPos());
        data.putFloat(KEY, essenceConcurrentMap.get(chunk.getPos()));
    }
}

