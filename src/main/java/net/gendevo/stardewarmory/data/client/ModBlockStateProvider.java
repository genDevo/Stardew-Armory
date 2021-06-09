package net.gendevo.stardewarmory.data.client;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, StardewArmory.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.PRISMATIC_BLOCK.get());
        simpleBlock(ModBlocks.PRISMATIC_ORE.get());
    }

}
