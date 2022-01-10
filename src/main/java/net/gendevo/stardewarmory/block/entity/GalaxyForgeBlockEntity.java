package net.gendevo.stardewarmory.block.entity;

import net.gendevo.stardewarmory.item.ModItems;
import net.gendevo.stardewarmory.item.inventory.ImplementedInventory;
import net.gendevo.stardewarmory.screen.GalaxyForgeScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GalaxyForgeBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory =
            DefaultedList.ofSize(3, ItemStack.EMPTY);

    public GalaxyForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GALAXY_FORGE_BLOCK_ENTITY, pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public Text getDisplayName() {
        return new TranslatableText("block.stardewarmory.galaxy_forge");
    }

    @Nullable
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new GalaxyForgeScreenHandler(syncId, inv, this);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
    }

    public static void tick(World world, BlockPos pos, BlockState state, GalaxyForgeBlockEntity entity) {
        if(hasRecipe(entity) && hasNotReachedStackLimit(entity)) {
            craftItem(entity);
        }
    }

    private static void craftItem(GalaxyForgeBlockEntity entity) {
        entity.removeStack(0, 1);
        entity.removeStack(1, 1);

        entity.setStack(2, new ItemStack(ModItems.PRISMATIC_SHARD, entity.getStack(2).getCount() + 1));
    }

    private static boolean hasRecipe(GalaxyForgeBlockEntity entity) {
        boolean hasItemInFirstSlot = entity.getStack(0).getItem() == Items.DIRT;
        boolean hasItemInSecondSlot = entity.getStack(1).getItem() == Items.IRON_INGOT;

        return hasItemInFirstSlot && hasItemInSecondSlot;
    }

    private static boolean hasNotReachedStackLimit(GalaxyForgeBlockEntity entity) {
        return entity.getStack(2).getCount() < entity.getStack(2).getMaxCount();
    }
}
