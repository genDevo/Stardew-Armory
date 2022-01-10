package net.gendevo.stardewarmory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item PRISMATIC_SHARD = registerItem("prismatic_shard",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item CINDER_SHARD = registerItem("cinder_shard",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(StardewArmory.MODID, name), item);
    }

    public static void registerModItems() {
        StardewArmory.LOGGER.debug("Registering mod item for " + StardewArmory.MODID);
    }
}
