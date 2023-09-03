package net.ronondex2009.essence_of_harmony.spell.symbols;

import java.io.Serializable;

import net.minecraft.world.entity.Entity;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;

public class TrashSymbol extends AbstractSymbol implements Serializable
{
    private String type = "Trash";
    public TrashSymbol() {}
    public String toString()
    {
        return "BROKEN -- SOMETHING WENT WRONG IN THE MOD!";
    }
}
