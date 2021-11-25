package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, StardewArmory.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, StardewArmory.MOD_ID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, StardewArmory.MOD_ID);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        //ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        ENCHANTMENTS.register(modEventBus);

        ModItems.register();
        ModBlocks.register();
        ModEnchants.register();
        ModTileEntities.register(modEventBus);
        ModRecipeTypes.register(modEventBus);
        ModContainers.register(modEventBus);
        ModSoundEvents.register(modEventBus);
        //ModStructures.STRUCTURES.register(modEventBus);
    }
}
