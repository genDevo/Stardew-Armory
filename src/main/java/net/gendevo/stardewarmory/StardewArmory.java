package net.gendevo.stardewarmory;

import com.mojang.serialization.Codec;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.data.capabilities.CapabilityIridiumMode;
import net.gendevo.stardewarmory.entities.GuildMasterEntity;
import net.gendevo.stardewarmory.network.ModNetwork;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreen;
import net.gendevo.stardewarmory.setup.*;
import net.gendevo.stardewarmory.util.IridiumModeGui;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.gendevo.stardewarmory.util.ModResourceLocation;
import net.gendevo.stardewarmory.world.OreGeneration;
import net.gendevo.stardewarmory.world.structures.ConfiguredStructureInit;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod(StardewArmory.MOD_ID)
public class StardewArmory
{
    public static final String MOD_ID = "stardewarmory";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab TAB_STARDEW = new StardewGroup("stardewtab");

    public StardewArmory() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, StardewArmoryConfig.SPEC, "stardewarmory-common.toml");
        Registration.register(modEventBus);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        forgeBus.register(this);

        //forgeBus.register(new IridiumModeGui(Minecraft.getInstance()));

        if (StardewArmoryConfig.guild_spawn.get()) {
            ModStructures.DEFERRED_REGISTRY_STRUCTURE.register(modEventBus);
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
            OreGeneration.registerOres();
            CapabilityIridiumMode.register();
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        KeybindSetup.register(event);
        MinecraftForge.EVENT_BUS.register(IridiumModeGui.class);
        event.enqueueWork(() -> MenuScreens.register(ModContainers.GALAXY_FORGE_CONTAINER.get(), GalaxyForgeScreen::new));
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
    }

    public void biomeModification(final BiomeLoadingEvent event) {
        event.getGeneration().getStructures().add(() -> ConfiguredStructureInit.CONFIGURED_GUILD_BUILDING);
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerLevel){
            ServerLevel serverWorld = (ServerLevel)event.getWorld();

            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "func_230347_a_");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                StardewArmory.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            if(serverWorld.getChunkSource().getGenerator() instanceof FlatLevelSource &&
                    serverWorld.dimension().equals(Level.OVERWORLD)){
                return;
            }

            Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(ModStructures.GUILD_BUILDING.get(), StructureSettings.DEFAULTS.get(ModStructures.GUILD_BUILDING.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }

    public static ModResourceLocation getId(String path) {
        if (path.contains(":")) {
            throw new IllegalArgumentException("path contains namespace");
        }
        return new ModResourceLocation(path);
    }

    //Adds creative tab
    @Mod.EventBusSubscriber
    public static class StardewGroup extends CreativeModeTab {
        public StardewGroup(String label) {
            super("stardewtab");
        }

        @Override
        public ItemStack makeIcon() {
            return ModItems.PRISMATIC_SHARD.get().getDefaultInstance();
        }
    }

}
