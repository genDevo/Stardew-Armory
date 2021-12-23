package net.gendevo.stardewarmory.data;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(StardewArmory.MOD_ID, path);
    }



    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        // Crafting Recipes
        ShapelessRecipeBuilder.shapeless(ModItems.IRIDIUM_INGOT.get(), 9)
                .requires(ModBlocks.IRIDIUM_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.IRIDIUM_BLOCK.get())
                .requires(ModItems.IRIDIUM_INGOT.get(), 9)
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.PRISMATIC_WOOL.get())
                .requires(Items.WHITE_WOOL, 8)
                .requires(ModItems.PRISMATIC_SHARD.get())
                .unlockedBy("has_item", has(ModItems.PRISMATIC_SHARD.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRIDIUM_PICKAXE.get())
                .define('#', ModItems.IRIDIUM_INGOT.get())
                .define('b', ModBlocks.IRIDIUM_BLOCK.get())
                .define('s', Items.STICK)
                .pattern("#b#")
                .pattern(" s ")
                .pattern(" s ")
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRIDIUM_AXE.get())
                .define('#', ModItems.IRIDIUM_INGOT.get())
                .define('b', ModBlocks.IRIDIUM_BLOCK.get())
                .define('s', Items.STICK)
                .pattern("#b ")
                .pattern("#s ")
                .pattern(" s ")
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRIDIUM_SHOVEL.get())
                .define('b', ModBlocks.IRIDIUM_BLOCK.get())
                .define('s', Items.STICK)
                .pattern(" b ")
                .pattern(" s ")
                .pattern(" s ")
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRIDIUM_HOE.get())
                .define('#', ModItems.IRIDIUM_INGOT.get())
                .define('b', ModBlocks.IRIDIUM_BLOCK.get())
                .define('s', Items.STICK)
                .pattern("#b ")
                .pattern(" s ")
                .pattern(" s ")
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRIDIUM_NEEDLE.get())
                .define('#', ModItems.IRIDIUM_INGOT.get())
                .define('s', Items.STICK)
                .pattern("   ")
                .pattern(" # ")
                .pattern("s  ")
                .unlockedBy("has_item", has(ModItems.IRIDIUM_INGOT.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.OSSIFIED_BLADE.get())
                .define('#', ModItems.BONE_SWORD.get())
                .define('p', ModItems.PREHISTORIC_SCAPULA.get())
                .define('f', ModItems.FEMUR.get())
                .pattern(" # ")
                .pattern(" p ")
                .pattern(" f ")
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
        ShapedRecipeBuilder.shaped(ModItems.CRYSTAL_DAGGER.get())
                .define('q', Items.QUARTZ)
                .define('s', Items.STICK)
                .pattern("   ")
                .pattern(" q ")
                .pattern("s  ")
                .unlockedBy("has_item", has(Items.QUARTZ))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.IRON_DIRK.get())
                .define('i', Items.IRON_INGOT)
                .define('s', Items.STICK)
                .pattern("   ")
                .pattern(" i ")
                .pattern("s  ")
                .unlockedBy("has_item", has(Items.IRON_INGOT))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModItems.WOOD_MALLET.get())
                .define('w', Items.OAK_PLANKS)
                .define('s', Items.STICK)
                .pattern(" ws")
                .pattern(" sw")
                .pattern("s  ")
                .unlockedBy("has_item", has(Items.STICK))
                .save(consumer);
        ShapedRecipeBuilder.shaped(ModBlocks.GALAXY_FORGE.get())
                .define('b', Items.IRON_BLOCK)
                .define('r', Items.IRON_BARS)
                .define('s', ModItems.CINDER_SHARD.get())
                .define('o', Items.OBSIDIAN)
                .pattern("bbb")
                .pattern("rsr")
                .pattern("ooo")
                .unlockedBy("has_item", has(ModItems.CINDER_SHARD.get()))
                .save(consumer);
        //Cooking recipes
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.IRIDIUM_ORE.get()), ModItems.IRIDIUM_INGOT.get(), 1.5f, 200)
                .unlockedBy("has_item", has(ModBlocks.IRIDIUM_ORE.get()))
                .save(consumer, modId("iridium_ore_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.IRIDIUM_ORE.get()), ModItems.IRIDIUM_INGOT.get(), 1.5f, 100)
                .unlockedBy("has_item", has(ModBlocks.IRIDIUM_ORE.get()))
                .save(consumer, modId("iridium_ore_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get()), ModItems.IRIDIUM_INGOT.get(), 1.5f, 200)
                .unlockedBy("has_item", has(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get()))
                .save(consumer, modId("deepslate_iridium_ore_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get()), ModItems.IRIDIUM_INGOT.get(), 1.5f, 100)
                .unlockedBy("has_item", has(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get()))
                .save(consumer, modId("deepslate_iridium_ore_blasting"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_IRIDIUM.get()), ModItems.IRIDIUM_INGOT.get(), 1.5f, 200)
                .unlockedBy("has_item", has(ModItems.RAW_IRIDIUM.get()))
                .save(consumer, modId("raw_iridium_smelting"));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.RAW_IRIDIUM.get()), ModItems.IRIDIUM_INGOT.get(), 1.5f, 100)
                .unlockedBy("has_item", has(ModItems.RAW_IRIDIUM.get()))
                .save(consumer, modId("raw_iridium_blasting"));
        // Smithing recipes
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.STICK), Ingredient.of(Items.NETHERITE_INGOT), ModItems.REINFORCED_HANDLE.get())
                .unlocks("has_item", has(Items.NETHERITE_INGOT))
                .save(consumer, modId("reinforced_handle_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(ModItems.CUTLASS.get()), Ingredient.of(ModItems.DRAGON_TOOTH.get()), ModItems.DRAGONTOOTH_CUTLASS.get())
                .unlocks("has_item", has(ModItems.DRAGON_TOOTH.get()))
                .save(consumer, modId("dragontooth_cutlass_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(ModItems.PIRATES_SWORD.get()), Ingredient.of(ModItems.DRAGON_TOOTH.get()), ModItems.DRAGONTOOTH_CUTLASS.get())
                .unlocks("has_item", has(ModItems.DRAGON_TOOTH.get()))
                .save(consumer, modId("dragontooth_pirate_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(ModItems.BURGLARS_SHANK.get()), Ingredient.of(ModItems.DRAGON_TOOTH.get()), ModItems.DRAGONTOOTH_SHIV.get())
                .unlocks("has_item", has(ModItems.DRAGON_TOOTH.get()))
                .save(consumer, modId("dragontooth_shiv_smithing"));
        UpgradeRecipeBuilder.smithing(Ingredient.of(ModItems.WOOD_CLUB.get()), Ingredient.of(ModItems.DRAGON_TOOTH.get()), ModItems.DRAGONTOOTH_CLUB.get())
                .unlocks("has_item", has(ModItems.DRAGON_TOOTH.get()))
                .save(consumer, modId("dragontooth_club_smithing"));
    }
}
