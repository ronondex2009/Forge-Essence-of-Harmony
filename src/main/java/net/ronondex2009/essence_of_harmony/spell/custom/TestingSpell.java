package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.IntSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class TestingSpell extends Spell {
   
    public TestingSpell() 
    {
        spellNotes.add(notes.C);
        spellNotes.add(notes.D);
        spellNotes.add(notes.E);
        this.isEnabled = false;
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }

    public boolean runSpell(List<notes> notes, List<AbstractSymbol> stack, Player player, Level level)
    {
        player.playSound(ModSounds.CAST_SPELL.get());
        stack.add(new IntSymbol(1));
        return true;
    }

}
