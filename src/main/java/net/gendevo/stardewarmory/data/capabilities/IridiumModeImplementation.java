package net.gendevo.stardewarmory.data.capabilities;

import net.minecraft.nbt.CompoundTag;

public class IridiumModeImplementation implements IIridiumMode {
    private static final String NBT_KEY_IRIDIUM_MODE = "iridiumMode";
    private boolean isOn;

    @Override
    public void setIridiumMode(boolean iridium) {
        this.isOn = iridium;
    }

    @Override
    public boolean isIridiumMode() {
        return isOn;
    }

    @Override
    public CompoundTag serializeNBT() {
        final CompoundTag tag = new CompoundTag();
        tag.putBoolean(NBT_KEY_IRIDIUM_MODE, this.isOn);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.isOn = nbt.getBoolean(NBT_KEY_IRIDIUM_MODE);
    }
}
