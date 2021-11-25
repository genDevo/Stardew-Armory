package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.util.events.LootInjector;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.loot.*;
import net.minecraft.loot.conditions.KilledByPlayer;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModEntityLootTables extends EntityLootTables {
    private static final int PRISMATIC_CHANCE = 800;
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.ENTITIES_CAVE_SPIDER, addSpiderDrops(0.08f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_SPIDER, addSpiderDrops(0.02f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_ZOMBIE, addZombieDrops(0.02f, 0.01f));
        consumer.accept(LootInjector.Tables.ENTITIES_SKELETON, addSkeletonDrops());
        consumer.accept(LootInjector.Tables.ENTITIES_SKELETON_HORSE, addSkeletonDrops());
        consumer.accept(LootInjector.Tables.ENTITIES_ENDER_DRAGON, addDragonDrops());
        consumer.accept(LootInjector.Tables.ENTITIES_ELDER_GUARDIAN, addElderGuardianDrops());
        consumer.accept(LootInjector.Tables.ENTITIES_CREEPER, addPrismaticShard(1));
        consumer.accept(LootInjector.Tables.ENTITIES_ENDERMAN, addPrismaticShard(2));
        consumer.accept(LootInjector.Tables.ENTITIES_GUARDIAN, addPrismaticShard(2));
        consumer.accept(LootInjector.Tables.ENTITIES_WITHER, addPrismaticShard(200));
    }

    private static LootTable.Builder addPrismaticShard(int likelihood) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(PRISMATIC_CHANCE/likelihood)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addSpiderDrops(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(100)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.INSECT_HEAD.get())
                                .setWeight(1)
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(PRISMATIC_CHANCE)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addZombieDrops(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.RUSTY_SWORD.get())
                                .setWeight(1)
                                .when(KilledByPlayer.killedByPlayer())
                                .when(RandomChanceWithLooting.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(110)
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(PRISMATIC_CHANCE)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addDragonDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.DRAGON_TOOTH.get())
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight((int)(((float)PRISMATIC_CHANCE)/200))
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addElderGuardianDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight((int)(((float)PRISMATIC_CHANCE)/5))
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addSkeletonDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.BONE_SWORD.get())
                                .setWeight(3)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.FEMUR.get())
                                .setWeight(3)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PREHISTORIC_SCAPULA.get())
                                .setWeight(1)
                        )
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(75)
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(PRISMATIC_CHANCE)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(KilledByPlayer.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }
}
