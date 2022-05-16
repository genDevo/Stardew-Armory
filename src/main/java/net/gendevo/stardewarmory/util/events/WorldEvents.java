package net.gendevo.stardewarmory.util.events;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.world.OrePlacement;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID)
public class WorldEvents {
    @SubscribeEvent
    public static void generateOres(final BiomeLoadingEvent e) {
        List<Holder<PlacedFeature>> base = e.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(OrePlacement.IRIDIUM_ORE_PLACED);
        if (e.getCategory() == Biome.BiomeCategory.NETHER) {
            base.add(OrePlacement.CINDER_ORE_PLACED);
        }
    }
}
