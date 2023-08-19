package net.ronondex2009.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, essence_of_harmony.mod_id);

    public static final RegistryObject<Item> NOTIUM = ITEMS.register("notium", () -> new Item(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> NOTIUM_DAMAGED = ITEMS.register("notium_damaged", () -> new Item(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MATERIALS)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
