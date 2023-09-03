package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.IntSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class TestingSpell extends Spell {
   
    public TestingSpell() 
    {
        super();
        spellNotes.add(notes.C);
        spellNotes.add(notes.D);
        spellNotes.add(notes.E);
        this.isEnabled = false;
    }

    public boolean runSpell(List<AbstractSymbol> stack, Player player, Level level)
    {
        if(!level.isClientSide) player.sendSystemMessage(Component.literal("DEBUGGING!!!!"));
        stack.add(new IntSymbol(1));
        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }

}
