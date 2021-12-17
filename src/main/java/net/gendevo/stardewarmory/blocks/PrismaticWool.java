package net.gendevo.stardewarmory.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class PrismaticWool extends Block {
    public PrismaticWool() {
        super(Block.Properties.of(Material.WOOL)
                .strength(0.8F)
                .sound(SoundType.WOOL));
    }
}
