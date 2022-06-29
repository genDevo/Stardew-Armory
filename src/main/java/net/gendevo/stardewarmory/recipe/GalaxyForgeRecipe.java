package net.gendevo.stardewarmory.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreenHandler;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class GalaxyForgeRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final int reqShards;
    private final DefaultedList<Ingredient> recipeItems;

    public GalaxyForgeRecipe(Identifier id, ItemStack output, int shards,
                                    DefaultedList<Ingredient> recipeItems) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.reqShards = shards;
    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(recipeItems.get(0).test(inventory.getStack(0))) {
            return recipeItems.get(1).test(inventory.getStack(1));
        }

        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    public int getReqShards() {
        return reqShards;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GalaxyForgeRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "galaxyforge";
    }

    public static class Serializer implements RecipeSerializer<GalaxyForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "galaxyforge";
        // this is the name given in the json file

        @Override
        public GalaxyForgeRecipe read(Identifier id, JsonObject json) {
            int shards = JsonHelper.getInt(json, "shards");
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
            JsonArray ingredients = JsonHelper.getArray(json, "ingredients");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new GalaxyForgeRecipe(id, output, shards, inputs);
        }

        @Override
        public GalaxyForgeRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }
            int shards = buf.readInt();
            ItemStack output = buf.readItemStack();
            return new GalaxyForgeRecipe(id, output, shards, inputs);
        }

        @Override
        public void write(PacketByteBuf buf, GalaxyForgeRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buf);
            }
            buf.writeInt(recipe.getReqShards());
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
