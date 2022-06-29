package net.gendevo.stardewarmory.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class DeepslateIridiumOre extends DropExperienceBlock {
    public DeepslateIridiumOre() {
        super(Block.Properties.of(Material.STONE)
                .lightLevel((p_235470_0_) -> 5)
                .strength(4.5F, 4.5F)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE));
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader level, net.minecraft.util.RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel == 0 ? (15 + (fortuneLevel * 4)) : 0;
    }
}
