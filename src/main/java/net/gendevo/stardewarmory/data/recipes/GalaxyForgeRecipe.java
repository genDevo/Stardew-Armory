package net.gendevo.stardewarmory.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModRecipeTypes;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class GalaxyForgeRecipe implements IGalaxyForgeRecipe{
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;

    public GalaxyForgeRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        if (recipeItems.get(0).test(inv.getItem(0))) {
            return recipeItems.get(1).test(inv.getItem(1));
        }
        return false;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(IInventory p_77572_1_) {
        return output;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    public ItemStack getIcon() {
        return new ItemStack(ModBlocks.GALAXY_FORGE.get());
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.GALAXY_SERIALIZER.get();
    }

    public static class GalaxyForgeRecipeType implements IRecipeType<GalaxyForgeRecipe> {
        @Override
        public String toString() {
            return GalaxyForgeRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>>
            implements IRecipeSerializer<GalaxyForgeRecipe> {


        @Override
        public GalaxyForgeRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));

            JsonArray ingredients = JSONUtils.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i< inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new GalaxyForgeRecipe(recipeId, output, inputs);
        }

        @Nullable
        @Override
        public GalaxyForgeRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            ItemStack output = buffer.readItem();
            return new GalaxyForgeRecipe(recipeId, output, inputs);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, GalaxyForgeRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }
            buffer.writeItemStack(recipe.getResultItem(), false);
        }
    }
}
