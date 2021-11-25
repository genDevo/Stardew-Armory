package net.gendevo.stardewarmory.world.structures;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModStructures;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class ConfiguredStructureInit {

    public static StructureFeature<?, ?> CONFIGURED_GUILD_BUILDING =
            ModStructures.GUILD_BUILDING.get().configured(IFeatureConfig.NONE);

    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(
                StardewArmory.MOD_ID, "configured_guild_building"), CONFIGURED_GUILD_BUILDING);
        FlatGenerationSettings.STRUCTURE_FEATURES.put(ModStructures.GUILD_BUILDING.get(), CONFIGURED_GUILD_BUILDING);
    }
}