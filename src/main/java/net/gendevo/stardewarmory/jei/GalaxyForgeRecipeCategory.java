package net.gendevo.stardewarmory.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.data.recipes.GalaxyForgeRecipe;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class GalaxyForgeRecipeCategory implements IRecipeCategory<GalaxyForgeRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(StardewArmory.MOD_ID, "galaxy_forge");
    public static final ResourceLocation TEXTURE = new ResourceLocation(StardewArmory.MOD_ID, "textures/gui/galaxy_forge_gui_jei.png");

    private final IDrawable background;
    private final IDrawable icon;

    public GalaxyForgeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.GALAXY_FORGE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends GalaxyForgeRecipe> getRecipeClass() {
        return GalaxyForgeRecipe.class;
    }

    @Override
    public Component getTitle() {
        return ModBlocks.GALAXY_FORGE.get().getName();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(GalaxyForgeRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, GalaxyForgeRecipe recipe, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0,true, 115,46);
        recipeLayout.getItemStacks().init(1,true, 41,46);

        recipeLayout.getItemStacks().init(2,false, 13,46);
        recipeLayout.getItemStacks().set(ingredients);
    }
}
