package net.gendevo.stardewarmory.data.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityIridiumMode {
    @CapabilityInject(IIridiumMode.class)
    public static Capability<IIridiumMode> IRIDIUM_CAPABILITY = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IIridiumMode.class);
    }
}
