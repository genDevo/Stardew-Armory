package net.gendevo.stardewarmory.data.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IridiumModeProvider implements ICapabilitySerializable<CompoundTag> {

    private final DefaultIridiumMode iridium = new DefaultIridiumMode();
    private final LazyOptional<IIridiumMode> iridiumOptional = LazyOptional.of(() -> iridium);

    public void invalidate() {
        iridiumOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return iridiumOptional.cast();
    }

    @Override
    public CompoundTag serializeNBT() {
        if (CapabilityIridiumMode.IRIDIUM_CAPABILITY == null) {
            return new CompoundTag();
        } else {
            CompoundTag tag = new CompoundTag();
            tag.putBoolean("iridium", iridium.isIridiumMode());
            return tag;
        }
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if (CapabilityIridiumMode.IRIDIUM_CAPABILITY != null) {
            iridium.setIridiumMode(nbt.getBoolean("iridium"));
        }
    }
}
