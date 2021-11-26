package net.gendevo.stardewarmory.items.tools;

import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class IridiumHoe extends HoeItem {
    public boolean superTillMode = false;

    public IridiumHoe(IItemTier p_i231595_1_, int p_i231595_2_, float p_i231595_3_, Properties p_i231595_4_) {
        super(p_i231595_1_, p_i231595_2_, p_i231595_3_, p_i231595_4_);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        World world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
        if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
            BlockState blockstate = world.getBlockState(blockpos).getToolModifiedState(world, blockpos, context.getPlayer(), context.getItemInHand(), net.minecraftforge.common.ToolType.HOE);
            if (blockstate != null) {
                PlayerEntity playerentity = context.getPlayer();
                world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!world.isClientSide) {
                    int hurtAmount = 0;
                    if (superTillMode) {
                        if (world.getBlockState(blockpos.north()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                            world.setBlock(blockpos.north(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.north().east()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                           world.setBlock(blockpos.north().east(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.north().west()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                           world.setBlock(blockpos.north().west(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.east()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                           world.setBlock(blockpos.east(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.west()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                            world.setBlock(blockpos.west(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.south()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                            world.setBlock(blockpos.south(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.south().east()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                            world.setBlock(blockpos.south().east(), blockstate, 11);
                            hurtAmount++;
                        }
                        if (world.getBlockState(blockpos.south().west()).getBlock().is(world.getBlockState(blockpos).getBlock())) {
                            world.setBlock(blockpos.south().west(), blockstate, 11);
                            hurtAmount++;
                        }
                    }
                    world.setBlock(blockpos, blockstate, 11);
                    if (playerentity != null) {
                        context.getItemInHand().hurtAndBreak(hurtAmount+1, playerentity, (p_220043_1_) -> {
                            p_220043_1_.broadcastBreakEvent(context.getHand());
                        });
                    }
                }
                return ActionResultType.sidedSuccess(world.isClientSide);
            }
        }

        return ActionResultType.PASS;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide()) {
            superTillMode = !superTillMode;
        } else {
            if (superTillMode) {
                ((ClientWorld)world).playLocalSound(player.blockPosition(), ModSoundEvents.TOGGLE_OFF_SOUND.get(), SoundCategory.PLAYERS, 1, 1, false);
            } else {
                ((ClientWorld)world).playLocalSound(player.blockPosition(), ModSoundEvents.TOGGLE_ON_SOUND.get(), SoundCategory.PLAYERS, 1, 1, false);
            }
        }
        return ActionResult.success(player.getItemInHand(hand));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            if (superTillMode) {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.iridium_hoe_on"));
            } else {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.iridium_hoe_off"));
            }
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.hold_shift"));
        }
    }

}
