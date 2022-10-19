package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.util.events.LootInjector;
import net.minecraft.data.loot.EntityLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithLootingCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public class ModEntityLootTables extends EntityLoot {
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
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(PRISMATIC_CHANCE/likelihood)
                        )
                        .add(LootItem.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addSpiderDrops(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(100)
                        )
                        .add(LootItem.lootTableItem(ModItems.INSECT_HEAD.get())
                                .setWeight(1)
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(PRISMATIC_CHANCE)
                        )
                        .add(LootItem.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addZombieDrops(float baseChance, float lootingBonus) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.RUSTY_SWORD.get())
                                .setWeight(1)
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithLootingCondition.randomChanceAndLootingBoost(baseChance, lootingBonus))
                        )
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(110)
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(PRISMATIC_CHANCE)
                        )
                        .add(LootItem.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addDragonDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.DRAGON_TOOTH.get())
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight((int)(((float)PRISMATIC_CHANCE)/50)-1)
                        )
                        .add(LootItem.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addElderGuardianDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight((int)(((float)PRISMATIC_CHANCE)/5))
                        )
                        .add(LootItem.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }

    private static LootTable.Builder addSkeletonDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BONE_SWORD.get())
                                .setWeight(3)
                        )
                        .add(LootItem.lootTableItem(ModItems.FEMUR.get())
                                .setWeight(3)
                        )
                        .add(LootItem.lootTableItem(ModItems.PREHISTORIC_SCAPULA.get())
                                .setWeight(1)
                        )
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(75)
                        )
                ).withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(PRISMATIC_CHANCE)
                        )
                        .add(LootItem.lootTableItem(ModItems.PRISMATIC_SHARD.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .setWeight(1)
                        )
                );
    }
}
