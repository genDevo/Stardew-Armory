package net.gendevo.stardewarmory.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<GuildMasterEntity> GUILD_MASTER = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(StardewArmory.MODID, "guild_master"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, GuildMasterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.6f)).build());
}
