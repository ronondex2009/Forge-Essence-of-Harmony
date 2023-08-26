package net.ronondex2009.essence_of_harmony.util;

public final class PitchDict 
{
    public static float noteToPitch(int note) { return (float)(Math.pow(2, (double)((float)note-6)/12)); }
    public static float noteToPitch(notes note) { return noteToPitch(note.ordinal()); }
}