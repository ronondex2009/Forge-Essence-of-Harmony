package net.ronondex2009.essence_of_harmony.spell.symbols;

import java.io.Serializable;

import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.notes;

public class NotesSymbol extends AbstractSymbol implements Serializable
{
    private String type = "Notes";
    private notes[] notesArray;
    public NotesSymbol(notes[] i) {this.notesArray = i;}
    public String toString()
    {
        return "notes(" + notesArray.toString();
    }
    public String getSymbolType() {return type;}
    public notes[] getNotes() {return notesArray;}
}
