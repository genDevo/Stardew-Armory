package net.gendevo.stardewarmory.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class CinderOre extends DropExperienceBlock {
    public CinderOre() {
        super(Block.Properties.of(Material.STONE)
                .strength(1, 2)
                .requiresCorrectToolForDrops()
                .sound(SoundType.NETHER_ORE));
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader level, net.minecraft.util.RandomSource randomSource, BlockPos pos, int fortuneLevel, int silkTouchLevel) {
        return silkTouchLevel == 0 ? (4 + fortuneLevel) : 0;
    }

}
