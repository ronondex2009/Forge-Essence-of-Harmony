package net.ronondex2009.essence_of_harmony.spell;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.spell.custom.ClearStackSpell;
import net.ronondex2009.essence_of_harmony.spell.custom.RevealStackSpell;
import net.ronondex2009.essence_of_harmony.spell.custom.TestingSpell;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class ModSpells 
{
    public static final Spell TESTING_SPELL = new TestingSpell();
    public static final Spell CLEAR_STACK_OPERATOR = new ClearStackSpell();
    public static final Spell REVEAL_STACK_SPELL = new RevealStackSpell();

    public static boolean checkSpells(List<notes> notesToCheck, List<AbstractSymbol> stack, Player player, Level level)
    {
        if(TESTING_SPELL.checkSpell(notesToCheck, stack, player, level)) return true;
        if(CLEAR_STACK_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        if(REVEAL_STACK_SPELL.checkSpell(notesToCheck, stack, player, level)) return true;
        return false;
    }
    
    public static void register()
    {
        //unused
    }
}