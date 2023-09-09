package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.NotesSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class LiteralNotes extends Spell {

    @Override
    public boolean runSpell(List<notes> notesList, List<AbstractSymbol> stack, Player player, Level level) 
    {
        Boolean canContinue = false;
        if(notesList.get(notesList.size()-2).equals(notes.A) && notesList.get(notesList.size()-1).equals(notes.B))
            if(!(notesList.get(notesList.size()-4).equals(notes.B) && notesList.get(notesList.size()-3).equals(notes.A)))
                canContinue = true;
        
        if(!canContinue) return false;

        notes[] notesToReturn = new notes[notesList.size()-10];  

        for(int i = 0; i<notesList.size(); i++)
        {
            if(i<8) continue;
            if(i>=notesList.size()-2) continue;
            if(notesList.get(i).equals(notes.A) && notesList.get(i-1).equals(notes.B)) continue;
            if(notesList.get(i).equals(notes.B) && notesList.get(i+1).equals(notes.A)) continue;
            notesToReturn[i-8] = notesList.get(i);
        }
        stack.add(new NotesSymbol(notesToReturn));

        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }
    
    public LiteralNotes()
    {
        spellNotes.add(notes.D);
        spellNotes.add(notes.G);
        spellNotes.add(notes.E);
        spellNotes.add(notes.F);
        spellNotes.add(notes.B);
        spellNotes.add(notes.A);
        spellNotes.add(notes.B);
        spellNotes.add(notes.G);
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }
}
