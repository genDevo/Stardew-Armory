package net.gendevo.stardewarmory.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<GalaxyForgeBlockEntity> GALAXY_FORGE_BLOCK_ENTITY =
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(StardewArmory.MODID, "galaxy_forge"),
                    FabricBlockEntityTypeBuilder.create(GalaxyForgeBlockEntity::new,
                            ModBlocks.GALAXY_FORGE).build(null));
}
