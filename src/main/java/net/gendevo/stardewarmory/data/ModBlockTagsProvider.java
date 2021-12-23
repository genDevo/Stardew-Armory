package net.gendevo.stardewarmory.data;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, StardewArmory.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_IRIDIUM)
                .add(ModBlocks.IRIDIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_IRIDIUM)
                .add(ModBlocks.CINDER_ORE.get())
                .add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get());
        tag(ModTags.Blocks.STORAGE_BLOCKS_IRIDIUM)
                .add(ModBlocks.IRIDIUM_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_IRIDIUM);
        tag(BlockTags.WOOL)
                .add(ModBlocks.PRISMATIC_WOOL.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.IRIDIUM_ORE.get())
                .add(ModBlocks.IRIDIUM_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get());
        tag(Tags.Blocks.NEEDS_GOLD_TOOL)
                .add(ModBlocks.CINDER_ORE.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GALAXY_FORGE.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRIDIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get())
                .add(ModBlocks.IRIDIUM_BLOCK.get())
                .add(ModBlocks.CINDER_ORE.get())
                .add(ModBlocks.GALAXY_FORGE.get());
        tag(BlockTags.WITHER_IMMUNE)
                .add(ModBlocks.IRIDIUM_BLOCK.get());
    }
}
