package net.ronondex2009.essence_of_harmony.spell.symbols;

import java.io.Serializable;

import net.minecraft.world.entity.Entity;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;

public class EntitySymbol extends AbstractSymbol implements Serializable
{
    private String type = "Entity";
    private int Value;
    public EntitySymbol(Entity Value) {this.Value = Value.getId();}
    public String toString()
    {
        return "Entity:"+Value;
    }
    public int getValue() { return Value; }
    public String getSymbolType() {return type;}
}
