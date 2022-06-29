package net.gendevo.stardewarmory.jei;

public class GalaxyForgeRecipeCategory {//implements IRecipeCategory<GalaxyForgeRecipe> {
//    public static final ResourceLocation UID = new ResourceLocation(StardewArmory.MOD_ID, "galaxy_forge");
//    public static final ResourceLocation TEXTURE = new ResourceLocation(StardewArmory.MOD_ID, "textures/gui/galaxy_forge_gui_jei.png");
//
//    private final IDrawable background;
//    private final IDrawable icon;
//
//    public GalaxyForgeRecipeCategory(IGuiHelper helper) {
//        this.background = helper.createDrawable(TEXTURE, 0,0,176,85);
//        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.GALAXY_FORGE.get()));
//    }
//
//    @Override
//    public @Nullable ResourceLocation getRegistryName(GalaxyForgeRecipe recipe) {
//        return UID;
//    }
//
//    @Override
//    public RecipeType<GalaxyForgeRecipe> getRecipeType() {
//        return GalaxyForgeRecipe.Type.INSTANCE;
//    }
//
//    @Override
//    public Component getTitle() {
//        return ModBlocks.GALAXY_FORGE.get().getName();
//    }
//
//    @Override
//    public IDrawable getBackground() {
//        return this.background;
//    }
//
//    @Override
//    public IDrawable getIcon() {
//        return this.icon;
//    }
//
//    @Override
//    public void setRecipe(IRecipeLayoutBuilder builder, GalaxyForgeRecipe recipe, IFocusGroup focuses) {
//        builder.addSlot(RecipeIngredientRole.INPUT, 115, 46).addIngredients(recipe.getIngredients().get(0));
//        builder.addSlot(RecipeIngredientRole.INPUT, 41, 46).addIngredients(recipe.getIngredients().get(1));
//        builder.addSlot(RecipeIngredientRole.OUTPUT, 13, 46).addItemStack(recipe.getResultItem());
//    }
}
