package net.gendevo.stardewarmory.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.gendevo.stardewarmory.data.loot.ModChestLootTables;
import net.gendevo.stardewarmory.data.loot.ModEntityLootTables;
import net.gendevo.stardewarmory.data.loot.ModFishingLootTables;
import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.fmllegacy.RegistryObject;

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
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                Pair.of(ModEntityLootTables::new, LootContextParamSets.ENTITY),
                Pair.of(ModChestLootTables::new, LootContextParamSets.CHEST),
                Pair.of(ModFishingLootTables::new, LootContextParamSets.FISHING)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTables.validate(validationtracker, p_218436_2_, p_218436_3_));
    }

    public static class ModBlockLootTables extends BlockLoot {
        public ModBlockLootTables() {}

        @Override
        protected void addTables() {
            dropSelf(ModBlocks.IRIDIUM_BLOCK.get());
            dropSelf(ModBlocks.IRIDIUM_ORE.get());
            dropSelf(ModBlocks.GALAXY_FORGE.get());
            dropSelf(ModBlocks.PRISMATIC_WOOL.get());
            add(ModBlocks.CINDER_ORE.get(), (p_218464_0_) -> createOreDrop(p_218464_0_,
                    ModItems.CINDER_SHARD.get()).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)));
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }
    }
}
