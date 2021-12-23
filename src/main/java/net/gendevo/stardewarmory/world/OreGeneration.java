package net.gendevo.stardewarmory.world;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OreGeneration {

    public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();
    public static final List<PlacedFeature> NETHER_ORES = new ArrayList<>();

    public static void registerOres() {
        final ConfiguredFeature<?, ?> iridiumOre = Feature.ORE.configured(
                        new OreConfiguration(List.of(
                                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES,
                                        ModBlocks.IRIDIUM_ORE.get().defaultBlockState()),
                                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.DEEPSLATE_IRIDIUM_ORE.get().defaultBlockState())
                        ),
                                5));
        final PlacedFeature placedIridiumOre = iridiumOre.placed(
                OrePlacements.commonOrePlacement(StardewArmoryConfig.iridium_rate.get(),
                HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(15))));

        final ConfiguredFeature<?, ?> cinderOre = Feature.ORE.configured(
                        new OreConfiguration(List.of(
                                OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES,
                                        ModBlocks.CINDER_ORE.get().defaultBlockState())
                        ),
                                8));
        final PlacedFeature placedCinderOre = cinderOre.placed(
                OrePlacements.commonOrePlacement(StardewArmoryConfig.cinder_rate.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top())));

        OVERWORLD_ORES.add(placedIridiumOre);
        NETHER_ORES.add(placedCinderOre);
    }

    @Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubsciber {
        @SubscribeEvent
        public static void biomeLoadingEvent(BiomeLoadingEvent event) {
            List<Supplier<PlacedFeature>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            if (event.getCategory() == Biome.BiomeCategory.NETHER) {
                OreGeneration.NETHER_ORES.forEach(ore -> features.add(() -> ore));
            } else {
                OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            }
        }
    }
}
