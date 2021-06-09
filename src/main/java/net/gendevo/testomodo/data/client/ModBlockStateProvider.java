package net.gendevo.testomodo.data.client;

import net.gendevo.testomodo.TestoModo;
import net.gendevo.testomodo.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TestoModo.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.PRISMATIC_BLOCK.get());
        simpleBlock(ModBlocks.PRISMATIC_ORE.get());
    }

}
