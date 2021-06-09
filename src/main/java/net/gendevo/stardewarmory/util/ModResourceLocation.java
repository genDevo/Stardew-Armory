package net.gendevo.stardewarmory.util;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.util.ResourceLocation;

public class ModResourceLocation extends ResourceLocation {
    public ModResourceLocation(String resourceName) {
        super(addModNamespace(resourceName));
    }

    private static String addModNamespace(String resourceName) {
        if (resourceName.contains(":")) {
            return resourceName;
        }
        return StardewArmory.MOD_ID + ":" + resourceName;
    }
}
