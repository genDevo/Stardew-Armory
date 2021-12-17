package net.gendevo.stardewarmory.world.structures;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModStructures;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ConfiguredStructureInit {

    public static ConfiguredStructureFeature<?, ?> CONFIGURED_GUILD_BUILDING =
            ModStructures.GUILD_BUILDING.get().configured(NoneFeatureConfiguration.INSTANCE);


    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(StardewArmory.MOD_ID, "configured_run_down_house"), CONFIGURED_GUILD_BUILDING);
    }
}
