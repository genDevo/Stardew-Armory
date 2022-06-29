package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.world.OreGeneration;
import net.gendevo.stardewarmory.world.OrePlacementUtils;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, StardewArmory.MOD_ID);

    public static final RegistryObject<PlacedFeature> IRIDIUM_ORE_PLACED = PLACED_FEATURES.register("iridum_ore_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            OreGeneration.IRIUDM_ORE, OrePlacementUtils.commonOrePlacement(StardewArmoryConfig.iridium_rate.get(),
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(20)))));

    public static final RegistryObject<PlacedFeature> CINDER_ORE_PLACED = PLACED_FEATURES.register("cinder_ore_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
            OreGeneration.CINDER_ORE, OrePlacementUtils.commonOrePlacement(StardewArmoryConfig.cinder_rate.get(),
                    PlacementUtils.RANGE_10_10)));


}
