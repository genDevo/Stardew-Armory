package net.gendevo.stardewarmory.blocks.entities;

import net.gendevo.stardewarmory.data.recipes.GalaxyForgeRecipe;
import net.gendevo.stardewarmory.screen.GalaxyForgeMenu;
import net.gendevo.stardewarmory.setup.ModBlockEntities;
import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;

public class GalaxyForgeBlockEntity extends BlockEntity implements MenuProvider {

    public ItemStackHandler itemHandler = createHandler();
    private LazyOptional<IItemHandler> inventory = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 60;


    public GalaxyForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GALAXY_FORGE.get(), pos, state);
        this.data = new ContainerData() {
            public int get(int index) {
                switch (index) {
                    case 0: return GalaxyForgeBlockEntity.this.progress;
                    case 1: return GalaxyForgeBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            public void set(int index, int value) {
                switch(index) {
                    case 0: GalaxyForgeBlockEntity.this.progress = value; break;
                    case 1: GalaxyForgeBlockEntity.this.maxProgress = value; break;
                }
            }

            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.inventory = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void load(CompoundTag pTag) {
        itemHandler.deserializeNBT(pTag.getCompound("inv"));
        progress = pTag.getInt("galaxy_forge_progress");
        super.load(pTag);
    }

    @Override
    public void saveAdditional(CompoundTag compound) {
        compound.put("inv", itemHandler.serializeNBT());
        compound.putInt("galaxy_forge_progress", progress);
        super.saveAdditional(compound);
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
                if (slot == 2) {
                    return 60;
                }
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
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

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
    }

    private static boolean hasRecipe(GalaxyForgeBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GalaxyForgeRecipe> match = level.getRecipeManager()
                .getRecipeFor(GalaxyForgeRecipe.GalaxyForgeRecipeType.INSTANCE, inventory, level);

        return match.isPresent();
    }

    //TODO do the Toole suggestion of different weapons on craft, also make shards part of recipe
    public static void craft(GalaxyForgeBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inv.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<GalaxyForgeRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(GalaxyForgeRecipe.GalaxyForgeRecipeType.INSTANCE, inv, level);

        if (recipe.isPresent()) {
            ItemStack output = recipe.get().getResultItem();

            if (entity.itemHandler.getStackInSlot(2).getItem() == ModItems.CINDER_SHARD.get() &&
                    entity.itemHandler.getStackInSlot(2).getCount() == 60) {
                entity.itemHandler.extractItem(0, 1, false);
                entity.itemHandler.extractItem(1, 1, false);
                entity.itemHandler.extractItem(2, 60, false);
                entity.itemHandler.insertItem(0, output, false);
            }
            entity.resetProgress();
        }
    }
    public static void tick(Level level, BlockPos pos, BlockState state, GalaxyForgeBlockEntity blockEntity) {
        if (hasRecipe(blockEntity)) {
            blockEntity.progress++;
            setChanged(level, pos, state);
            if (blockEntity.progress > blockEntity.maxProgress) {
                craft(blockEntity);
            }
        } else {
            blockEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("block.stardewarmory.galaxy_forge");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new GalaxyForgeMenu(pContainerId, pInventory, this, this.data);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        inventory.invalidate();
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
