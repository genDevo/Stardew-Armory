package net.gendevo.stardewarmory.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.entity.GuildMasterEntity;
import net.gendevo.stardewarmory.entity.ModEntities;
import net.gendevo.stardewarmory.item.ModItems;

public class ModRegistries {

    public static void registerMisc() {
        registerCinderFuel();
        registerAttributes();
    }

    private static void registerCinderFuel() {
        StardewArmory.LOGGER.info("Registering CINDER SHARDS as fuel");
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.CINDER_SHARD, 6400);
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.GUILD_MASTER, GuildMasterEntity.setAttributes());
    }
}
