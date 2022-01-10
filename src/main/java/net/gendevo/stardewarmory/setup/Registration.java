package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.block.ModBlocks;
import net.gendevo.stardewarmory.item.ModItems;

public class Registration {

    public static void register() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
