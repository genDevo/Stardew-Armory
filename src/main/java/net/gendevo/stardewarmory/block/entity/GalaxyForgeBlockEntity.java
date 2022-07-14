package net.gendevo.stardewarmory.block.entity;

import net.gendevo.stardewarmory.item.ModItems;
import net.gendevo.stardewarmory.item.inventory.ImplementedInventory;
import net.gendevo.stardewarmory.recipe.GalaxyForgeRecipe;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GalaxyForgeBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    protected final PropertyDelegate propertyDelegate;
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);
    private int progress = 0;
    private int maxProgress = 108;

    public GalaxyForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GALAXY_FORGE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                return switch (index) {
                    case 0 -> GalaxyForgeBlockEntity.this.progress;
                    case 1 -> GalaxyForgeBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GalaxyForgeBlockEntity.this.progress = value;
                    case 1 -> GalaxyForgeBlockEntity.this.maxProgress = value;
                }
            }

            public int size() {
                return 2;
            }
        };
    }

    public static void tick(World world, BlockPos pos, BlockState state, GalaxyForgeBlockEntity entity) {
        if (hasRecipe(entity)) {
            entity.progress++;
            if (entity.progress > entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(GalaxyForgeBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<GalaxyForgeRecipe> match = world.getRecipeManager()
                .getFirstMatch(GalaxyForgeRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent()
                && entity.getStack(GalaxyForgeScreenHandler.SLOT_CINDER_SHARDS).getCount() >= match.get().getReqShards();
    }

    private static void craftItem(GalaxyForgeBlockEntity entity) {
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for (int i = 0; i < entity.inventory.size(); i++) {
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<GalaxyForgeRecipe> match = world.getRecipeManager()
                .getFirstMatch(GalaxyForgeRecipe.Type.INSTANCE, inventory, world);

        if (match.isPresent()) {
            entity.removeStack(0, 1);
            entity.removeStack(1, 1);
            entity.removeStack(2, match.get().getReqShards());
            entity.setStack(GalaxyForgeScreenHandler.SLOT_INPUT_ONTO, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(1).getCount() + 1));

            entity.resetProgress();
        }
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public Text getDisplayName() {
        return Text.translatable("block.stardewarmory.galaxy_forge");
    }

    @Nullable
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new GalaxyForgeScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        if (slot == 2 && stack.getItem().equals(ModItems.CINDER_SHARD)) {
            return ImplementedInventory.super.isValid(slot, stack);
        } else {
            return false;
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
