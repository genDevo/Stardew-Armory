package net.gendevo.stardewarmory.world;

import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class OrePlacement {
    public static final Holder<PlacedFeature> IRIDIUM_ORE_PLACED = PlacementUtils.register("iridum_ore_placed",
            OreGeneration.IRIUDM_ORE, OrePlacementUtils.commonOrePlacement(StardewArmoryConfig.iridium_rate.get(),
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-70), VerticalAnchor.aboveBottom(20))));

    public static final Holder<PlacedFeature> CINDER_ORE_PLACED = PlacementUtils.register("cinder_ore_placed",
            OreGeneration.CINDER_ORE, OrePlacementUtils.commonOrePlacement(StardewArmoryConfig.cinder_rate.get(),
                    PlacementUtils.RANGE_10_10));


}
