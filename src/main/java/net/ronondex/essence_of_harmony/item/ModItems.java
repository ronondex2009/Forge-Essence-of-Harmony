package net.ronondex.essence_of_harmony.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex.essence_of_harmony.essence_of_harmony;
import net.ronondex.essence_of_harmony.item.ModCreativeModeTab;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, essence_of_harmony.MODID);

    public static final RegistryObject<Item> FLUTE = ITEMS.register("flute", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EOH_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> OCARINA = ITEMS.register("ocarina", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EOH_CREATIVE_MODE_TAB)));
    public static final RegistryObject<Item> GUITAR = ITEMS.register("guitar", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EOH_CREATIVE_MODE_TAB)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}