package net.gendevo.stardewarmory.data.client;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.gendevo.stardewarmory.data.loot.ModChestLootTables;
import net.gendevo.stardewarmory.data.loot.ModEntityLootTables;
import net.gendevo.stardewarmory.data.loot.ModFishingLootTables;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.*;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK),
                Pair.of(ModEntityLootTables::new, LootParameterSets.ENTITY),
                Pair.of(ModChestLootTables::new, LootParameterSets.CHEST),
                Pair.of(ModFishingLootTables::new, LootParameterSets.FISHING)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    public static class ModBlockLootTables extends BlockLootTables {
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.IRIDIUM_BLOCK.get());
            dropSelf(ModBlocks.IRIDIUM_ORE.get());
            add(ModBlocks.CINDER_ORE.get(), (p_218464_0_) -> createOreDrop(p_218464_0_, ModItems.CINDER_SHARD.get()).apply(ApplyBonus.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));

        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
