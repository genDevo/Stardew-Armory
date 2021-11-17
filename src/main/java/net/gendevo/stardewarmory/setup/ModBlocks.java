package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.blocks.CinderOre;
import net.gendevo.stardewarmory.blocks.IridiumBlock;
import net.gendevo.stardewarmory.blocks.IridiumOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> IRIDIUM_ORE = register("iridium_ore", IridiumOre::new);
    public static final RegistryObject<Block> CINDER_ORE = register("cinder_ore", CinderOre::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = register("iridium_block", IridiumBlock::new);


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
