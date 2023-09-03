package net.ronondex2009.essence_of_harmony.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.spell.ModSpells;

public class Spell 
{

    public List<AbstractSymbol> allowedInputs = new ArrayList<>(); //can be empty TODO unused
    public List<AbstractSymbol> allowedOutputs = new ArrayList<>(); //can be empty TODO unused
    public List<Item> allowedInstruments = new ArrayList<>(); //if empty, will default to all instruments. TODO unused
    public List<notes> spellNotes = new ArrayList<>(); //cannot be empty
    public int baseEssenceUsage = 0; //default value TODO add when feature exists
    public Boolean isEnabled = true;

    public Spell () {
        ModSpells.register(this);
    }

    public boolean checkSpell(List<notes> notesToCheck, List<AbstractSymbol> stack, Player player, Level level)
    {
        if(!isEnabled) return false;
        if(spellNotes.equals(notesToCheck)) return runSpell(stack, player, level);
        else return false;
    }

    public boolean runSpell(List<AbstractSymbol> stack, Player player, Level level)
    {

        return true;
    }

    //STACK FROM TOP-TO-BOTTOM IS LEFT-TO-RIGHT
    //NOTES ARE LEFT-TO-RIGHT FOR START-TO-FINISH
    //SPELLS CAN INTERACT WITH THE WORLD

}

//this file handles the definition of a spell.