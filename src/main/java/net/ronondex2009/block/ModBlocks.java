package net.ronondex2009.block;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony;
import net.ronondex2009.item.ModItems;

public class ModBlocks {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, essence_of_harmony.mod_id);

    //this registers a block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    //this registers that block as a special blockItem.
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    //this is how we make blocks
    public static final RegistryObject<Block> NOTIUM_ORE = registerBlock("notium_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).lightLevel(BlockState -> 4).destroyTime(5).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> NOTIUM_ORE_DAMAGED = registerBlock("notium_ore_damaged", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
