package net.gendevo.stardewarmory.data.capabilities;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class IridiumModeAttacher {

    private static class IridiumModeProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

        public static final ResourceLocation IDENTIFIER = new ResourceLocation(StardewArmory.MOD_ID, "iridium_mode");

        private final IIridiumMode backend = new IridiumModeImplementation();
        private final LazyOptional<IIridiumMode> optionalData = LazyOptional.of(() -> backend);

        @NotNull
        @Override
        public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            return IridiumModeCapability.IRIDIUM_CAPABILITY.orEmpty(cap, this.optionalData);
        }

        void invalidate() {
            this.optionalData.invalidate();
        }

        @Override
        public CompoundTag serializeNBT() {
            return this.backend.serializeNBT();
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            this.backend.deserializeNBT(nbt);
        }
    }

    public static void attach(final AttachCapabilitiesEvent<ItemStack> event) {
        final IridiumModeProvider provider = new IridiumModeProvider();

        event.addCapability(IridiumModeProvider.IDENTIFIER, provider);
        provider.invalidate();
    }

    private IridiumModeAttacher() {}
}
