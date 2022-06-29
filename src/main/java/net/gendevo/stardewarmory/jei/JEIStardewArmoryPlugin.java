package net.gendevo.stardewarmory.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.data.recipes.GalaxyForgeRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

// @JeiPlugin
public class JEIStardewArmoryPlugin {//implements IModPlugin {
//    @Override
//    public ResourceLocation getPluginUid() {
//        return new ResourceLocation(StardewArmory.MOD_ID, "jei_plugin");
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration) {
//        registration.addRecipeCategories(new GalaxyForgeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
//        List<GalaxyForgeRecipe> recipes = rm.getAllRecipesFor(GalaxyForgeRecipe.Type.INSTANCE);
//        registration.addRecipes(new RecipeType<>(GalaxyForgeRecipeCategory.UID, GalaxyForgeRecipe.class), recipes);
//    }
}
