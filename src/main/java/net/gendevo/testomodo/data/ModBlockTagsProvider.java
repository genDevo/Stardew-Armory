package net.gendevo.testomodo.data;

import net.gendevo.testomodo.TestoModo;
import net.gendevo.testomodo.setup.ModBlocks;
import net.gendevo.testomodo.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, TestoModo.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_PRISMATIC).add(ModBlocks.PRISMATIC_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_PRISMATIC);
        tag(ModTags.Blocks.STORAGE_BLOCKS_PRISMATIC).add(ModBlocks.PRISMATIC_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_PRISMATIC);
    }
}
