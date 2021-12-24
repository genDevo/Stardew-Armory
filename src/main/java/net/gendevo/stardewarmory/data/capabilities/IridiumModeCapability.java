package net.gendevo.stardewarmory.data.capabilities;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

public class IridiumModeCapability {

    public static final Capability<IIridiumMode> IRIDIUM_CAPABILITY = CapabilityManager.get(new CapabilityToken<IIridiumMode>() {});

    public static void register(RegisterCapabilitiesEvent event) {
        event.register(IIridiumMode.class);
    }

    private IridiumModeCapability() {}
}
