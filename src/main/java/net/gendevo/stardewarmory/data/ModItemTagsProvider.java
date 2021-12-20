package net.gendevo.stardewarmory.data;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;


public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, StardewArmory.MOD_ID, existingFileHelper);
    }


    protected void addTags() {
        copy(ModTags.Blocks.ORES_IRIDIUM, ModTags.Items.ORES_IRIDIUM);
        copy(ModTags.Blocks.ORES_CINDER, ModTags.Items.ORES_CINDER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_IRIDIUM, ModTags.Items.STORAGE_BLOCKS_IRIDIUM);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.INGOTS_IRIDIUM).add(ModItems.IRIDIUM_INGOT.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.INGOTS_IRIDIUM);
        tag(ModTags.Items.RODS_NETHERITE).add(ModItems.REINFORCED_HANDLE.get());
        tag(Tags.Items.RODS).addTag(ModTags.Items.RODS_NETHERITE);
        tag(ModTags.Items.BONES_PREHISTORIC_SCAPULA).add(ModItems.PREHISTORIC_SCAPULA.get());
        tag(Tags.Items.BONES).addTag(ModTags.Items.BONES_PREHISTORIC_SCAPULA);
    }
}
