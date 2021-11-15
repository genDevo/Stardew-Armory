package net.gendevo.stardewarmory.data.client.render;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.data.client.model.GuildMasterModel;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GuildMasterRenderer extends MobRenderer<GuildMasterEntity, GuildMasterModel<GuildMasterEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(StardewArmory.MOD_ID, "textures/entity/guild_master.png");

    public GuildMasterRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new GuildMasterModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(GuildMasterEntity p_110775_1_) {
        return TEXTURE;
    }
}
