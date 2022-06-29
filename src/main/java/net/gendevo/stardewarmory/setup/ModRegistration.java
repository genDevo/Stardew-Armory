package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.block.ModBlocks;
import net.gendevo.stardewarmory.enchantments.ModEnchants;
import net.gendevo.stardewarmory.item.ModItems;
import net.gendevo.stardewarmory.recipe.ModRecipe;
import net.gendevo.stardewarmory.sound.ModSounds;
import net.gendevo.stardewarmory.util.ModRegistries;

public class ModRegistration {

    public static void register() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModRecipe.register();
        ModRegistries.registerMisc();
        ModSounds.register();
        ModEnchants.registerModEnchantments();

    }
}
