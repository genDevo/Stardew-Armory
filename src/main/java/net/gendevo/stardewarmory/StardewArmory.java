package net.gendevo.stardewarmory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.gendevo.stardewarmory.config.ModConfigs;
import net.gendevo.stardewarmory.item.ModItems;
import net.gendevo.stardewarmory.setup.ModRegistration;
import net.gendevo.stardewarmory.util.ModLootTableModifiers;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StardewArmory implements ModInitializer {
    public static final String MODID = "stardewarmory";
    public static final Logger LOGGER = LogManager.getLogger("stardewarmory");


    // Add custom item group
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MODID, "general"),
            () -> new ItemStack(ModItems.PRISMATIC_SHARD));

    @Override
    public void onInitialize() {
        // Register everything
        LOGGER.info("Initializing Stardew Armory (Fabric)");
        ModConfigs.registerConfigs();
        ModRegistration.register();
        ModLootTableModifiers.modifyLootTables();

        LOGGER.info("Finished SA init");
    }
}
