package net.gendevo.stardewarmory.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class CinderOre extends OreBlock {
    public CinderOre() {
        super(Block.Properties.of(Material.STONE)
                .strength(1, 2)
                .requiresCorrectToolForDrops()
                .sound(SoundType.NETHER_ORE));
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? (4 + fortune) : 0;
    }

}
