package net.ronondex2009.essence_of_harmony.world.features;

import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;

public class ModPlacedFeatures 
{
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, essence_of_harmony.mod_id);

       public static final RegistryObject<PlacedFeature> ORE_NOTIUM = PLACED_FEATURES.register("ore_notium_placed", 
       () -> new PlacedFeature(ModConfiguredFeatures.NOTIUM_ORE.getHolder().get(), List.of(CountPlacement.of(30), InSquarePlacement.spread(), 
       HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(40)), BiomeFilter.biome())));


    public static void register(IEventBus eventBus)
    {
        PLACED_FEATURES.register(eventBus);
    }
}
