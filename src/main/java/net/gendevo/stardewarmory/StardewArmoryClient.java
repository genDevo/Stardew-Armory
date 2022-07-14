package net.gendevo.stardewarmory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.gendevo.stardewarmory.entity.ModEntities;
import net.gendevo.stardewarmory.entity.client.GuildMasterModel;
import net.gendevo.stardewarmory.entity.client.GuildMasterRenderer;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreen;
import net.gendevo.stardewarmory.screen.ModScreenHandlers;

@Environment(EnvType.CLIENT)
public class StardewArmoryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.GALAXY_FORGE_SCREEN_HANDLER, GalaxyForgeScreen::new);

        EntityModelLayerRegistry.registerModelLayer(GuildMasterModel.LAYER_LOCATION, GuildMasterModel::createBodyLayer);
        EntityRendererRegistry.register(ModEntities.GUILD_MASTER, GuildMasterRenderer::new);
    }
}
