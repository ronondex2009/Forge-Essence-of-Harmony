package net.ronondex.essence_of_harmony.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex.essence_of_harmony.essence_of_harmony;
import java.util.function.Supplier;
import net.ronondex.essence_of_harmony.item.ModCreativeModeTab;

public class ModBlocks {
    //deferred registers
    public static final DeferredRegister<Block> BLOCKS = 
        DeferredRegister.create(ForgeRegistries.BLOCKS, essence_of_harmony.MODID);
    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, essence_of_harmony.MODID);
    
    //setup block making
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    } 

    //make the blocks
    public static final RegistryObject<Block> VIBRANTWOOD = registerBlock("vibrant_wood", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.WOOD)), ModCreativeModeTab.EOH_CREATIVE_MODE_TAB);

    public static void register(IEventBus EventBus){
        BLOCKS.register(EventBus);
        ITEMS.register(EventBus);
    }
}
