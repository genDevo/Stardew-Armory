package net.gendevo.stardewarmory.items.tools;

import com.mojang.datafixers.util.Pair;
import net.gendevo.stardewarmory.data.capabilities.IIridiumMode;
import net.gendevo.stardewarmory.data.capabilities.IridiumModeCapability;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.network.chat.contents.TranslatableContents;
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
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(context, net.minecraftforge.common.ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        if (context.getClickedFace() != Direction.DOWN && level.isEmptyBlock(blockpos.above())) {
            if (pair == null) {
                return InteractionResult.PASS;
            } else {
                Predicate<UseOnContext> predicate = pair.getFirst();
                Consumer<UseOnContext> consumer = pair.getSecond();

                AtomicBoolean isMode = new AtomicBoolean(false);
                context.getItemInHand().getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
                    if (h.isIridiumMode())
                        isMode.set(true);
                });

                if (isMode.get()) {
                    Player player = context.getPlayer();
                    if (predicate.test(context) && player != null) {
                        level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            consumer.accept(context);
                            context.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                        }
                        // North
                        pair = TILLABLES.get(level.getBlockState(blockpos.north()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // South
                        pair = TILLABLES.get(level.getBlockState(blockpos.south()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.south(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // East
                        pair = TILLABLES.get(level.getBlockState(blockpos.east()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.east(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // West
                        pair = TILLABLES.get(level.getBlockState(blockpos.west()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.west(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // North East
                        pair = TILLABLES.get(level.getBlockState(blockpos.north().east()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north().east(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // North West
                        pair = TILLABLES.get(level.getBlockState(blockpos.north().west()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north().west(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // South East
                        pair = TILLABLES.get(level.getBlockState(blockpos.south().east()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.south().east(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        // South West
                        pair = TILLABLES.get(level.getBlockState(blockpos.south().west()).getBlock());
                        if (pair != null) {
                            predicate = pair.getFirst();
                            consumer = pair.getSecond();
                            UseOnContext tempContext = new UseOnContext(player, context.getHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), blockpos.north().west(), context.isInside()));
                            if (predicate.test(tempContext)) {
                                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                                if (!level.isClientSide) {
                                    consumer.accept(tempContext);
                                    tempContext.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                                }
                            }
                        }
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    } else {
                        return InteractionResult.PASS;
                    }

                } else {
                    if (predicate.test(context)) {
                        Player player = context.getPlayer();
                        level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        if (!level.isClientSide) {
                            consumer.accept(context);
                            if (player != null) {
                                context.getItemInHand().hurtAndBreak(1, player, (p_150845_) -> p_150845_.broadcastBreakEvent(context.getHand()));
                            }
                        }
                        return InteractionResult.sidedSuccess(level.isClientSide);
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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
            if (h.isIridiumMode()) {
                tooltip.add(Component.translatable("tooltip.stardewarmory.iridium_hoe_on"));
            } else {
                tooltip.add(Component.translatable("tooltip.stardewarmory.iridium_hoe_off"));
            }
        });
        if (!Objects.isNull(level)) {
            tooltip.add(Component.literal(
                    Component.translatable("tooltip.stardewarmory.press").getString() +
                            KeybindSetup.iridiumKey.getKey().getName().replaceAll("key.keyboard.", "").toUpperCase() +
                            Component.translatable("tooltip.stardewarmory.toggle").getString()
            ));
        }
    }

    @Nullable
    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag tag = stack.getOrCreateTag();
        IIridiumMode cap = stack.getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).orElseThrow(() ->
                new IllegalArgumentException("Could not get Iridium Hoe capability!"));
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
