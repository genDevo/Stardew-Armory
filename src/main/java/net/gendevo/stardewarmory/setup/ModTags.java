package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_IRIDIUM = forge("ores/iridium");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_IRIDIUM = forge("storage_blocks/prismatic");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

    }

    public static final class Items{
        public static final ITag.INamedTag<Item> ORES_IRIDIUM = forge("ores/iridium");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_PRISMATIC = forge("storage_blocks/prismatic");

        public static final ITag.INamedTag<Item> INGOTS_IRIDIUM = forge("ingots/iridium");
        public static final ITag.INamedTag<Item> RODS_NETHERITE = forge("rods/netherite");
        public static final ITag.INamedTag<Item> BONES_PREHISTORIC_SCAPULA = forge("bones/prehistoric_scapula");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

    }
}
