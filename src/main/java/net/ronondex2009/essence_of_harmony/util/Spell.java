package net.ronondex2009.essence_of_harmony.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.spell.ModSpells;
import net.ronondex2009.essence_of_harmony.world.essenceMap;

public class Spell 
{
    
    public List<Item> allowedInstruments = new ArrayList<>(); //if empty, will default to all instruments.
    public List<notes> spellNotes = new ArrayList<>(); //cannot be empty
    public float baseEssenceUsage = 0; //multiplied by powerlevel. Be careful!
    public float power; //leave empty
    public Boolean isEnabled = true;

    public boolean checkSpell(List<notes> notesToCheck, List<AbstractSymbol> stack, Player player, Level level)
    {
        if(!isEnabled) return false;
        boolean isValid = false;
        for(Item item : allowedInstruments)
            if(item.equals(player.getMainHandItem().getItem()))
                isValid = true;
        if((equalsAtBeginning(spellNotes, notesToCheck)) && isValid) 
        {
            power = ModSpells.getSpellPower(player.getMainHandItem().getItem(), player);
            if(runSpell(notesToCheck, stack, player, level))
            {
                runEssenceDepleter(stack, player, level);
                return true;
            }
            else return false;
        }
        else return false;
    }

    public boolean runSpell(List<notes> notes, List<AbstractSymbol> stack, Player player, Level level)
    {
        return true;
    }

    public void runEssenceDepleter(List<AbstractSymbol> stack, Player player, Level level)
    {
        removeEssence(power*baseEssenceUsage, player);
    }

    public void removeEssence(Float value, Player player)
    {
        essenceMap.setEssence(player.chunkPosition(), essenceMap.getEssence(player.chunkPosition()) - value);
    }   

    private Boolean equalsAtBeginning(List<notes> a, List<notes> b)
    {
        for(int i = 0; i<a.size(); i++)
        {
            if(b.size()<a.size()) return false;
            if(!(a.get(i).equals(b.get(i)))) return false;
        }
        return true;
    }

    //STACK FROM TOP-TO-BOTTOM IS LEFT-TO-RIGHT
    //NOTES ARE LEFT-TO-RIGHT FOR START-TO-FINISH
    //SPELLS CAN INTERACT WITH THE WORLD

}

//this file handles the definition of a spell.