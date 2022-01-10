package net.gendevo.stardewarmory.screen.slot;

import net.gendevo.stardewarmory.item.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class GalaxyForgeSlot extends Slot {
    private boolean cinderSlot;

    public GalaxyForgeSlot(Inventory inventory, int index, int x, int y, boolean cinderSlot) {
        super(inventory, index, x, y);
        this.cinderSlot = cinderSlot;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        if (cinderSlot) {
            return stack.getItem().equals(ModItems.CINDER_SHARD);
        } else {
            return super.canInsert(stack) && !stack.getItem().equals(ModItems.CINDER_SHARD);
        }
    }
}
