package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;
import net.ronondex2009.essence_of_harmony.world.essenceMap;

public class ShowEssenceOperator extends Spell {
    
    @Override
    public boolean runSpell(List<notes> notes, List<AbstractSymbol> stack, Player player, Level level) 
    {
        if(level.isClientSide)
            player.sendSystemMessage(Component.literal("Essence Measurement: " + 
                Math.floor(essenceMap.getEssence(player.chunkPosition()))).withStyle(ChatFormatting.GOLD));
        return true;
    }

    public ShowEssenceOperator()
    {
        this.spellNotes.add(notes.D);
        this.spellNotes.add(notes.F);
        this.spellNotes.add(notes.E);
        this.spellNotes.add(notes.D);
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }
}
