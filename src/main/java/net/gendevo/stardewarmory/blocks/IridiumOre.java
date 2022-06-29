package net.gendevo.stardewarmory.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class IridiumOre extends DropExperienceBlock {
    public IridiumOre() {
        super(Block.Properties.of(Material.STONE)
                .lightLevel((p_235470_0_) -> 6)
                .strength(3.0F, 4)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE));
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader level, net.minecraft.util.RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel == 0 ? (10 + (fortuneLevel * 3)) : 0;
    }
}
