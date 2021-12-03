package net.gendevo.stardewarmory.data.capabilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public interface IIridiumCapability extends INBTSerializable<CompoundNBT> {

    void setIridiumMode(boolean iridium);

    boolean isIridiumMode();
}
