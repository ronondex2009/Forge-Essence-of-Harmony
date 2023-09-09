package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.spell.ModSpells;
import net.ronondex2009.essence_of_harmony.spell.symbols.NotesSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class Execute extends Spell
{

    @Override
    public boolean runSpell(List<notes> notesList, List<AbstractSymbol> stack, Player player, Level level) 
    {
        if(stack.size() == 0) return false;
        if(!stack.get(stack.size()-1).getSymbolType().equals("Notes")) return false;

        NotesSymbol symbol = (NotesSymbol)stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        notesList.clear();

        for(notes note : symbol.getNotes())
        {
            notesList.add(note);
            //this is already executing on the server AND client, so no packets need be sent.
            if(ModSpells.checkSpells(notesList, stack, player, level)) notesList.clear();
        }

        return true;
    }

    public Execute() 
    {
        spellNotes.add(notes.B);
        spellNotes.add(notes.G);
        spellNotes.add(notes.E);
        spellNotes.add(notes.G);
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
