package net.gendevo.stardewarmory.network;

import net.gendevo.stardewarmory.data.capabilities.IridiumModeCapability;
import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PacketToggleIridium {
    public int key;

    public PacketToggleIridium(int key) {
        this.key = key;
    }

    public static void encode(PacketToggleIridium message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.key);
    }

    public static PacketToggleIridium decode(FriendlyByteBuf buffer) {
        return new PacketToggleIridium(buffer.readInt());
    }

    public static void handle(PacketToggleIridium message, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            // Sets tool to on
            player.getMainHandItem().getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> h.setIridiumMode(!h.isIridiumMode()));

            Level world = player.getLevel();
            // Plays sound for mode on/off
            player.getMainHandItem().getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
                if (h.isIridiumMode()) {
                    world.playSound(null, player.xo, player.yo + 0.8, player.zo, ModSoundEvents.TOGGLE_ON_SOUND.get(), SoundSource.PLAYERS, 0.8f, 1f);
                    player.swing(InteractionHand.MAIN_HAND, true);
                } else {
                    world.playSound(null, player.xo, player.yo + 0.8, player.zo, ModSoundEvents.TOGGLE_OFF_SOUND.get(), SoundSource.PLAYERS, 0.8f, 1f);
                    player.swing(InteractionHand.MAIN_HAND, true);
                }
            });
        });
        context.setPacketHandled(true);
    }
}
