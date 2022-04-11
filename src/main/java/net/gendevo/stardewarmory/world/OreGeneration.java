package net.gendevo.stardewarmory.world;

import net.gendevo.stardewarmory.setup.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class OreGeneration {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_IRIDIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.IRIDIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_IRIDIUM_ORE.get().defaultBlockState())
    );

    public static final List<OreConfiguration.TargetBlockState> NETHER_CINDER_ORE = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.CINDER_ORE.get().defaultBlockState())
    );

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> IRIUDM_ORE = FeatureUtils.register("iridium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_IRIDIUM_ORES, 5));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> CINDER_ORE = FeatureUtils.register("cinder_ore",
            Feature.ORE, new OreConfiguration(NETHER_CINDER_ORE, 8));
}