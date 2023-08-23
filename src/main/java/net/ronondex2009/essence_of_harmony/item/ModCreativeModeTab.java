package net.ronondex2009.essence_of_harmony.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ESSENCE_OF_HARMONY_TAB = new CreativeModeTab("essence_of_harmony_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.NOTIUM.get());
        }
    };
}
