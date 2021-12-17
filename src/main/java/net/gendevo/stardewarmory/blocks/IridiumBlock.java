package net.gendevo.stardewarmory.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class IridiumBlock extends Block {
    public IridiumBlock() {
        super(Block.Properties.of(Material.HEAVY_METAL)
                .strength(5, 10)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL));
    }
}
