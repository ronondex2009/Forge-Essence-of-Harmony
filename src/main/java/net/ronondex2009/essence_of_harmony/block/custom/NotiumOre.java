package net.ronondex2009.essence_of_harmony.block.custom;


import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.ronondex2009.essence_of_harmony.block.ModBlocks;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;

public class NotiumOre extends Block {
    
    @Override
    public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> components,
            TooltipFlag p_49819_) {
        components.add(Component.literal("Must be hit after reverting back to normal three times before turning into damaged notium. \nNote that there is currently no method of mining pure Notium."));
    }

    public static final IntegerProperty TIMESAGITATED = IntegerProperty.create("times_agitated", 0, 3);
    public static final BooleanProperty AGITATED = BooleanProperty.create("agitated");
    Random random = new Random();

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource RandomSource) 
    {
        if(blockState.getValue(AGITATED))
        {
            serverLevel.setBlock(blockPos, blockState.cycle(AGITATED).setValue(TIMESAGITATED, blockState.getValue(TIMESAGITATED)+1), UPDATE_ALL_IMMEDIATE, UPDATE_ALL);
        }
    }

    //blockstates
    @Override
    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) 
    {
        builder.add(AGITATED);
        builder.add(TIMESAGITATED);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state)
    {
        return state.getValue(AGITATED);
    }

    //constructor
    public NotiumOre(Properties p_49795_) 
    {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(AGITATED, false)
            .setValue(TIMESAGITATED, 0));;
    }
    
    public void attack(BlockState blockState, Level level, BlockPos blockPos, Player player) 
    {
        if(blockState.getValue(TIMESAGITATED) > 1 && !blockState.getValue(AGITATED))
        {
            //set the block to Damaged Notium with effect
            level.playSound(null, blockPos, ModSounds.NOTIUMDAMAGE.get(), SoundSource.BLOCKS, 3, 1);
            SpawnNoteParticle(level, blockPos, random);
            level.setBlock(blockPos, ModBlocks.NOTIUM_ORE_DAMAGED.get().defaultBlockState(), UPDATE_ALL_IMMEDIATE, UPDATE_ALL);
            SpawnDamageParticle(level, blockPos, random);
        }
        if(blockState.getValue(TIMESAGITATED) <= 1 && !blockState.getValue(AGITATED))
        {
            //set the block to Agitated Notium with effect
            level.setBlock(blockPos, blockState.cycle(AGITATED), UPDATE_ALL_IMMEDIATE, UPDATE_ALL);
            level.playSound(null, blockPos, ModSounds.NOTIUMAGITATE.get(), SoundSource.BLOCKS, 3, 1);
            SpawnNoteParticle(level, blockPos, random);
        } 
    }   
    
    public void SpawnNoteParticle(Level level, BlockPos blockPos, Random random)
    {
        for(int i = 0; i < 10; i++)
        {
            level.addParticle( ParticleTypes.NOTE, 
                blockPos.getX() + random.nextDouble(1),
                blockPos.getY() + random.nextDouble(1),
                blockPos.getZ() + random.nextDouble(1),
                0, 0, 0);
        }
    } 
    
    public void SpawnDamageParticle(Level level, BlockPos blockPos, Random random)
    { 
        for(int i = 0; i < 50; i++)
        {
            level.addParticle( ParticleTypes.FLAME, 
                blockPos.getX() + random.nextDouble(1),
                blockPos.getY() + random.nextDouble(1),
                blockPos.getZ() + random.nextDouble(1),
                random.nextDouble(1) - 0.5, random.nextDouble(1) - 0.5, random.nextDouble(1) - 0.5);
        }
    } 

}
