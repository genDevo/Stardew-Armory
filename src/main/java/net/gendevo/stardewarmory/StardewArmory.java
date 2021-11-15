package net.gendevo.stardewarmory;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.gendevo.stardewarmory.init.ConfiguredStructureInit;
import net.gendevo.stardewarmory.init.StructureInit;
import net.gendevo.stardewarmory.setup.ModEntityTypes;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.gendevo.stardewarmory.util.ModResourceLocation;
import net.gendevo.stardewarmory.world.OreGeneration;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.*;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.CuriosCapability;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.beans.EventHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StardewArmory.MOD_ID)
public class StardewArmory
{
    public static final String MOD_ID = "stardewarmory";
    public static ResourceLocation rl(String path) { return new ResourceLocation(MOD_ID, path); }
    public static final Logger LOGGER = LogManager.getLogger();
    public static final boolean ENABLE = true;
    public static final ItemGroup TAB_STARDEW = new StardewGroup("stardewtab");

    public StardewArmory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        StructureInit.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(this);

        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        forgeBus.addListener(EventPriority.HIGH, this::biomeModification);

        Registration.register();
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, StardewArmoryConfig.SPEC, "stardewarmory-common.toml");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        event.enqueueWork(() -> {
            StructureInit.setupStructures();
            ConfiguredStructureInit.registerConfiguredStructures();
            GlobalEntityTypeAttributes.put(ModEntityTypes.GUILD_MASTER.get(), GuildMasterEntity.setCustomAttributes().build());
        });
//
//        RingKillEffect rke = new RingKillEffect();
//        MinecraftForge.EVENT_BUS.register(rke);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    public void biomeModification(final BiomeLoadingEvent event) {
        event.getGeneration().getStructures().add(() -> ConfiguredStructureInit.CONFIGURED_GUILD_BUILDING);
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if (event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                StardewArmory.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)) {
                return;
            }

            if(serverWorld.dimension().equals(World.NETHER) || serverWorld.dimension().equals(World.END)) {
                return;
            }

            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(StructureInit.GUILD_BUILDING.get(), DimensionStructuresSettings.DEFAULTS.get(StructureInit.GUILD_BUILDING.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;

        }

    }


    public static ModResourceLocation getId(String path) {
        if (path.contains(":")) {
            throw new IllegalArgumentException("path contains namespace");
        }
        return new ModResourceLocation(path);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // Zombies can now spawn with wood club in hand
    @SubscribeEvent
    public void giveClub(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof ZombieEntity)) {return;}

        ZombieEntity zombie = (ZombieEntity) event.getEntity();
        if (Math.random() > 0.9) {
            zombie.setItemInHand(Hand.MAIN_HAND, new ItemStack(ModItems.WOOD_CLUB.get()));
        }
    }


    //Adds creative tab
    @Mod.EventBusSubscriber
    public static class StardewGroup extends ItemGroup {
        public StardewGroup(String label) {
            super("stardewtab");
        }

        @Override
        public ItemStack makeIcon() {
            return ModItems.PRISMATIC_SHARD.get().getDefaultInstance();
        }
    }

}
