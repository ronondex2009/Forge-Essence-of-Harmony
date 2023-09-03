package net.ronondex2009.essence_of_harmony.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class Spell 
{
    
    public List<String> allowedInputs = new ArrayList<>(); //can be empty TODO unused
    public List<Item> allowedInstruments = new ArrayList<>(); //if empty, will default to all instruments. TODO unused
    public List<notes> spellNotes = new ArrayList<>(); //cannot be empty
    public int baseEssenceUsage = 0; //default value TODO add when feature exists
    public Boolean isEnabled = true;

    public boolean checkSpell(List<notes> notesToCheck, List<AbstractSymbol> stack, Player player, Level level)
    {
        if(!isEnabled) return false;
        boolean isValid = false;
        //for(Item item : allowedInstruments)
            //if(item.equals(player.getMainHandItem().getItem()))
                isValid = true;
        if(spellNotes.equals(notesToCheck)&&isValid) return runSpell(stack, player, level);
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