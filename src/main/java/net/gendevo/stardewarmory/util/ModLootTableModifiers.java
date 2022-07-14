package net.gendevo.stardewarmory.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.gendevo.stardewarmory.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final float PRISMATIC_CHANCE = 0.00125f;

    // Entities
    private static Identifier ENTITY_ZOMBIE = new Identifier("minecraft", "entities/zombie");
    private static Identifier ENTITY_SPIDER = new Identifier("minecraft", "entities/spider");
    private static Identifier ENTITY_DRAGON = new Identifier("minecraft", "entities/ender_dragon");
    private static Identifier ENTITY_ELDER_GUARDIAN = new Identifier("minecraft", "entities/elder_guardian");
    private static Identifier ENTITY_SKELETON = new Identifier("minecraft", "entities/skeleton");

    // Chests
    private static Identifier CHEST_IGLOO = new Identifier("minecraft", "chests/igloo_chest");
    private static Identifier CHEST_NETHER_BRIDGE = new Identifier("minecraft", "chests/nether_bridge");
    private static Identifier CHEST_VILLAGE_TEMPLE = new Identifier("minecraft", "chests/village_temple");
    private static Identifier CHEST_VILLAGE_WEAPONSMITH = new Identifier("minecraft", "chests/village_weaponsmith");
    private static Identifier CHEST_VILLAGE_TOOLSMITH = new Identifier("minecraft", "chests/village_toolsmith");
    private static Identifier CHEST_VILLAGE_BUTCHER = new Identifier("minecraft", "chests/village_butcher");
    private static Identifier CHEST_SPAWN = new Identifier("minecraft", "chests/spawn_bonus_chest");
    private static Identifier CHEST_PILLAGER = new Identifier("minecraft", "chests/pillager_outpost");
    private static Identifier CHEST_SPAWNER = new Identifier("minecraft", "chests/simple_dungeon");
    private static Identifier CHEST_MINESHAFT = new Identifier("minecraft", "chests/abandoned_mineshaft");
    private static Identifier CHEST_RUINED_PORTAL = new Identifier("minecraft", "chests/ruined_portal");
    //private static Identifier CHEST_UNDERWATER_RUINS = new Identifier("minecraft", "chests/underwater_ruin_big");
    //private static Identifier CHEST_BASTION_TREASURE = new Identifier("minecraft", "chests/bastion_treasure");
    //private static Identifier CHEST_BASTION_BRIDGE = new Identifier("minecraft", "chests/bastion_bridge");
    //private static Identifier CHEST_BASTION_OTHER = new Identifier("minecraft", "chests/bastion_other");
    //private static Identifier CHEST_DESERT_PYRAMID = new Identifier("minecraft", "chests/desert_pyramid");
    //private static Identifier CHEST_JUNGLE_TEMPLE = new Identifier("minecraft", "chests/jungle_temple");
    //private static Identifier CHEST_WOODLAND_MANSION = new Identifier("minecraft", "chests/woodland_mansion");
    //private static Identifier CHEST_STRONGHOLD = new Identifier("minecraft", "chests/stronghold_corridor");
    private static Identifier CHEST_BURIED_TREASURE = new Identifier("minecraft", "chests/buried_treasure");
    private static Identifier CHEST_SHIPWRECK = new Identifier("minecraft", "chests/shipwreck_supply");

    // Fishing
    private static Identifier FISHING_TREASURE = new Identifier("minecraft", "gameplay/fishing/treasure");
    private static Identifier FISHING_JUNK = new Identifier("minecraft", "gameplay/fishing/junk");

    // Hero of the Village
    private static Identifier HOTV_WEAPONSMITH = new Identifier("minecraft", "gameplay/hero_of_the_village/weaponsmith_gift");

    // Piglin Bartering
    private static Identifier PIGLIN_BARTER = new Identifier("minecraft", "gameplay/piglin_bartering");


    public static void modifyLootTables() {
        // Entities
        LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, setter) -> {
            if (ENTITY_ZOMBIE.equals(id)) {
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.01f, 1.2f)) // Drops 1% of the time
                        .with(ItemEntry.builder(ModItems.RUSTY_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(PRISMATIC_CHANCE, 1.5f)) // Drops 1/800 of the time
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(pool1.build());
                supplier.pool(pool2.build());
            }

            if (ENTITY_SPIDER.equals(id)) {
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(0.01f, 1.5f))
                        .with(ItemEntry.builder(ModItems.INSECT_HEAD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(PRISMATIC_CHANCE, 1.5f))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(pool1.build());
                supplier.pool(pool2.build());
            }

            if (ENTITY_DRAGON.equals(id)) {
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.DRAGON_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(PRISMATIC_CHANCE * 10.0f, 1.5f))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(pool1.build());
                supplier.pool(pool2.build());
            }

            if (ENTITY_ELDER_GUARDIAN.equals(id)) {
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.NEPTUNES_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(PRISMATIC_CHANCE * 5.0f, 1.5f))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(pool1.build());
                supplier.pool(pool2.build());
            }

            if (ENTITY_SKELETON.equals(id)) {
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(ModItems.BONE_SWORD))
                        .with(ItemEntry.builder(ModItems.FEMUR))
                        .with(ItemEntry.builder(ModItems.PREHISTORIC_SCAPULA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(PRISMATIC_CHANCE, 1.5f))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(pool1.build());
                supplier.pool(pool2.build());
            }

            if (ENTITY_SKELETON.equals(id)) {
                LootPool.Builder pool1 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .with(ItemEntry.builder(ModItems.BONE_SWORD))
                        .with(ItemEntry.builder(ModItems.FEMUR))
                        .with(ItemEntry.builder(ModItems.PREHISTORIC_SCAPULA))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                LootPool.Builder pool2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceWithLootingLootCondition.builder(PRISMATIC_CHANCE, 1.5f))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(pool1.build());
                supplier.pool(pool2.build());
            }
            
            // Chests
            if (CHEST_IGLOO.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f)) // Adds 100% of the time
                        .with(ItemEntry.builder(ModItems.YETI_TOOTH))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build()); // Adds between 1 and 1 items
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_NETHER_BRIDGE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.75f))
                        .with(ItemEntry.builder(ModItems.LAVA_KATANA).weight(25))
                        .with(ItemEntry.builder(ModItems.DARK_SWORD).weight(25))
                        .with(ItemEntry.builder(ModItems.WICKED_KRIS).weight(25))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_VILLAGE_TEMPLE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.TEMPLARS_BLADE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_VILLAGE_WEAPONSMITH.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.STEEL_FALCHION).weight(35))
                        .with(ItemEntry.builder(ModItems.STEEL_SMALLSWORD).weight(35))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_VILLAGE_TOOLSMITH.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.SLAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_VILLAGE_BUTCHER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.CARVING_KNIFE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_SPAWN.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.FOREST_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_SHIPWRECK.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.PIRATES_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_BURIED_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.PIRATES_SWORD))
                        .with(ItemEntry.builder(ModItems.PIRATES_SWORD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_PILLAGER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.CUTLASS))
                        .with(ItemEntry.builder(ModItems.BURGLARS_SHANK))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_SPAWNER.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.CLAYMORE).weight(20))
                        .with(ItemEntry.builder(ModItems.TEMPERED_BROADSWORD).weight(20))
                        .with(ItemEntry.builder(ModItems.SHADOW_DAGGER).weight(20))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD).weight(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_MINESHAFT.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.IRON_EDGE).weight(20))
                        .with(ItemEntry.builder(ModItems.WIND_SPIRE).weight(20))
                        .with(ItemEntry.builder(ModItems.ELF_BLADE).weight(20))
                        .with(ItemEntry.builder(ModItems.LEAD_ROD).weight(20))
                        .with(ItemEntry.builder(ModItems.PRISMATIC_SHARD).weight(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (CHEST_RUINED_PORTAL.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.8f))
                        .with(ItemEntry.builder(ModItems.OBSIDIAN_EDGE).weight(35))
                        .with(ItemEntry.builder(ModItems.WICKED_KRIS).weight(20))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            // Fishing
            if (FISHING_TREASURE.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.4f))
                        .with(ItemEntry.builder(ModItems.PIRATES_SWORD).weight(2))
                        .with(ItemEntry.builder(ModItems.NEPTUNES_GLAIVE).weight(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            if (FISHING_JUNK.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.BROKEN_TRIDENT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            // Hero of the Village
            if (HOTV_WEAPONSMITH.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f))
                        .with(ItemEntry.builder(ModItems.SILVER_SABER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

            // Piglin Bartering
            if (HOTV_WEAPONSMITH.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.KUDGEL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
                supplier.pool(poolBuilder.build());
            }

        }));
    }
}
