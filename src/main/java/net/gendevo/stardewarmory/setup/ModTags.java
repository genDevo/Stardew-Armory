package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final class Blocks {
        public static final TagKey<Block> ORES_IRIDIUM = forge("ores/iridium");
        public static final TagKey<Block> STORAGE_BLOCKS_IRIDIUM = forge("storage_blocks/iridium");
        public static final TagKey<Block> ORES_CINDER = forge("ores/cinder");

        private static TagKey<Block> forge(String path) {
            return BlockTags.create(new ResourceLocation("forge", path));
        }

    }

    public static final class Items{
        public static final TagKey<Item> ORES_IRIDIUM = forge("ores/iridium");
        public static final TagKey<Item> STORAGE_BLOCKS_IRIDIUM = forge("storage_blocks/iridium");
        public static final TagKey<Item> ORES_CINDER = mod("ores/cinder");

        public static final TagKey<Item> INGOTS_IRIDIUM = forge("ingots/iridium");
        public static final TagKey<Item> RODS_NETHERITE = forge("rods/netherite");
        public static final TagKey<Item> SHARDS_CINDER = mod("shards/cinder");
        public static final TagKey<Item> BONES_THING = mod("bones/sa");

        private static TagKey<Item> forge(String path) {
            return ItemTags.create(new ResourceLocation("forge", path));
        }

        private static TagKey<Item> mod(String path) {
            return ItemTags.create(new ResourceLocation(StardewArmory.MOD_ID, path));
        }
    }
}
