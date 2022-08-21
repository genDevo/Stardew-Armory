package net.gendevo.stardewarmory.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class IridiumOre extends Block {
    public IridiumOre() {
        super(Block.Properties.of(Material.STONE)
                .lightLevel((p_235470_0_) -> 6)
                .harvestTool(ToolType.PICKAXE)
                .strength(3.5F, 4)
                .harvestLevel(3)
                .requiresCorrectToolForDrops()
                .sound(SoundType.STONE));
    }
}
