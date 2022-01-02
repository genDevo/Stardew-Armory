package net.gendevo.stardewarmory.blocks;

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
