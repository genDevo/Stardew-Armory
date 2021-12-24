package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.blocks.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> IRIDIUM_ORE = register("iridium_ore", IridiumOre::new);
    public static final RegistryObject<Block> DEEPSLATE_IRIDIUM_ORE = register("deepslate_iridium_ore", DeepslateIridiumOre::new);
    public static final RegistryObject<Block> CINDER_ORE = register("cinder_ore", CinderOre::new);
    public static final RegistryObject<Block> IRIDIUM_BLOCK = register("iridium_block", IridiumBlock::new);
    public static final RegistryObject<Block> GALAXY_FORGE = register("galaxy_forge", GalaxyForgeBlock::new);
    public static final RegistryObject<Block> PRISMATIC_WOOL = register("prismatic_wool", PrismaticWool::new);


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
