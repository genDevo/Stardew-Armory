package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.util.events.LootInjector;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModChestLootTables extends ChestLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.CHESTS_IGLOO, addYetiTooth(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_NETHER_BRIDGE, addNetherStuff(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_VILLAGE_TEMPLE, addTemplarsBlade(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_VILLAGE_WEAPONSMITH, addSteelWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_VILLAGE_TOOLSMITH, addSlammer(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_SPAWN, addForestSword(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_SHIP, addPirateSword(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_PILLAGER, addPillagerWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_SIMPLE_DUNGEON, addSimpleWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_MINESHAFT, addMineshaftWeapons(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_RUINED_PORTAL, addObsidianEdge(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_UNDERWATER_RUINS, addNeptuneChest(new LootTable.Builder(), 3));
        consumer.accept(LootInjector.Tables.CHESTS_VILLAGE_BUTCHER, addCarvingKnife(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_BASTION_TREASURE, addSGRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_BASTION_BRIDGE, addVampAndSGRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_BASTION_OTHER, addVampRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_DESERT_PYRAMID, addLuckyRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_JUNGLE_TEMPLE, addSCRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_WOODLAND_MANSION, addVampRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_STRONGHOLD, addEmeraldRing(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.CHESTS_BURIED_TREASURE, addNeptuneChest(new LootTable.Builder(), 20));

        consumer.accept(LootInjector.Tables.PIGLIN_BARTER, addKudgel(new LootTable.Builder()));
    }

    private static LootTable.Builder addLuckyRing(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(1)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.LUCKY_RING.get())
                        .setWeight(1)
                )
        );
        return builder;
    }

    private static LootTable.Builder addEmeraldRing(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.EMERALD_RING.get())
                        .setWeight(15)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(2)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.YOBA_RING.get())
                        .setWeight(2)
                )
        );
        return builder;
    }

    private static LootTable.Builder addSCRing(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(2)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SLIME_CHARMER_RING.get())
                        .setWeight(10)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SAVAGE_RING.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addVampAndSGRing(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.VAMPIRE_RING.get())
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SOUL_GLUTTON_RING.get())
                        .setWeight(15)
                )
        );
        return builder;
    }

    private static LootTable.Builder addVampRing(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(1)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.VAMPIRE_RING.get())
                        .setWeight(1)
                )
        );
        return builder;
    }

    private static LootTable.Builder addSGRing(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(1)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SOUL_GLUTTON_RING.get())
                        .setWeight(2)
                )
        );
        return builder;
    }

    private static LootTable.Builder addKudgel(LootTable.Builder builder ) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(1)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.KUDGEL.get())
                        .setWeight(3)
                )
        );
        return builder;
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

    private static LootTable.Builder addNetherStuff(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(2))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(8)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.LAVA_KATANA.get())
                        .setWeight(25)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.DARK_SWORD.get())
                        .setWeight(25)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.WICKED_KRIS.get())
                        .setWeight(25)
                )

        );
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(2))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(9)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.VAMPIRE_RING.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.NAPALM_RING.get())
                        .setWeight(10)
                )
        );
        return builder;
    }

    private static LootTable.Builder addTemplarsBlade(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(5)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.TEMPLARS_BLADE.get())
                        .setWeight(35)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.YOBA_RING.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addSlammer(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(5)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SLAMMER.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addCarvingKnife(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(1)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.CARVING_KNIFE.get())
                        .setWeight(5)
                )
        );
        return builder;
    }

    private static LootTable.Builder addSteelWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(5)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.STEEL_FALCHION.get())
                        .setWeight(35)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.STEEL_SMALLSWORD.get())
                        .setWeight(35)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(15)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.WARRIOR_RING.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addPirateSword(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(5)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.PIRATES_SWORD.get())
                        .setWeight(25)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(15)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SAVAGE_RING.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addPillagerWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.CUTLASS.get())
                        .setWeight(35)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.BURGLARS_SHANK.get())
                        .setWeight(35)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SAVAGE_RING.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addSimpleWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.CLAYMORE.get())
                        .setWeight(25)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.TEMPERED_BROADSWORD.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.SHADOW_DAGGER.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                        .setWeight(1)
                )
        );
        return builder;
    }

    private static LootTable.Builder addObsidianEdge(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(10)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.OBSIDIAN_EDGE.get())
                        .setWeight(35)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.WICKED_KRIS.get())
                        .setWeight(20)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(3)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.NAPALM_RING.get())
                        .setWeight(2)
                )
        );
        return builder;
    }

    private static LootTable.Builder addMineshaftWeapons(LootTable.Builder builder) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.IRON_EDGE.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.WIND_SPIRE.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.ELF_BLADE.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.LEAD_ROD.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                        .setWeight(1)
                )
        ).withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(15)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.WARRIOR_RING.get())
                        .setWeight(35)
                )
        );
        return builder;
    }

    private static LootTable.Builder addNeptuneChest(LootTable.Builder builder, int neptuneChance) {
        builder.withPool(new LootPool.Builder()
                .setRolls(ConstantRange.exactly(1))
                .add(EmptyLootEntry.emptyItem()
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.RUSTY_SWORD.get())
                        .setWeight(20)
                )
                .add(ItemLootEntry.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
                        .setWeight(neptuneChance)
                )
        );
        return builder;
    }
}

