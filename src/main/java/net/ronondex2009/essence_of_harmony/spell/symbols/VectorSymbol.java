package net.ronondex2009.essence_of_harmony.spell.symbols;

import java.io.Serializable;

import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;

public class VectorSymbol extends AbstractSymbol implements Serializable
{
    private String type = "Vector";
    private double x;
    private double y;
    private double z;
    public VectorSymbol(double x, double y, double z) {this.x = x; this.y = y; this.z = z;}
    public String toString()
    {
        return "Vec:("+x+", "+y+", "+z+")";
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    public String getSymbolType() {return type;}
}