package net.gendevo.stardewarmory.blockentity;

import net.gendevo.stardewarmory.data.recipes.GalaxyForgeRecipe;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.ModRecipeTypes;
import net.gendevo.stardewarmory.setup.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.Optional;

public class GalaxyForgeBlockEntity extends BlockEntity {

    public ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> inventory = LazyOptional.of(() -> itemHandler);


    public GalaxyForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GALAXY_FORGE.get(), pos, state);
    }

    @Override
    public void load(CompoundTag pTag) {
        itemHandler.deserializeNBT(pTag.getCompound("inv"));
        super.load(pTag);
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
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

    //TODO do the Toole suggestion of different weapons on craft, also make shards part of recipe
    public void craft() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
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

    public void tick() {
        if (level.isClientSide()) { return; }

        craft();
    }
}
