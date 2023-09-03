package net.ronondex2009.essence_of_harmony.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.event.ClientEvents;

public class Instrument extends Item {

    public Instrument(Item.Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(level.isClientSide)
        {
            ClientEvents.notesPlayed.clear();
        }
        return super.use(level, player, hand);
    }   
}
