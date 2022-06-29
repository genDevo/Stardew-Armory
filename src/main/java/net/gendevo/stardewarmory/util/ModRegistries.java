package net.gendevo.stardewarmory.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.item.ModItems;

public class ModRegistries {

    public static void registerMisc() {
        registerCinderFuel();
    }

    private static void registerCinderFuel() {
        StardewArmory.LOGGER.info("Registering CINDER SHARDS as fuel");
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.CINDER_SHARD, 6400);
    }
}
