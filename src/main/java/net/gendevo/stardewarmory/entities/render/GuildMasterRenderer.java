package net.gendevo.stardewarmory.entities.render;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.gendevo.stardewarmory.entities.model.GuildMasterModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GuildMasterRenderer extends MobRenderer<GuildMasterEntity, GuildMasterModel> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(StardewArmory.MOD_ID, "textures/entity/guild_master.png");

    public GuildMasterRenderer(EntityRendererProvider.Context context) {
        super(context, new GuildMasterModel(context.bakeLayer(GuildMasterModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public ResourceLocation getTextureLocation(GuildMasterEntity p_110775_1_) {
        return TEXTURE;
    }
}
