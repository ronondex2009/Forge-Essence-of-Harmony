package net.ronondex2009.essence_of_harmony.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, essence_of_harmony.mod_id);

    public static final RegistryObject<Item> FLUTE = ITEMS.register("flute", () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB)));
    public static final RegistryObject<Item> OCARINA = ITEMS.register("ocarina", () -> new Item(new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB)));
    public static final RegistryObject<Item> NOTIUM = ITEMS.register("notium", () -> new Item(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB)));
    public static final RegistryObject<Item> NOTIUM_DAMAGED = ITEMS.register("notium_damaged", () -> new Item(new Item.Properties().stacksTo(16).tab(ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB)));
    @SuppressWarnings("deprecation")
    public static final RegistryObject<Item> MUSIC_DISC_CORRUPTION = ITEMS.register("corrupt_disc", () -> new RecordItem(1, ModSounds.CORRUPT_DISC.get(), (new Item.Properties()).stacksTo(1).tab(ModCreativeModeTab.ESSENCE_OF_HARMONY_TAB).rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
