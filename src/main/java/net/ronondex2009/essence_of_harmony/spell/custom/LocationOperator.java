package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.EntitySymbol;
import net.ronondex2009.essence_of_harmony.spell.symbols.VectorSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class LocationOperator extends Spell {

    @Override
    public boolean runSpell(List<AbstractSymbol> stack, Player player, Level level) 
    {
        if(stack.size()==0) return false;
        if(!(stack.get(stack.size()-1).getSymbolType().equals("Entity"))) return false;
        
        EntitySymbol entitySymbol = (EntitySymbol) stack.get(stack.size()-1);
        Entity entity = level.getEntity(entitySymbol.getValue());
        stack.remove(stack.size()-1);
        stack.add(new VectorSymbol(entity.getX(), entity.getEyeY(), entity.getZ()));
        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }
    
    public LocationOperator()
    {
        spellNotes.add(notes.B);
        spellNotes.add(notes.E);
        spellNotes.add(notes.G);
        spellNotes.add(notes.E);
        allowedInputs.add("Entity");
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }
}
