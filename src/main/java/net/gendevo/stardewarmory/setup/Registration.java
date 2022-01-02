package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.blocks.ModBlocks;
import net.gendevo.stardewarmory.items.ModItems;

public class Registration {

    public static void register() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
