package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> PRISMATIC_ORE = register("prismatic_ore", () ->
            new Block(AbstractBlock.Properties.of(Material.STONE)
                    .strength(3, 10)
                    .harvestLevel(3)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));
    public static final RegistryObject<Block> PRISMATIC_BLOCK = register("prismatic_block", () ->
            new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL).strength(2, 10).sound(SoundType.METAL)));



    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> ret = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
        return ret;
    }

    static void register() {}
}
