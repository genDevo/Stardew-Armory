package net.gendevo.stardewarmory.network;

import net.gendevo.stardewarmory.data.capabilities.IridiumCapabilityManager;
import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketToggleIridium {
    public int key;

    public PacketToggleIridium(int key) {
        this.key = key;
    }

    public static void encode(PacketToggleIridium message, PacketBuffer buffer) {
        buffer.writeInt(message.key);
    }

    public static PacketToggleIridium decode(PacketBuffer buffer) {
        return new PacketToggleIridium(buffer.readInt());
    }

    public static void handle(PacketToggleIridium message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayerEntity player = context.getSender();
            // Sets tool to on
            player.getMainHandItem().getCapability(IridiumCapabilityManager.IRIDIUM_CAPABILITY).ifPresent(h -> h.setIridiumMode(!h.isIridiumMode()));
            World world = player.getLevel();
            // Plays sound for mode on/off
            player.getMainHandItem().getCapability(IridiumCapabilityManager.IRIDIUM_CAPABILITY).ifPresent(h -> {
                if (h.isIridiumMode()) {
                    world.playSound(null, player.xo, player.yo + 0.8, player.zo, ModSoundEvents.TOGGLE_ON_SOUND.get(), SoundCategory.PLAYERS, 0.8f, 1f);
                } else {
                    world.playSound(null, player.xo, player.yo + 0.8, player.zo, ModSoundEvents.TOGGLE_OFF_SOUND.get(), SoundCategory.PLAYERS, 0.8f, 1f);
                }
            });
        });
        context.setPacketHandled(true);
    }
}
