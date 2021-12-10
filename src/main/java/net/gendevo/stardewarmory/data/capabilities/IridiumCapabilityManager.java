package net.gendevo.stardewarmory.data.capabilities;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.items.tools.IridiumAxe;
import net.gendevo.stardewarmory.items.tools.IridiumHoe;
import net.gendevo.stardewarmory.items.tools.IridiumPick;
import net.gendevo.stardewarmory.items.tools.IridiumShovel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class IridiumCapabilityManager {
    public static final ResourceLocation IRIDIUM_CAPABILITY_NAME = new ResourceLocation(StardewArmory.MOD_ID, "iridium_capability");
    @CapabilityInject(IIridiumCapability.class)
    @Nonnull
    @SuppressWarnings("ConstantConditions")
    public static Capability<IIridiumCapability> IRIDIUM_CAPABILITY = null;


    public static void registerCapabilities() {
        CapabilityManager.INSTANCE.register(
                IIridiumCapability.class,
                SimpleCapabilityStorage.create(() -> IRIDIUM_CAPABILITY, Constants.NBT.TAG_COMPOUND),
                IridiumCapabilityImpl::new
        );

    }

    @SubscribeEvent
    public static void onStackAttachCapabilites(@Nonnull final AttachCapabilitiesEvent<ItemStack> e) {
        final Item obj = e.getObject().getItem();
        final IIridiumCapability capability = new IridiumCapabilityImpl();
        if (obj instanceof IridiumAxe || obj instanceof IridiumPick || obj instanceof IridiumShovel || obj instanceof IridiumHoe) {
            e.addCapability(
                    IRIDIUM_CAPABILITY_NAME,
                    IridiumProvider.from(IRIDIUM_CAPABILITY, () -> capability)
            );
        }
    }
}
