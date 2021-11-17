package net.gendevo.stardewarmory.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class CinderOre extends Block {
    public CinderOre() {
        super(Block.Properties.of(Material.STONE)
                .harvestTool(ToolType.PICKAXE)
                .strength(1, 2)
                .harvestLevel(2)
                .requiresCorrectToolForDrops()
                .sound(SoundType.NETHER_ORE));
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        return 4;
    }
}
