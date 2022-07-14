package net.gendevo.stardewarmory.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<GalaxyForgeScreenHandler> GALAXY_FORGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(StardewArmory.MODID, "galaxy_forge"),
                    GalaxyForgeScreenHandler::new);

}
