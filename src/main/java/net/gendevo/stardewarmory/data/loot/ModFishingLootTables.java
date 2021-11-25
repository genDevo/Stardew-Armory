package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.util.events.LootInjector;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.loot.FishingLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModFishingLootTables extends FishingLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.FISHING_TREASURE, addTreasureDrops());
        consumer.accept(LootInjector.Tables.FISHING_JUNK, addJunkDrops());
    }

    private static LootTable.Builder addTreasureDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.PIRATES_SWORD.get())
                                .setWeight(2)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.NEPTUNES_GLAIVE.get())
                                .setWeight(1)
                        )
                        .add(ItemLootEntry.lootTableItem(ModItems.CRABSHELL_RING.get())
                                .setWeight(4)
                        )
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(10)
                        )
                );
    }

    private static LootTable.Builder addJunkDrops() {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.BROKEN_TRIDENT.get())
                                .setWeight(1)
                        )
                        .add(EmptyLootEntry.emptyItem()
                                .setWeight(10)
                        )
                );
    }
}
