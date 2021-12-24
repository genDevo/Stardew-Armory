package net.gendevo.stardewarmory.data.loot;

import net.gendevo.stardewarmory.setup.ModBlocks;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLoot {
    public ModBlockLootTables() {}

    @Override
    protected void addTables() {
        dropSelf(ModBlocks.IRIDIUM_BLOCK.get());
        add(ModBlocks.IRIDIUM_ORE.get(), (iridium) -> createOreDrop(iridium,
                ModItems.RAW_IRIDIUM.get()));
        add(ModBlocks.DEEPSLATE_IRIDIUM_ORE.get(), (iridium) -> createOreDrop(iridium,
                ModItems.RAW_IRIDIUM.get()));
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
