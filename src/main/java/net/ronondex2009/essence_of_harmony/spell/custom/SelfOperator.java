package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.EntitySymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class SelfOperator extends Spell {

    @Override
    public boolean runSpell(List<notes> notes, List<AbstractSymbol> stack, Player player, Level level) 
    {
        stack.add(new EntitySymbol(player));
        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }
    
    public SelfOperator()
    {
        spellNotes.add(notes.C);
        spellNotes.add(notes.E);
        spellNotes.add(notes.G);
        spellNotes.add(notes.E);
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }
}
