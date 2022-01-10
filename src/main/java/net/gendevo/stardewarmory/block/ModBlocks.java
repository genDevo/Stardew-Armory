package net.gendevo.stardewarmory.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block IRIDIUM_ORE = registerBlock("iridium_ore",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(3.0F, 4)
                    .luminance(6)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            ));

    public static final Block DEEPSLATE_IRIDIUM_ORE = registerBlock("deepslate_iridium_ore",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(4.5F, 4.5F)
                    .luminance(5)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)
            ));

    public static final Block IRIDIUM_BLOCK = registerBlock("iridium_block",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(5F, 10F)
                    .luminance(5)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));

    public static final Block CINDER_ORE = registerBlock("cinder_ore",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(1F, 2)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHER_ORE)
            ));

    public static final Block PRISMATIC_WOOL = registerBlock("prismatic_wool",
            new Block(FabricBlockSettings.of(Material.STONE)
                    .strength(0.8F)
                    .sounds(BlockSoundGroup.WOOL)
            ));

    public static final Block GALAXY_FORGE = registerBlock("galaxy_forge",
            new GalaxyForgeBlock(FabricBlockSettings.of(Material.STONE)
                    .strength(4, 10)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
            ));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(StardewArmory.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(StardewArmory.MODID, name),
                new BlockItem(block, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    }

    public static void registerModBlocks() {
        StardewArmory.LOGGER.debug("Registering ModBlocks for " + StardewArmory.MODID);
    }
}
