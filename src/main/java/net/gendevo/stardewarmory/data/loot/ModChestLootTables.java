package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.init.LootInjector;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModChestLootTables extends ChestLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.CHESTS_IGLOO, addYetiTooth(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_NETHER_BRIDGE, addNetherWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_VILLAGE_TEMPLE, addTemplarsBlade(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_VILLAGE_WEAPONSMITH, addSteelWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_SPAWN, addForestSword(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_SHIP, addPirateSword(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_PILLAGER, addCutlass(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_STRONGHOLD, addClaymoreAndTemperedBroadsword(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_MINESHAFT, addMineshaftWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_RUINED_PORTAL, addObsidianEdge(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_UNDERWATER_RUINS, addNeptuneChest(new LootTable.Builder()));
    }

    private static LootTable.Builder addYetiTooth(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(ModItems.YETI_TOOTH.get()))
        );
        return builder;
    }

    private static LootTable.Builder addForestSword(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(ItemLootEntry.lootTableItem(ModItems.FOREST_SWORD.get()))
        );
        return builder;
    }

    private static LootTable.Builder addNetherWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(30)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.LAVA_KATANA.get())
                        .setWeight(25)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.DARK_SWORD.get())
                        .setWeight(25)
                )
        );
        return builder;
    }

    private static LootTable.Builder addTemplarsBlade(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(40)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.TEMPLARS_BLADE.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addSteelWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(30)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.STEEL_FALCHION.get())
                        .setWeight(35)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.STEEL_SMALLSWORD.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addPirateSword(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(50)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.PIRATES_SWORD.get())
                        .setWeight(25)
                )
        );
        return builder;
    }

    private static LootTable.Builder addCutlass(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(40)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.CUTLASS.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addClaymoreAndTemperedBroadsword(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(50)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.CLAYMORE.get())
                        .setWeight(15)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.TEMPERED_BROADSWORD.get())
                        .setWeight(10)
                )
        );
        return builder;
    }

    private static LootTable.Builder addObsidianEdge(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(40)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.OBSIDIAN_EDGE.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addMineshaftWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(40)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.RUSTY_SWORD.get())
                        .setWeight(25)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.BONE_SWORD.get())
                        .setWeight(25)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.IRON_EDGE.get())
                        .setWeight(15)
                )
        );
        return builder;
    }

    private static LootTable.Builder addNeptuneChest(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(60)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.RUSTY_SWORD.get())
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
                        .setWeight(1)
                )
        );
        return builder;
    }
}

