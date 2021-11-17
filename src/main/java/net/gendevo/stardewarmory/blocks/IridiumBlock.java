package net.gendevo.stardewarmory.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class IridiumBlock extends Block {
    public IridiumBlock() {
        super(Block.Properties.of(Material.HEAVY_METAL)
                .harvestTool(ToolType.PICKAXE)
                .strength(5, 10)
                .harvestLevel(3)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL));
    }
}
