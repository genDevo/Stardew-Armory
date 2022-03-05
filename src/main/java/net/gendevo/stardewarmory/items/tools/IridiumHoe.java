package net.gendevo.stardewarmory.items.tools;

import com.mojang.datafixers.util.Pair;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IridiumHoe extends HoeItem {

    public IridiumHoe(Tier p_i231595_1_, int p_i231595_2_, float p_i231595_3_, Properties p_i231595_4_) {
        super(p_i231595_1_, p_i231595_2_, p_i231595_3_, p_i231595_4_);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = TILLABLES.get(world.getBlockState(blockpos).getBlock());
        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? InteractionResult.SUCCESS : InteractionResult.FAIL;
        if (context.getClickedFace() != Direction.DOWN && world.isEmptyBlock(blockpos.above())) {
            if (pair == null) {
                return InteractionResult.PASS;
            } else {
                Predicate<UseOnContext> predicate = pair.getFirst();
                Consumer<UseOnContext> consumer = pair.getSecond();
                AtomicBoolean isMode = new AtomicBoolean(false);
                context.getItemInHand().getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
                    if (h.isIridiumMode()) isMode.set(true);
                });
                if (isMode.get()) {
                    if (predicate.test(context)) {
                        Player player = context.getPlayer();
                        world.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (!world.isClientSide) {
                            consumer.accept(context);
                            if (player != null) {
                                context.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                            }
                        }
                        UseOnContext tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerEntity = context.getPlayer();
                            world.playSound(playerEntity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerEntity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerEntity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.south(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerEntity = context.getPlayer();
                            world.playSound(playerEntity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerEntity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerEntity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.east(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerentity = context.getPlayer();
                            world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerentity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerentity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.west(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerentity = context.getPlayer();
                            world.playSound(playerentity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerentity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerentity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north().east(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerEntity = context.getPlayer();
                            world.playSound(playerEntity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerEntity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerEntity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north().west(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerEntity = context.getPlayer();
                            world.playSound(playerEntity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerEntity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerEntity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.south().east(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerEntity = context.getPlayer();
                            world.playSound(playerEntity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerEntity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerEntity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        tempContext = new UseOnContext(context.getPlayer(), context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north().west(), context.isInside()));
                        if (predicate.test(tempContext)) {
                            Player playerEntity = context.getPlayer();
                            world.playSound(playerEntity, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                            if (!world.isClientSide) {
                                consumer.accept(tempContext);
                                if (playerEntity != null) {
                                    tempContext.getItemInHand().hurtAndBreak(1, playerEntity, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        return InteractionResult.sidedSuccess(world.isClientSide);
                    } else {
                        return InteractionResult.PASS;
                    }

                } else {
                    if (predicate.test(context)) {
                        Player player = context.getPlayer();
                        world.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (!world.isClientSide) {
                            consumer.accept(context);
                            if (player != null) {
                                context.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                            }
                        }
                        return InteractionResult.sidedSuccess(world.isClientSide);
                    } else {
                        return InteractionResult.PASS;
                    }
                }
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
            tooltip.add(new TextComponent(new TranslatableComponent("tooltip.stardewarmory.press").getString() + KeybindSetup.iridiumKey.getKey().getName().replaceAll("key.keyboard.", "").toUpperCase() + new TranslatableComponent("tooltip.stardewarmory.toggle").getString()));
        }
    }

    @Nullable
    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        IIridiumMode cap = stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).orElseThrow(() -> new IllegalArgumentException("Capability was empty on get, oh no!"));

        tag.putBoolean("SAnfo", cap.isIridiumMode());
        System.out.println(cap.isIridiumMode());
        return tag;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag tag) {
        super.readShareTag(stack, tag);

        if (tag != null) {
            IIridiumMode cap = stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY, null).orElseThrow(() -> new IllegalArgumentException("Capability was empty on read, oh no!"));
            cap.setIridiumMode(tag.getBoolean("SAnfo"));
            System.out.println(cap.isIridiumMode());
        }
    }
}
