package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.init.LootInjector;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.data.loot.FishingLootTables;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.ResourceLocation;

import java.util.function.BiConsumer;

public class ModFishingLootTables extends FishingLootTables {
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        consumer.accept(LootInjector.Tables.FISHING_TREASURE, addTreasureDrops(new LootTable.Builder()));
        consumer.accept(LootInjector.Tables.FISHING_JUNK, addJunkDrops(new LootTable.Builder()));
    }

    private static LootTable.Builder addTreasureDrops(LootTable.Builder builders) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
//                        .add(ItemLootEntry.lootTableItem(ModItems.PIRATES_SWORD.get()))
//                        .add(ItemLootEntry.lootTableItem(ModItems.NEPTUNES_GLAIVE.get()))
                        .add(ItemLootEntry.lootTableItem(ModItems.CRABSHELL_RING.get()))
                );
    }

    private static LootTable.Builder addJunkDrops(LootTable.Builder builders) {
        return new LootTable.Builder()
                .withPool(new LootPool.Builder()
                        .setRolls(ConstantRange.exactly(1))
                        .add(ItemLootEntry.lootTableItem(ModItems.BROKEN_TRIDENT.get())
                        )
                );
    }
}
