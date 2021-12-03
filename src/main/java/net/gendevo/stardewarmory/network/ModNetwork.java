package net.gendevo.stardewarmory.network;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class ModNetwork {

    public static final String NETWORK_VERSION = "0.1.0";

    public static final SimpleChannel CHANNEL = NetworkRegistry
            .newSimpleChannel(new ResourceLocation(StardewArmory.MOD_ID, "network"),
                    () -> NETWORK_VERSION,
                    version -> version.equals(NETWORK_VERSION),
                    version -> version.equals(NETWORK_VERSION)
            );

    public static void init() {
        CHANNEL.registerMessage(0, PacketToggleIridium.class, PacketToggleIridium::encode, PacketToggleIridium::decode, PacketToggleIridium::handle);
    }
}
