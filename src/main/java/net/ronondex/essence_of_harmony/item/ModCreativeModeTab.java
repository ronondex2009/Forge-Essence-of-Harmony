package net.ronondex.essence_of_harmony.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab EOH_CREATIVE_MODE_TAB = new CreativeModeTab("Essence of Harmony") {
        @Override
        public ItemStack makeIcon(){
            return new ItemStack(ModItems.FLUTE.get());
        }
    };
}
