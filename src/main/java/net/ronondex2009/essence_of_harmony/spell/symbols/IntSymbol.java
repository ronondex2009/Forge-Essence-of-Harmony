package net.ronondex2009.essence_of_harmony.spell.symbols;

import java.io.Serializable;

import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;

public class IntSymbol extends AbstractSymbol implements Serializable
{
    private String type = "Integer";
    private int Value;
    public IntSymbol(int Value) {this.Value = Value;}
    public String toString()
    {
        return "Int:"+Value;
    }
    public int getValue() { return Value; }
    public String getSymbolType() {return type;}
}
