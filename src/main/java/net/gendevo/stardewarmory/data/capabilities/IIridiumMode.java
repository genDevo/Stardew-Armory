package net.gendevo.stardewarmory.data.capabilities;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IIridiumMode extends INBTSerializable<CompoundTag> {
    void setIridiumMode(boolean iridium);

    boolean isIridiumMode();
}
