package net.gendevo.stardewarmory.data.capabilities;

import net.minecraft.nbt.CompoundNBT;

public class IridiumCapabilityImpl implements IIridiumCapability{
    private static final String INFO_NBT_KEY="SAnfo";

    private boolean iridiumMode;

    public IridiumCapabilityImpl() {
        this(false);
    }

    public IridiumCapabilityImpl(final boolean iridiumMode) {
        this.iridiumMode = iridiumMode;
    }

    @Override
    public void setIridiumMode(boolean iridium) {
        this.iridiumMode = iridium;
    }

    @Override
    public boolean isIridiumMode() {
        return this.iridiumMode;
    }

    @Override
    public CompoundNBT serializeNBT() {
        final CompoundNBT nbt = new CompoundNBT();
        nbt.putBoolean(INFO_NBT_KEY, this.isIridiumMode());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        this.setIridiumMode(nbt.getBoolean(INFO_NBT_KEY));
    }




}
