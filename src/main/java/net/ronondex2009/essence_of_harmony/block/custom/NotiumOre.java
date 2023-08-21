package net.ronondex2009.essence_of_harmony.block.custom;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
<<<<<<< HEAD
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
=======
>>>>>>> cfe8bb1d9534ddf6e5189720bb4c45d91868d27a
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.ronondex2009.essence_of_harmony.block.ModBlocks;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;

public class NotiumOre extends Block {

    //public static final BooleanProperty AGITATED = BooleanProperty.create("agitated");

    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        //builder.add(AGITATED);
    }

    public NotiumOre(Properties p_49795_) {
        super(p_49795_);
    }
    
<<<<<<< HEAD
    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) {
        if(!level.isClientSide())
        {
            Random random = new Random();
            if(random.nextInt(6) < 5){
                level.playSound(null, blockPos, ModSounds.NOTIUMAGITATE.get(), SoundSource.BLOCKS, 0.7f, 1);
                noteParticles(level, blockPos, random);
            } else {
                level.playSound(null, blockPos, ModSounds.NOTIUMDAMAGE.get(), SoundSource.BLOCKS, 1, 1);
                level.setBlock(blockPos, ModBlocks.NOTIUM_ORE_DAMAGED.get().getStateForPlacement(null), UPDATE_ALL_IMMEDIATE, UPDATE_ALL);
                for(int i = 0; i<=50; i++){
                    level.getServer().getLevel(level.dimension()).sendParticles(ParticleTypes.FLAME, 
                    blockPos.getX()+0.5, 
                    blockPos.getY()+0.5, 
                    blockPos.getZ()+0.5, 
                    1, 
                    0.1, 
                    0.1,
                    0.1,
                    0.1);
                }
                noteParticles(level, blockPos, random);
            }
        }   
    }    


    
    private void noteParticles(Level level, BlockPos blockPos, Random random){
        for(int i = 0; i<=5; i++){
            level.getServer().getLevel(level.dimension()).sendParticles(ParticleTypes.NOTE, 
                blockPos.getX()+0.5, 
                blockPos.getY()+0.5, 
                blockPos.getZ()+0.5, 
                1, 
                0.5, 
                0.5,
                0.5,
                0.5);
        } 
    }
=======
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
>>>>>>> cfe8bb1d9534ddf6e5189720bb4c45d91868d27a
}
