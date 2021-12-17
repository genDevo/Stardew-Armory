package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.util.events.LootInjector;
import net.minecraft.data.loot.FishingLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.BiConsumer;

public class ModFishingLootTables extends FishingLoot {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.FISHING_TREASURE, addTreasureDrops());
        consumer.accept(LootInjector.Tables.FISHING_JUNK, addJunkDrops());
    }

    private static LootTable.Builder addTreasureDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.PIRATES_SWORD.get())
                                .setWeight(2)
                        )
                        .add(LootItem.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
                                .setWeight(1)
                        )
                        .add(LootItem.lootTableItem(ModItems.CRABSHELL_RING.get())
                                .setWeight(4)
                        )
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(10)
                        )
                );
    }

    private static LootTable.Builder addJunkDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BROKEN_TRIDENT.get())
                                .setWeight(1)
                        )
                        .add(EmptyLootItem.emptyItem()
                                .setWeight(10)
                        )
                );
    }
}
