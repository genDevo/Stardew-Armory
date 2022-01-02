package net.gendevo.stardewarmory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gendevo.stardewarmory.items.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StardewArmory implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final String MODID = "stardewarmory";
    public static final Logger LOGGER = LogManager.getLogger("stardewarmory");


    // Add custom item group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MODID, "general"),
            () -> new ItemStack(ModItems.PRISMATIC_SHARD));

    @Override
    public void onInitialize() {
        // Register everything
        Registration.register();

        LOGGER.info("Hello Fabric world!");
    }
}
