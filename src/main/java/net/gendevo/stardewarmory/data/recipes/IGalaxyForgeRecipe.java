package net.gendevo.stardewarmory.data.recipes;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public interface IGalaxyForgeRecipe extends Recipe<Container> {
    ResourceLocation TYPE_ID = new ResourceLocation(StardewArmory.MOD_ID, "lightning");

    @Override
    default RecipeType<?> getType(){
        return Registry.RECIPE_TYPE.getOptional(TYPE_ID).get();
    }

    @Override
    default boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    default boolean isSpecial(){
        return true;
    }
}
