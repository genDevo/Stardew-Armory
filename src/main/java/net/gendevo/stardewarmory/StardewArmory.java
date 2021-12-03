package net.gendevo.stardewarmory;

import com.mojang.serialization.Codec;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.data.capabilities.IridiumCapabilityManager;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.gendevo.stardewarmory.entities.render.GuildMasterRenderer;
import net.gendevo.stardewarmory.network.ModNetwork;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreen;
import net.gendevo.stardewarmory.setup.*;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.gendevo.stardewarmory.util.ModResourceLocation;
import net.gendevo.stardewarmory.world.OreGeneration;
import net.gendevo.stardewarmory.world.structures.ConfiguredStructureInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StardewArmory.MOD_ID)
public class StardewArmory
{
    public static final String MOD_ID = "stardewarmory";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ItemGroup TAB_STARDEW = new StardewGroup("stardewtab");

    public StardewArmory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, StardewArmoryConfig.SPEC, "stardewarmory-common.toml");
        Registration.register(modEventBus);

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

        forgeBus.addListener(EventPriority.HIGH, OreGeneration::generateOres);

        if (StardewArmoryConfig.guild_spawn.get()) {
            forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
            forgeBus.addListener(EventPriority.HIGH, this::biomeModification);
        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ModNetwork.init();
        event.enqueueWork(() -> {
            if (StardewArmoryConfig.guild_spawn.get()) {
                ModStructures.setupStructures();
                ConfiguredStructureInit.registerConfiguredStructures();
            }
            IridiumCapabilityManager.registerCapabilities();
            GlobalEntityTypeAttributes.put(ModEntityTypes.GUILD_MASTER.get(), GuildMasterEntity.setCustomAttributes().build());
            RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.GUILD_MASTER.get(), GuildMasterRenderer::new);
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        KeybindSetup.register(event);
        event.enqueueWork(() -> {
            ScreenManager.register(ModContainers.GALAXY_FORGE_CONTAINER.get(),
                    GalaxyForgeScreen::new);
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
    }

    private void processIMC(final InterModProcessEvent event)
    {

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
            tempMap.putIfAbsent(ModStructures.GUILD_BUILDING.get(), DimensionStructuresSettings.DEFAULTS.get(ModStructures.GUILD_BUILDING.get()));
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
        LOGGER.info("Stardew Armory recognized server start");
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
