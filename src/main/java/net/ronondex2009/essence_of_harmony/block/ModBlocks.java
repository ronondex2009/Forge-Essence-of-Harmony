package net.ronondex2009.essence_of_harmony.block;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony.block.custom.NotiumOre;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.item.ModCreativeModeTab;
import net.ronondex2009.essence_of_harmony.item.ModItems;

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
    public static final RegistryObject<Block> NOTIUM_CHUNKLOADER = registerBlock("notium_chunkloader", () -> new Block(BlockBehaviour.Properties.of(Material.DECORATION).lightLevel(BlockState -> 4)), ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB);
    public static final RegistryObject<Block> NOTIUM_ORE = registerBlock("notium_ore", () -> new NotiumOre(BlockBehaviour.Properties.of(Material.STONE).lightLevel(BlockState -> 8).requiresCorrectToolForDrops().destroyTime(10000000)), ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB);
    public static final RegistryObject<Block> NOTIUM_ORE_DAMAGED = registerBlock("notium_ore_damaged", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).destroyTime(5).requiresCorrectToolForDrops()), ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB);

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
