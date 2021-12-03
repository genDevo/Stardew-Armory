package net.gendevo.stardewarmory.data.capabilities;

import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IridiumProvider<C> implements ICapabilityProvider {
    private final Capability<C> capability;
    private final LazyOptional<C> implementation;

    protected IridiumProvider(@Nonnull final Capability<C> capability, @Nonnull final LazyOptional<C> implementation) {
        this.capability = capability;
        this.implementation = implementation;
    }

    @Nonnull
    public static <C> IridiumProvider<C> from(@Nonnull final Capability<C> cap, @Nonnull final NonNullSupplier<C> impl) {
        return new IridiumProvider<>(cap, LazyOptional.of(impl));
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull final Capability<T> cap, @Nullable final Direction side) {
        if (cap == this.capability) return this.implementation.cast();
        return LazyOptional.empty();
    }
}
