package net.ronondex2009.essence_of_harmony.spell.custom;

import java.util.List;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.ronondex2009.essence_of_harmony.item.ModItems;
import net.ronondex2009.essence_of_harmony.sound.ModSounds;
import net.ronondex2009.essence_of_harmony.spell.symbols.VectorSymbol;
import net.ronondex2009.essence_of_harmony.util.AbstractSymbol;
import net.ronondex2009.essence_of_harmony.util.Spell;
import net.ronondex2009.essence_of_harmony.util.notes;

public class RaycastBlockOperator extends Spell {

    @Override
    public boolean runSpell(List<AbstractSymbol> stack, Player player, Level level) 
    {
        if(stack.size()<2) return false;
        if(!(stack.get(stack.size()-1).getSymbolType().equals("Vector"))) return false;
        if(!(stack.get(stack.size()-2).getSymbolType().equals("Vector"))) return false;
        
        VectorSymbol originSymbol = (VectorSymbol) stack.get(stack.size()-2);
        VectorSymbol directionSymbol = (VectorSymbol) stack.get(stack.size()-1);
        Vec3 origin = new Vec3(originSymbol.getX(), originSymbol.getY(), originSymbol.getZ());
        Vec3 direction = new Vec3(directionSymbol.getX()*20d, directionSymbol.getY()*20d, directionSymbol.getZ()*20d);

        BlockHitResult hitResult = level.clip(new ClipContext(origin, origin.add(direction), ClipContext.Block.COLLIDER, Fluid.NONE, null));
        
        stack.remove(stack.size()-2);
        stack.remove(stack.size()-1);
        stack.add(new VectorSymbol(hitResult.getBlockPos().getX(), hitResult.getBlockPos().getY(), hitResult.getBlockPos().getZ()));

        player.playSound(ModSounds.CAST_SPELL.get());
        return true;
    }
    
    public RaycastBlockOperator()
    {
        spellNotes.add(notes.C);
        spellNotes.add(notes.E);
        spellNotes.add(notes.G);
        spellNotes.add(notes.F);
        spellNotes.add(notes.G);
        spellNotes.add(notes.D);
        spellNotes.add(notes.G);
        spellNotes.add(notes.D);
        allowedInputs.add("Vector");
        allowedInputs.add("Vector");
        allowedInstruments.add(ModItems.FLUTE.get());
        allowedInstruments.add(ModItems.OCARINA.get());
        allowedInstruments.add(ModItems.GUITAR.get());
        allowedInstruments.add(ModItems.OVERDRIVE_GUITAR.get());
    }
}
