package net.gendevo.stardewarmory.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.gendevo.stardewarmory.data.loot.ModBlockLootTables;
import net.gendevo.stardewarmory.data.loot.ModChestLootTables;
import net.gendevo.stardewarmory.data.loot.ModEntityLootTables;
import net.gendevo.stardewarmory.data.loot.ModFishingLootTables;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.util.events.LootInjector;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.GiftLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                Pair.of(ModEntityLootTables::new, LootContextParamSets.ENTITY),
                Pair.of(ModChestLootTables::new, LootContextParamSets.CHEST),
                Pair.of(ModFishingLootTables::new, LootContextParamSets.FISHING),
                Pair.of(ModHOTVLootTables::new, LootContextParamSets.GIFT)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTables.validate(validationtracker, p_218436_2_, p_218436_3_));
    }


    public static class ModHOTVLootTables extends GiftLoot {
        @Override
        public void accept(BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
            consumer.accept(LootInjector.Tables.HOTV_WEAPONSMITH, addSilverSaber());
        }

        private static LootTable.Builder addSilverSaber() {
            return new LootTable.Builder()
                    .withPool(new LootPool.Builder()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(ModItems.SILVER_SABER.get())
                                    .setWeight(1)
                            )
                    ).withPool(new LootPool.Builder()
                            .setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(ModItems.CRABSHELL_RING.get())
                                    .setWeight(1)
                            )
                    );
        }
    }
}
