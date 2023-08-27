package net.ronondex2009.essence_of_harmony.block.custom;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class NotiumChunkloader extends Block {
    
    @Override
    public void appendHoverText(ItemStack p_49816_, @Nullable BlockGetter p_49817_, List<Component> components, TooltipFlag p_49819_) 
    {
        components.add(Component.literal("WIP"));
    }
    
    public static final VoxelShape shape = Block.box(4, 0, 4, 12, 8, 12);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) 
    {
        return shape;
    }
    public NotiumChunkloader(Properties p_49795_) {
        super(p_49795_);
    }


}
