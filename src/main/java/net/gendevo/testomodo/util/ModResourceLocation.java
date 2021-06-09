package net.gendevo.testomodo.util;

import net.gendevo.testomodo.TestoModo;
import net.minecraft.util.ResourceLocation;

public class ModResourceLocation extends ResourceLocation {
    public ModResourceLocation(String resourceName) {
        super(addModNamespace(resourceName));
    }

    private static String addModNamespace(String resourceName) {
        if (resourceName.contains(":")) {
            return resourceName;
        }
        return TestoModo.MOD_ID + ":" + resourceName;
    }
}
