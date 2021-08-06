package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.init.LootInjector;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.KilledByPlayer;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModEntityLootTables extends EntityLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.ENTITIES_CAVE_SPIDER, addInsectHead(0.08f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_SPIDER, addInsectHead(0.02f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_ZOMBIE, addRustySword(0.02f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_SKELETON, addSkeletonDrops(0.02f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_SKELETON_HORSE, addSkeletonDrops(0.1f, 0.05f));
        consumer.accept(LootInjector.Tables.ENTITIES_ENDER_DRAGON, addDragonTooth(0.99f, 0f));
        consumer.accept(LootInjector.Tables.ENTITIES_ELDER_GUARDIAN, addNeptunesGlaive(0.99f, 0f));
    }

    private static LootTable.Builder addInsectHead(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.INSECT_HEAD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                );
    }

    private static LootTable.Builder addRustySword(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.RUSTY_SWORD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                );
    }

    private static LootTable.Builder addDragonTooth(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.DRAGON_TOOTH.get())
                        )
                );
    }

    private static LootTable.Builder addNeptunesGlaive(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
//                                .when(KilledByPlayer.killedByPlayer())
//                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                );
    }

    private static LootTable.Builder addSkeletonDrops(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.BONE_SWORD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.FEMUR.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PREHISTORIC_SCAPULA.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance - 0.015f, lootingBonus - 0.005f))
                        )
                );
    }
}
