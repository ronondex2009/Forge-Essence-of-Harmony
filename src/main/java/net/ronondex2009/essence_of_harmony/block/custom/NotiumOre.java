package net.ronondex2009.essence_of_harmony.block.custom;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.ronondex2009.essence_of_harmony.block.ModBlocks;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;

public class NotiumOre extends Block {

    public NotiumOre(Properties p_49795_) {
        super(p_49795_);
    }
    
   public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        player.playSound(ModSounds.NOTIUMDAMAGE.get(), 1, 1);
        level.setBlock(blockPos, ModBlocks.NOTIUM_ORE_DAMAGED.get().getStateForPlacement(null), UPDATE_ALL_IMMEDIATE, UPDATE_ALL);
        Random random = new Random();
        for(int i = 0; i<=50; i++){
            level.addParticle(ParticleTypes.FLAME , 
                blockPos.getX() + random.nextDouble(2) - 0.5 , 
                blockPos.getY() + random.nextDouble(2) - 0.5 , 
                blockPos.getZ()  + random.nextDouble(2) - 0.5 , 
                random.nextDouble(0.5)-0.25, random.nextDouble(0.5)-0.25, random.nextDouble(0.5)-0.25);
        }
        for(int i = 0; i<=5; i++){
            level.addParticle(ParticleTypes.NOTE , 
                blockPos.getX() + random.nextDouble(2) - 0.5 , 
                blockPos.getY() + random.nextDouble(2) - 0.5 , 
                blockPos.getZ()  + random.nextDouble(2) - 0.5 , 
                random.nextDouble(4)-2, random.nextDouble(4)-2, random.nextDouble(4)-2);
        }
    }

    
}
