package net.gendevo.testomodo.setup;

import net.gendevo.testomodo.TestoModo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestoModo.MOD_ID);
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestoModo.MOD_ID);

    public static void register() {
               IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
               BLOCKS.register(modEventBus);
               ITEMS.register(modEventBus);

            ModItems.register();
            ModBlocks.register();
        }
}
