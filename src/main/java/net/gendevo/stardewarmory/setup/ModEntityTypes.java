package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, StardewArmory.MOD_ID);

    public static final RegistryObject<EntityType<GuildMasterEntity>> GUILD_MASTER = ENTITY_TYPES.register("guild_master",
            () -> EntityType.Builder.of(GuildMasterEntity::new, EntityClassification.CREATURE)
                    .sized(0.6f, 1.6f)
                    .build(new ResourceLocation(StardewArmory.MOD_ID, "guild_master").toString()));
}
