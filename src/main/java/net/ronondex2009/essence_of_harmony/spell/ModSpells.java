package net.ronondex2009.essence_of_harmony.spell;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.spell.custom.ClearStackSpell;
import net.ronondex2009.essence_of_harmony.spell.custom.RevealStackSpell;
import net.ronondex2009.essence_of_harmony.spell.custom.SelfOperator;
import net.ronondex2009.essence_of_harmony.spell.custom.TestingSpell;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;
import org.apache.commons.lang3.ArrayUtils;

public class ModSpells 
{
    static Spell[] SPELLS = new Spell[0];

    public static boolean checkSpells(List<notes> notesToCheck, List<AbstractSymbol> stack, Player player, Level level) //this function checks if you used a spell
    {
        for (Spell spell: SPELLS) {
            if (spell.checkSpell(notesToCheck, stack, player, level)) {
                return true;
            }
        }
        return false;
    }
    
    public static void register(Spell spell)//Use this function to register a new music spell!
    {
        //Dev Note: Jelo Waso: I am seething, why was this empty and unused and a stack of if statements was used instead?!
        SPELLS = ArrayUtils.add(SPELLS, spell);
    }
}