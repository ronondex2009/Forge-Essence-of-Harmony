package net.ronondex2009.essence_of_harmony.world.features;

import java.util.List;
import java.util.function.Supplier;

import com.google.common.base.Suppliers;

import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.ronondex2009.essence_of_harmony.essence_of_harmony;
import net.ronondex2009.essence_of_harmony.block.ModBlocks;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, essence_of_harmony.mod_id);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_NOTIUM_ORE = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.NOTIUM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> NOTIUM_ORE = CONFIGURED_FEATURE.register("notium_ore", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_NOTIUM_ORE.get(), 4)));

    public static void register(IEventBus eventBus)
    {
        CONFIGURED_FEATURE.register(eventBus);
    }
}
