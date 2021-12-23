package net.gendevo.stardewarmory.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class DeepslateIridiumOre extends OreBlock {
    public DeepslateIridiumOre() {
        super(Block.Properties.of(Material.STONE)
                .lightLevel((p_235470_0_) -> 5)
                .strength(4.5F, 4.5F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE));
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? (15 + (fortune * 4)) : 0;
    }
}
