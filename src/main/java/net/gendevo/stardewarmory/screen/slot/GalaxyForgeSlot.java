package net.gendevo.stardewarmory.screen.slot;

import net.gendevo.stardewarmory.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class GalaxyForgeSlot extends Slot {
    private final boolean cinderSlot;

    public GalaxyForgeSlot(Inventory inventory, int index, int x, int y, boolean cinderSlot) {
        super(inventory, index, x, y);
        this.cinderSlot = cinderSlot;
    }

    @Override
    public int getMaxItemCount() {
        if (isCinderSlot()) {
            return 64;
        } else {
            return 1;
        }
    }

    @Override
    public int getMaxItemCount(ItemStack stack) {
        return getMaxItemCount();
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (isCinderSlot()) {
            return super.canInsert(stack) && stack.getItem().equals(ModItems.CINDER_SHARD);
        } else {
            return super.canInsert(stack) && !stack.getItem().equals(ModItems.CINDER_SHARD);
        }
    }

    public boolean isCinderSlot() {
        return cinderSlot;
    }
}
