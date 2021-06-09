package net.gendevo.testomodo.setup;

import net.gendevo.testomodo.TestoModo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class ModTags {
    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_PRISMATIC = forge("ores/prismatic");
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_PRISMATIC = forge("storage_blocks/silver");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(TestoModo.MOD_ID, path).toString());
        }
    }

    public static final class Items{
        public static final ITag.INamedTag<Item> ORES_PRISMATIC = forge("ores/prismatic");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_PRISMATIC = forge("storage_blocks/silver");

        public static final ITag.INamedTag<Item> INGOTS_PRISMATIC = forge("ingots/prismatic");
        public static final ITag.INamedTag<Item> RODS_NETHERITE = forge("rods/netherite");
        public static final ITag.INamedTag<Item> BONES_PREHISTORIC_SCAPULA = forge("bones/prehistoric_scapula");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(TestoModo.MOD_ID, path).toString());
        }

    }
}
