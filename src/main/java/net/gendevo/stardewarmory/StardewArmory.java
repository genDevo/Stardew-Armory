package net.gendevo.stardewarmory;

import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.Registration;
import net.gendevo.stardewarmory.util.ModResourceLocation;
import net.gendevo.stardewarmory.world.OreGeneration;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
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

import java.beans.EventHandler;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(StardewArmory.MOD_ID)
public class StardewArmory
{
    public static final String MOD_ID = "stardewarmory";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final boolean ENABLE = true;
    public static final ItemGroup TAB_STARDEW = new StardewGroup("stardewtab");

    public StardewArmory() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        Registration.register();
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
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

    @SubscribeEvent
    public void onKillRing(LivingDeathEvent event) {
        if (event.getEntity() instanceof MobEntity) {
//            if (player.getItemBySlot(EquipmentSlotType.HEAD) == new ItemStack(Items.GOLDEN_HELMET)) {
//                player.addEffect(new EffectInstance(Effects.REGENERATION, 80, 0, true, true));
//            }
            System.out.println("Player killed" + event.getEntity().toString());
        }
    }


    @Mod.EventBusSubscriber
    //Adds creative tab
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
