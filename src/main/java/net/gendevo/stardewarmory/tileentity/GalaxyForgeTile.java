package net.gendevo.stardewarmory.tileentity;

import net.gendevo.stardewarmory.data.recipes.GalaxyForgeRecipe;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.ModRecipeTypes;
import net.gendevo.stardewarmory.setup.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.Optional;

public class GalaxyForgeTile extends TileEntity implements ITickableTileEntity {

    public ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> inventory = LazyOptional.of(() -> itemHandler);

    public GalaxyForgeTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public GalaxyForgeTile() {
        super(ModTileEntities.GALAXY_FORGE_TILE.get());
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.load(state, nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.save(compound);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot == 2) {
                    return stack.getItem() == ModItems.CINDER_SHARD.get();
                }
                return stack.getItem() != ModItems.CINDER_SHARD.get();
            }

            @Override
            public int getSlotLimit(int slot) {
                if (slot == 2) { return 60; }
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)) {
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return inventory.cast();
        }

        return super.getCapability(cap);
    }

    public final IItemHandlerModifiable getInventory() {
        return this.itemHandler;
    }

    //TODO do the Toole suggestion of different weapons on craft, also make shards part of recipe

    public void craft() {
        Inventory inv = new Inventory(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }

        Optional<GalaxyForgeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.GALAXY_RECIPE, inv, level);

        recipe.ifPresent(iRecipe -> {
            ItemStack output = iRecipe.getResultItem();

            if (itemHandler.getStackInSlot(2).getItem() == ModItems.CINDER_SHARD.get() &&
                    itemHandler.getStackInSlot(2).getCount() == 60) {
                itemHandler.extractItem(0, 1, false);
                itemHandler.extractItem(1, 1, false);
                itemHandler.extractItem(2, 60, false);
                itemHandler.insertItem(0, output, false);
            }

            setChanged();
        });
    }

    @Override
    public void tick() {
        if (level.isClientSide()) return;

        craft();
    }
}
