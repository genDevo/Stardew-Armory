package net.gendevo.stardewarmory.recipe;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipe {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(StardewArmory.MODID, GalaxyForgeRecipe.Serializer.ID),
                GalaxyForgeRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(StardewArmory.MODID, GalaxyForgeRecipe.Type.ID),
                GalaxyForgeRecipe.Type.INSTANCE);
    }
}
