package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.VectorSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class BreakBlockSpell extends Spell {
    
    @Override
    public boolean runSpell(List<AbstractSymbol> stack, Player player, Level level) 
    {        
        if(stack.size()==0) return false;
        if(!(stack.get(stack.size()-1).getSymbolType().equals("Vector"))) return false;
        
        VectorSymbol location = (VectorSymbol) stack.get(stack.size()-1);
        level.destroyBlock(new BlockPos(location.getX(), location.getY(), location.getZ()), true);
        stack.remove(stack.size()-1);

        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }
    
    public BreakBlockSpell()
    {
        spellNotes.add(notes.C);
        spellNotes.add(notes.D);
        spellNotes.add(notes.F);
        spellNotes.add(notes.G);
        spellNotes.add(notes.D);
        spellNotes.add(notes.E);
        spellNotes.add(notes.F);
        spellNotes.add(notes.D);
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }
}
