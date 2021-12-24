package net.gendevo.stardewarmory.items.tools;

import net.gendevo.stardewarmory.data.capabilities.IIridiumMode;
import net.gendevo.stardewarmory.data.capabilities.IridiumModeCapability;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class IridiumHoe extends HoeItem {

    public IridiumHoe(Tier p_i231595_1_, int p_i231595_2_, float p_i231595_3_, Properties p_i231595_4_) {
        super(p_i231595_1_, p_i231595_2_, p_i231595_3_, p_i231595_4_);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? InteractionResult.SUCCESS : InteractionResult.FAIL;
        if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
            BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, context.getPlayer(), context.getItemInHand(), ToolAction.get("hoe"));
            if (blockstate != null) {
                Player playerentity = context.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    context.getItemInHand().getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
                        if (h.isIridiumMode()) {
                            int hurtAmount = 0;
                            if (world.getBlockState(blockpos.north()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.north(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.north().east()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.north().east(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.north().west()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.north().west(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.east()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.east(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.west()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.west(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.south()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.south(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.south().east()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.south().east(), blockstate, 11);
                                hurtAmount++;
                            }
                            if (world.getBlockState(blockpos.south().west()).getBlock().equals(world.getBlockState(blockpos).getBlock())) {
                                world.setBlock(blockpos.south().west(), blockstate, 11);
                                hurtAmount++;
                            }
                            // Finally damages the tool
                            if (playerentity != null) {
                                context.getItemInHand().hurtAndBreak(hurtAmount, playerentity, (p_220043_1_) -> {
                                    p_220043_1_.broadcastBreakEvent(context.getHand());
                                });
                            }
                        }
                    });
                    world.setBlock(blockpos, blockstate, 11);
                    if (playerentity != null) {
                        context.getItemInHand().hurtAndBreak(1, playerentity, (p_220043_1_) -> {
                            p_220043_1_.broadcastBreakEvent(context.getHand());
                        });
                    }
                }
                return InteractionResult.sidedSuccess(world.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
            if (h.isIridiumMode()) {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.iridium_hoe_on"));
            } else {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.iridium_hoe_off"));
            }
        });
        if (!Objects.isNull(world)) {
            tooltip.add(new TextComponent(new TranslatableComponent("tooltip.stardewarmory.press").getString() +
                    KeybindSetup.iridiumKey.getKey().getName().replaceAll("key.keyboard.", "").toUpperCase() +
                    new TranslatableComponent("tooltip.stardewarmory.toggle").getString()));
        }
    }

    @Nullable
    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        IIridiumMode cap = stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).orElseThrow(() ->
                new IllegalArgumentException("Capability was empty on get, oh no!"));

        tag.putBoolean("SAnfo", cap.isIridiumMode());
        System.out.println(cap.isIridiumMode());
        return tag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag tag) {
        super.readShareTag(stack, tag);

        if (tag != null) {
            IIridiumMode cap = stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY, null).orElseThrow(() ->
                    new IllegalArgumentException("Capability was empty on read, oh no!"));
            cap.setIridiumMode(tag.getBoolean("SAnfo"));
            System.out.println(cap.isIridiumMode());
        }
    }

}
