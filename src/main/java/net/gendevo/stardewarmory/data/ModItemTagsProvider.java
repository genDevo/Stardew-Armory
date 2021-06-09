package net.gendevo.stardewarmory.data;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.ModTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, StardewArmory.MOD_ID, existingFileHelper);
    }


    protected void addTags() {
        copy(ModTags.Blocks.ORES_PRISMATIC, ModTags.Items.ORES_PRISMATIC);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_PRISMATIC, ModTags.Items.STORAGE_BLOCKS_PRISMATIC);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_PRISMATIC).add(ModItems.PRISMATIC_SHARD.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_PRISMATIC);
        tag(ModTags.Items.RODS_NETHERITE).add(ModItems.REINFORCED_HANDLE.get());
        tag(Tags.Items.RODS).addTag(ModTags.Items.RODS_NETHERITE);
        tag(ModTags.Items.BONES_PREHISTORIC_SCAPULA).add(ModItems.PREHISTORIC_SCAPULA.get());
        tag(Tags.Items.BONES).addTag(ModTags.Items.BONES_PREHISTORIC_SCAPULA);
    }
}
