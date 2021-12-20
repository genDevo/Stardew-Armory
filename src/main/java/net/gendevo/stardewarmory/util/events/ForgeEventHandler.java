package net.gendevo.stardewarmory.util.events;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.data.capabilities.CapabilityIridiumMode;
import net.gendevo.stardewarmory.data.capabilities.IridiumModeProvider;
import net.gendevo.stardewarmory.items.tools.IridiumAxe;
import net.gendevo.stardewarmory.items.tools.IridiumHoe;
import net.gendevo.stardewarmory.items.tools.IridiumPick;
import net.gendevo.stardewarmory.items.tools.IridiumShovel;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Random;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventHandler {

    @SubscribeEvent
    public static void onBlockBreak(final BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        Item heldItem = player.getMainHandItem().getItem();
        ItemStack heldItemStack = player.getMainHandItem();
        LevelAccessor eWorld = event.getWorld();
        if (!eWorld.isClientSide()) {
            if (heldItem instanceof IridiumPick) {
                heldItemStack.getCapability(CapabilityIridiumMode.IRIDIUM_CAPABILITY).ifPresent(h -> {
                    if (h.isIridiumMode() && player.hasCorrectToolForDrops(eWorld.getBlockState(event.getPos().below()))) {
                        if (player.getItemInHand(InteractionHand.MAIN_HAND).getEnchantmentTags().toString().contains("silk_touch")) {
                            Block.popResource(player.level, event.getPos().below(),
                                    eWorld.getBlockState(event.getPos().below()).getBlock().asItem().getDefaultInstance());
                            eWorld.removeBlock(event.getPos().below(), true);
                        } else {
                            eWorld.destroyBlock(event.getPos().below(), true);
                        }
                        player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(1, player, (p_220043_1_) -> {
                            p_220043_1_.broadcastBreakEvent(InteractionHand.MAIN_HAND);
                        });
                    }
                });
            } else if (heldItem instanceof IridiumAxe) {
                heldItemStack.getCapability(CapabilityIridiumMode.IRIDIUM_CAPABILITY).ifPresent(h -> {
                    if (h.isIridiumMode()) {
                        BlockPos oPos = event.getPos();
                        Block originBlock = eWorld.getBlockState(oPos).getBlock();
                        player.getItemInHand(InteractionHand.MAIN_HAND).hurtAndBreak(
                                feller(eWorld, player, originBlock, oPos, false, 0),
                                player, (p_220043_1_) -> {
                                    p_220043_1_.broadcastBreakEvent(InteractionHand.MAIN_HAND);
                                });
                    }
                });
            } else if (heldItem instanceof IridiumShovel) {
                heldItemStack.getCapability(CapabilityIridiumMode.IRIDIUM_CAPABILITY).ifPresent(h -> {
                    if (h.isIridiumMode()) {
                        if (eWorld.getBlockState(event.getPos()).getBlock().equals(Blocks.SAND) ||
                                eWorld.getBlockState(event.getPos()).getBlock().equals(Blocks.RED_SAND)) {
                            Block.popResource(event.getPlayer().level, event.getPos(), Blocks.GLASS.asItem().getDefaultInstance());
                            eWorld.removeBlock(event.getPos(), true);
                            event.setCanceled(true);
                        } else if (eWorld.getBlockState(event.getPos()).getBlock().equals(Blocks.CLAY)) {
                            Block.popResource(event.getPlayer().level, event.getPos(), Blocks.TERRACOTTA.asItem().getDefaultInstance());
                            eWorld.removeBlock(event.getPos(), true);
                            event.setCanceled(true);
                        }
                    }
                });
            }
        }
    }

    private static int feller(LevelAccessor eWorld, Player player, Block oBlock, BlockPos oPos, boolean subFeller, int totalBroken) {
        BlockPos cPos = oPos;
        while ((eWorld.getBlockState(cPos.above()).getBlock().equals(oBlock) || subFeller) &&
                (player.hasCorrectToolForDrops(eWorld.getBlockState(cPos)) && !(oBlock instanceof LeavesBlock))) {
            if (eWorld.getBlockState(cPos.north()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.north(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.north(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.south()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.south(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.south(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.east()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.east(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.east(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.west()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.west(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.west(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().north().east()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.above().north().east(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().north().east(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().north().west()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.above().north().west(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().north().west(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().south().east()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.above().south().east(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().south().east(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().south().west()).getBlock().equals(oBlock)) {
                eWorld.destroyBlock(cPos.above().south().west(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().south().west(), true, totalBroken) + 1;
            }
            if (subFeller) {
                if (eWorld.getBlockState(cPos.north().east()).getBlock().equals(oBlock)) {
                    eWorld.destroyBlock(cPos.north().east(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.north().east(), true, totalBroken) + 1;
                }
                if (eWorld.getBlockState(cPos.north().west()).getBlock().equals(oBlock)) {
                    eWorld.destroyBlock(cPos.north().west(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.north().west(), true, totalBroken) + 1;
                }
                if (eWorld.getBlockState(cPos.south().east()).getBlock().equals(oBlock)) {
                    eWorld.destroyBlock(cPos.south().east(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.south().east(), true, totalBroken) + 1;
                }
                if (eWorld.getBlockState(cPos.south().west()).getBlock().equals(oBlock)) {
                    eWorld.destroyBlock(cPos.south().west(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.south().west(), true, totalBroken) + 1;
                }
            }
            if (eWorld.getBlockState(cPos.above()).getBlock().equals(oBlock)) {
                totalBroken++;
                eWorld.destroyBlock(cPos.above(), true);
            }
            subFeller = false;
            cPos = cPos.above();
        }
        return totalBroken;
    }

    @SubscribeEvent
    public static void onPlayerAttacked(final LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof Player && !event.getEntityLiving().level.isClientSide()) {
            Player player = (Player) event.getEntityLiving();

            // Slime charmer effect
            if (event.getSource().getEntity() instanceof Slime) {
                if (isRingEquipped(player, ModItems.SLIME_CHARMER_RING.get())) {
                    event.setCanceled(true);
                }
            }

            // Yoba effect
            if (isRingEquipped(player, ModItems.YOBA_RING.get())) {
                if (new Random().nextInt(20) == 1) {
                    player.level.playSound(null, player.xo, player.yo, player.zo, ModSoundEvents.YOBA_SOUND.get(), SoundSource.PLAYERS, 1, 1);
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 80, 0));
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerKillEntity(final LivingDeathEvent event) {
        if (event.getSource() instanceof EntityDamageSource && !event.getEntityLiving().level.isClientSide()) {
            if (event.getSource().getEntity() instanceof Player && !(event.getEntityLiving() instanceof Animal)) {
                Player player = (Player) event.getSource().getEntity();

                // Glutton effect
                if (isRingEquipped(player, ModItems.SOUL_GLUTTON_RING.get())) {
                    int cFood = player.getFoodData().getFoodLevel();
                    player.getFoodData().setFoodLevel(cFood + 1);
                }

                // Vampire effect
                if (isRingEquipped(player, ModItems.VAMPIRE_RING.get())) {
                    player.heal(1f);
                }

                // Savage effect
                if (isRingEquipped(player, ModItems.SAVAGE_RING.get())) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, 0));
                }

                // Napalm effect
                if (isRingEquipped(player, ModItems.NAPALM_RING.get())) {
                    double x = event.getEntityLiving().xo;
                    double y = event.getEntityLiving().yo;
                    double z = event.getEntityLiving().zo;
                    event.getEntityLiving().level.explode(player, x, y, z, 1, Explosion.BlockInteraction.NONE);
                }

                // Warrior effect
                if (isRingEquipped(player, ModItems.WARRIOR_RING.get())) {
                    if (new Random().nextInt(StardewArmoryConfig.warrior_rate.get()) == 1) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, 2));
                    }
                }
            }
        }
    }

    private static boolean isRingEquipped(Player player, Item item) {
        for (int i = 0; i < CuriosApi.getCuriosHelper().getEquippedCurios(player).resolve().get().getSlots(); i++) {
            if (CuriosApi.getCuriosHelper().getEquippedCurios(player).resolve().get().getStackInSlot(i).getItem() == item)
                return true;
        }
        return false;
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<ItemStack> event) {
        Item cItem = event.getObject().getItem();
        if (cItem instanceof IridiumHoe || cItem instanceof IridiumShovel || cItem instanceof IridiumPick || cItem instanceof IridiumAxe) {
            IridiumModeProvider provider = new IridiumModeProvider();
            event.addCapability(new ResourceLocation(StardewArmory.MOD_ID, "iridium_mode"), provider);
            event.addListener(provider::invalidate);
        }
    }

//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent e) {
//        if (e.side.isServer()) {
//            e.player.getMainHandItem().getCapability(IridiumCapabilityManager.IRIDIUM_CAPABILITY).ifPresent(h -> {
//                if (h.isIridiumMode()) {
//                    //ModNetwork.CHANNEL.send(PacketDistributor.TRACKING_ENTITY.with(() -> e.player), new PacketClientboundIridium(true));
//                }
//            });
//        }
//    }

    // Zombies can now spawn with wood club in hand
    @SubscribeEvent
    public static void giveClub(final EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof Zombie)) {
            return;
        }
        if (!event.getEntity().level.isClientSide()) {
            Zombie zombie = (Zombie) event.getEntity();
            if (Math.random() > (1 - StardewArmoryConfig.club_rate.get())) {
                zombie.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(ModItems.WOOD_CLUB.get()));
            }
        }
    }
}
