package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.data.recipes.GalaxyForgeRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.util.registry.Registry;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, StardewArmory.MOD_ID);

    public static final RegistryObject<GalaxyForgeRecipe.Serializer> GALAXY_SERIALIZER =
            RECIPE_SERIALIZER.register("galaxy", GalaxyForgeRecipe.Serializer::new);

    public static IRecipeType<GalaxyForgeRecipe> GALAXY_RECIPE =
            new GalaxyForgeRecipe.GalaxyForgeRecipeType();

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        Registry.register(Registry.RECIPE_TYPE, GalaxyForgeRecipe.TYPE_ID, GALAXY_RECIPE);
    }
}
