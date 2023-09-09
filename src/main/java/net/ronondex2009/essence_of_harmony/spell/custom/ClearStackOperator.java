package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class ClearStackOperator extends Spell 
{
    @Override
    public boolean runSpell(List<notes> notes, List<AbstractSymbol> stack, Player player, Level level) {
        stack.clear();
        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }

    public ClearStackOperator()
    {
        spellNotes.add(notes.G);
        spellNotes.add(notes.E);
        spellNotes.add(notes.D);
        spellNotes.add(notes.E);
        spellNotes.add(notes.C);
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }

}
