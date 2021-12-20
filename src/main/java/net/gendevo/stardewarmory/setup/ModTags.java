package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final class Blocks {
        public static final Tag.Named<Block> ORES_IRIDIUM = forge("ores/iridium");
        public static final Tag.Named<Block> STORAGE_BLOCKS_IRIDIUM = forge("storage_blocks/iridium");
        public static final Tag.Named<Block> ORES_CINDER = forge("ores/cinder");

        private static Tag.Named<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

    }

    public static final class Items{
        public static final Tag.Named<Item> ORES_IRIDIUM = forge("ores/iridium");
        public static final Tag.Named<Item> STORAGE_BLOCKS_IRIDIUM = forge("storage_blocks/iridium");
        public static final Tag.Named<Item> ORES_CINDER = mod("ores/cinder");

        public static final Tag.Named<Item> INGOTS_IRIDIUM = forge("ingots/iridium");
        public static final Tag.Named<Item> RODS_NETHERITE = forge("rods/netherite");
        public static final Tag.Named<Item> BONES_PREHISTORIC_SCAPULA = mod("bones/prehistoric_scapula");
        public static final Tag.Named<Item> SHARDS_CINDER = mod("shards/cinder");

        private static Tag.Named<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static Tag.Named<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(StardewArmory.MOD_ID, path).toString());
        }
    }
}
