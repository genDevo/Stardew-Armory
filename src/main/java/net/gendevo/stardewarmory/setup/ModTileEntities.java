package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.tileentity.GalaxyForgeTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, StardewArmory.MOD_ID);

    public static RegistryObject<TileEntityType<?>> GALAXY_FORGE_TILE =
            TILE_ENTITIES.register("galaxy_forge_tile", () -> TileEntityType.Builder.of(
                    GalaxyForgeTile::new, ModBlocks.GALAXY_FORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
