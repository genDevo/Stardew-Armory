package net.gendevo.stardewarmory.util;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.gendevo.stardewarmory.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static Identifier IGLOO_STRUCTURE_CHEST = new Identifier("minecraft", "chests/igloo_chest");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            //check for grass block loot table.
//            if(GRASS_BLOCK_ID.equals(id)) {
//                // Adds Grape Seeds to the grass loot table.
//                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(0.35f)) // Drops 35% of the time
//                        .with(ItemEntry.builder(ModItems.GRAPE_SEEDS))
//                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
//                supplier.withPool(poolBuilder.build());
//            }

            if(IGLOO_STRUCTURE_CHEST.equals(id)) {
                // Adds a Dowsing Rod into the Igloo Chest with 100% chance.
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Adds 100% of the time
                        .with(ItemEntry.builder(ModItems.YETI_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

//            if(CREEPER_ID.equals(id)) {
//                // Adds a Lilac Flower Bulb to Creepers.
//                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
//                        .rolls(ConstantLootNumberProvider.create(1))
//                        .conditionally(RandomChanceLootCondition.builder(1f)) // Drops 100% of the time
//                        .with(ItemEntry.builder(ModItems.LILAC_FLOWER_BULB))
//                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
//                supplier.withPool(poolBuilder.build());
//            }
        }));
    }
}
