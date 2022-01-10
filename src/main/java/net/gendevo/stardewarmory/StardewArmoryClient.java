package net.gendevo.stardewarmory;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreen;
import net.gendevo.stardewarmory.screen.ModScreenHandlers;

@Environment(EnvType.CLIENT)
public class StardewArmoryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.GALAXY_FORGE_SCREEN_HANDLER, GalaxyForgeScreen::new);
    }
}
