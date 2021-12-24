package net.gendevo.stardewarmory.world;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OreGeneration {

    public static final List<ConfiguredFeature<?, ?>> OVERWORLD_ORES = new ArrayList<>();
    public static final List<ConfiguredFeature<?, ?>> NETHER_ORES = new ArrayList<>();

    public static void registerOres() {
        ConfiguredFeature<?, ?> iridiumOre = Feature.ORE.configured(
                        new OreConfiguration(List.of(
                                OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES,
                                        ModBlocks.IRIDIUM_ORE.get().defaultBlockState()),
                                OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES,
                                        ModBlocks.DEEPSLATE_IRIDIUM_ORE.get().defaultBlockState())
                        ),
                                5))
                .rangeTriangle(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(15))
                .squared().count(StardewArmoryConfig.iridium_rate.get());
        ConfiguredFeature<?, ?> cinderOre = Feature.ORE.configured(
                        new OreConfiguration(List.of(
                                OreConfiguration.target(OreConfiguration.Predicates.NETHER_ORE_REPLACEABLES,
                                        ModBlocks.CINDER_ORE.get().defaultBlockState())
                        ),
                                8))
                .rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.top())
                .squared().count(StardewArmoryConfig.cinder_rate.get());
        OVERWORLD_ORES.add(register("iridium_ore", iridiumOre));
        NETHER_ORES.add(register("cinder_ore", cinderOre));
    }

    private static <Config extends FeatureConfiguration> ConfiguredFeature<Config, ?> register(String name, ConfiguredFeature<Config, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(StardewArmory.MOD_ID, name), feature);
    }

    @Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeBusSubsciber {
        @SubscribeEvent
        public static void biomeLoadingEvent(BiomeLoadingEvent event) {
            List<Supplier<ConfiguredFeature<?,?>>> features = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);
            if (event.getCategory() == Biome.BiomeCategory.NETHER) {
                OreGeneration.NETHER_ORES.forEach(ore -> features.add(() -> ore));
            } else {
                OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(() -> ore));
            }
        }
    }

    //public static void generateOres(final BiomeLoadingEvent event) {
    //    if (event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
    //        return;
    //    } else if (event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
    //        generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NETHERRACK, ModBlocks.CINDER_ORE.get().defaultBlockState(),
    //                8, 1, 250, StardewArmoryConfig.cinder_rate.get());
    //    } else {
    //        generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.IRIDIUM_ORE.get().defaultBlockState(),
    //                4, 1, 13, StardewArmoryConfig.iridium_rate.get());
    //    }
    //}
//
    //private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
    //    settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
    //                Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize))
    //                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
    //                        .squared().count(amount));
    //}
}
