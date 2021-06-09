package net.gendevo.stardewarmory.data.client;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;


import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        // Crafting Recipes
        ShapelessRecipeBuilder.shapeless(ModItems.PRISMATIC_SHARD.get(), 9)
                .requires(ModBlocks.PRISMATIC_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.PRISMATIC_SHARD.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.PRISMATIC_BLOCK.get())
                .define('#', ModItems.PRISMATIC_SHARD.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.PRISMATIC_SHARD.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.GALAXY_SWORD.get())
                .define('#', ModItems.PRISMATIC_SHARD.get())
                .define('s', ModItems.REINFORCED_HANDLE.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" s ")
                .unlockedBy("has_item", has(ModItems.PRISMATIC_SHARD.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.OSSIFIED_BLADE.get())
                .define('#', ModItems.BONE_SWORD.get())
                .define('p', ModItems.PREHISTORIC_SCAPULA.get())
                .define('b', Items.BONE)
                .pattern(" # ")
                .pattern(" p ")
                .pattern(" b ")
                .unlockedBy("has_item", has(ModItems.PREHISTORIC_SCAPULA.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRON_EDGE.get())
                .define('#', Items.IRON_INGOT)
                .define('n', Items.IRON_NUGGET)
                .define('s', Items.STICK)
                .pattern(" # ")
                .pattern("n#n")
                .pattern(" s ")
                .unlockedBy("has_item", has(Items.IRON_INGOT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.OBSIDIAN_EDGE.get())
                .define('#', Items.OBSIDIAN)
                .define('s', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" s ")
                .unlockedBy("has_item", has(Items.OBSIDIAN))
                .save(consumer);
        //Cooking recipes
        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.PRISMATIC_ORE.get()), ModItems.PRISMATIC_SHARD.get(), 1.5f, 200)
                .unlockedBy("has_item", has(ModBlocks.PRISMATIC_ORE.get()))
                .save(consumer, modId("prismatic_shard_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.PRISMATIC_ORE.get()), ModItems.PRISMATIC_SHARD.get(), 1.5f, 100)
                .unlockedBy("has_item", has(ModBlocks.PRISMATIC_ORE.get()))
                .save(consumer, modId("prismatic_shard_blasting"));
        // Smithing recipes
        SmithingRecipeBuilder.smithing(Ingredient.of(Items.STICK), Ingredient.of(Items.NETHERITE_INGOT), ModItems.REINFORCED_HANDLE.get())
                .unlocks("has_item", has(Items.NETHERITE_INGOT))
                .save(consumer, modId("reinforced_handle_smithing"));
        SmithingRecipeBuilder.smithing(Ingredient.of(ModItems.CUTLASS.get()), Ingredient.of(ModItems.DRAGON_TOOTH.get()), ModItems.DRAGONTOOTH_CUTLASS.get())
                .unlocks("has_item", has(ModItems.DRAGON_TOOTH.get()))
                .save(consumer, modId("dragontooth_cutlass_smithing"));
        SmithingRecipeBuilder.smithing(Ingredient.of(ModItems.PIRATES_SWORD.get()), Ingredient.of(ModItems.DRAGON_TOOTH.get()), ModItems.DRAGONTOOTH_CUTLASS.get())
                .unlocks("has_item", has(ModItems.DRAGON_TOOTH.get()))
                .save(consumer, modId("dragontooth_pirate_smithing"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(StardewArmory.MOD_ID, path);
    }
}
