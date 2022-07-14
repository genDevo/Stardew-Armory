package net.gendevo.stardewarmory.world.feature;

import net.gendevo.stardewarmory.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_IRIDIUM_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                    ModBlocks.IRIDIUM_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                    ModBlocks.DEEPSLATE_IRIDIUM_ORE.getDefaultState()));

    public static final List<OreFeatureConfig.Target> NETHER_CINDER_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.BASE_STONE_NETHER,
                    ModBlocks.CINDER_ORE.getDefaultState()));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> IRIDIUM_ORE =
            ConfiguredFeatures.register("iridium_ore", Feature.ORE,
                    new OreFeatureConfig(OVERWORLD_IRIDIUM_ORES, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> CINDER_ORE =
            ConfiguredFeatures.register("cinder_ore",Feature.ORE,
                    new OreFeatureConfig(NETHER_CINDER_ORE, 12));
}
