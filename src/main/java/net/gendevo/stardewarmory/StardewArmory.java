package net.gendevo.stardewarmory;

import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.items.ModItemTier;
import net.gendevo.stardewarmory.network.ModNetwork;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreen;
import net.gendevo.stardewarmory.setup.ModMenuTypes;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.gendevo.stardewarmory.util.IridiumModeGui;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.gendevo.stardewarmory.util.ModResourceLocation;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.SlotTypePreset;

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
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        ModNetwork.init();
        ModItemTier.init();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        KeybindSetup.register(event);
        IridiumModeGui.register();
        event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.GALAXY_FORGE_CONTAINER.get(), GalaxyForgeScreen::new));
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
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
