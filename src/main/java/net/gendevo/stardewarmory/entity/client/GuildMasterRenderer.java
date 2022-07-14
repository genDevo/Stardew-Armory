package net.gendevo.stardewarmory.entity.client;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.entity.GuildMasterEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GuildMasterRenderer extends MobEntityRenderer<GuildMasterEntity, GuildMasterModel> {
    protected static final Identifier TEXTURE = new Identifier(StardewArmory.MODID, "textures/entity/guild_master.png");

    public GuildMasterRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GuildMasterModel(ctx.getPart(GuildMasterModel.LAYER_LOCATION)), 0.7f);
    }

    @Override
    public Identifier getTexture(GuildMasterEntity entity) {
        return TEXTURE;
    }
}
