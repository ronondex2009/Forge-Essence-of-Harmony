package net.ronondex2009.essence_of_harmony.spell;

import java.util.HashMap;
import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.ronondex2009.essence_of_harmony.spell.custom.ClearStackOperator;
import net.ronondex2009.essence_of_harmony.spell.custom.DirectionOperator;
import net.ronondex2009.essence_of_harmony.spell.custom.RevealStackSpell;
import net.ronondex2009.essence_of_harmony.spell.custom.SelfOperator;
import net.ronondex2009.essence_of_harmony.spell.custom.ShowEssenceOperator;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.spell.custom.BreakBlockSpell;
import net.ronondex2009.essence_of_harmony.spell.custom.LocationOperator;
import net.ronondex2009.essence_of_harmony.spell.custom.RaycastBlockOperator;
import net.ronondex2009.essence_of_harmony.spell.custom.TestingSpell;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;
import net.ronondex2009.essence_of_harmony.world.essenceMap;

public class ModSpells 
{
    public static final Spell TESTING_SPELL = new TestingSpell();
    public static final Spell CLEAR_STACK_OPERATOR = new ClearStackOperator();
    public static final Spell REVEAL_STACK_SPELL = new RevealStackSpell();
    public static final Spell SELF_OPERATOR = new SelfOperator();
    public static final Spell LOC_OPERATOR = new LocationOperator();
    public static final Spell DIR_OPERATOR = new DirectionOperator();
    public static final Spell RAYBLOCK_OPERATOR = new RaycastBlockOperator();
    public static final Spell BREAK_BLOCK_SPELL = new BreakBlockSpell();
    public static final Spell SHOW_ESSENCE_OPERATOR = new ShowEssenceOperator();

    public static boolean checkSpells(List<notes> notesToCheck, List<AbstractSymbol> stack, Player player, Level level)
    {
        if(TESTING_SPELL.checkSpell(notesToCheck, stack, player, level)) return true;
        if(CLEAR_STACK_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        if(REVEAL_STACK_SPELL.checkSpell(notesToCheck, stack, player, level)) return true;
        if(SELF_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        if(LOC_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        if(DIR_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        if(RAYBLOCK_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        if(BREAK_BLOCK_SPELL.checkSpell(notesToCheck, stack, player, level)) return true;
        if(SHOW_ESSENCE_OPERATOR.checkSpell(notesToCheck, stack, player, level)) return true;
        return false;
    }

    public static Float getSpellPower(Item item, Player player)
    {
        HashMap<Item, Float> itemPowerLevels = new HashMap<>();
        itemPowerLevels.put(ModItems.FLUTE.get(), 1f);
        itemPowerLevels.put(ModItems.OCARINA.get(), 5f);
        if(!itemPowerLevels.containsKey(item)) return 0f;
        Float itemPower = itemPowerLevels.get(item);
        Float essencePercent = essenceMap.getEssence(player.chunkPosition())/100f;

        // formula: https://www.desmos.com/calculator/1annna3e70
        return (float) (itemPower*Math.pow((essencePercent), 10/itemPower));
    }
    
    public static void register()
    {
        //unused
    }
}