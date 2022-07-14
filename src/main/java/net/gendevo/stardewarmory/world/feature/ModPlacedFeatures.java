package net.gendevo.stardewarmory.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

public class ModPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> IRIDIUM_ORE_PLACED = PlacedFeatures.register("iridium_ore_placed",
            ModConfiguredFeatures.IRIDIUM_ORE, ModOreFeatures.modifiersWithCount(6,
                    HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(20))));

    public static final RegistryEntry<PlacedFeature> CINDER_ORE_PLACED = PlacedFeatures.register("cinder_ore_placed",
            ModConfiguredFeatures.CINDER_ORE, ModOreFeatures.modifiersWithCount(20, // Veins per chunk
                    HeightRangePlacementModifier.uniform(YOffset.aboveBottom(10), YOffset.belowTop(10))));
}
