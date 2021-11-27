package net.gendevo.stardewarmory.util.events;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.setup.ModItems;
import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.gendevo.stardewarmory.items.tools.IridiumAxe;
import net.gendevo.stardewarmory.items.tools.IridiumPick;
import net.gendevo.stardewarmory.items.tools.IridiumShovel;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Timer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.TickEvent;
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
        PlayerEntity player = event.getPlayer();
        Item heldItem = player.getMainHandItem().getItem();
        IWorld eWorld = event.getWorld();
        if (!eWorld.isClientSide()) {
            if (heldItem instanceof IridiumPick) {
                if (((IridiumPick) heldItem).tunnelMode) {
                    if (player.getItemInHand(Hand.MAIN_HAND).getEnchantmentTags().toString().contains("silk_touch")) {
                        Block.popResource(player.level, event.getPos().below(),
                                eWorld.getBlockState(event.getPos().below()).getBlock().asItem().getDefaultInstance());
                        eWorld.removeBlock(event.getPos().below(), true);
                    } else {
                        eWorld.destroyBlock(event.getPos().below(), true);
                    }
                    player.getItemInHand(Hand.MAIN_HAND).hurtAndBreak(1, player, (p_220043_1_) -> {
                        p_220043_1_.broadcastBreakEvent(Hand.MAIN_HAND);
                    });
                }
            } else if (heldItem instanceof IridiumAxe) {
                if (((IridiumAxe) heldItem).fellMode) {
                    BlockPos oPos = event.getPos();
                    Block originBlock = eWorld.getBlockState(oPos).getBlock();
                    player.getItemInHand(Hand.MAIN_HAND).hurtAndBreak(
                            feller(eWorld, player, originBlock, oPos, false, 0),
                            player, (p_220043_1_) -> {
                                p_220043_1_.broadcastBreakEvent(Hand.MAIN_HAND);
                            });
                }
            } else if (heldItem instanceof IridiumShovel) {
                if (((IridiumShovel) heldItem).smeltMode) {
                    if (eWorld.getBlockState(event.getPos()).getBlock().is(Blocks.SAND) ||
                            eWorld.getBlockState(event.getPos()).getBlock().is(Blocks.RED_SAND)) {
                        Block.popResource(event.getPlayer().level, event.getPos(), Blocks.GLASS.asItem().getDefaultInstance());
                        eWorld.removeBlock(event.getPos(), true);
                        event.setCanceled(true);
                    } else if (eWorld.getBlockState(event.getPos()).getBlock().is(Blocks.CLAY)) {
                        Block.popResource(event.getPlayer().level, event.getPos(), Blocks.TERRACOTTA.asItem().getDefaultInstance());
                        eWorld.removeBlock(event.getPos(), true);
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    private static int feller(IWorld eWorld, PlayerEntity player, Block oBlock, BlockPos oPos, boolean subFeller, int totalBroken) {
        BlockPos cPos = oPos;
        while ((eWorld.getBlockState(cPos.above()).getBlock().is(oBlock) || subFeller) &&
                (player.hasCorrectToolForDrops(eWorld.getBlockState(cPos)) && !(oBlock instanceof LeavesBlock))) {
            if (eWorld.getBlockState(cPos.north()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.north(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.north(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.south()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.south(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.south(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.east()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.east(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.east(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.west()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.west(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.west(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().north().east()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.above().north().east(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().north().east(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().north().west()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.above().north().west(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().north().west(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().south().east()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.above().south().east(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().south().east(), true, totalBroken) + 1;
            }
            if (eWorld.getBlockState(cPos.above().south().west()).getBlock().is(oBlock)) {
                eWorld.destroyBlock(cPos.above().south().west(), true);
                totalBroken = feller(eWorld, player, oBlock, cPos.above().south().west(), true, totalBroken) + 1;
            }
            if (subFeller) {
                if (eWorld.getBlockState(cPos.north().east()).getBlock().is(oBlock)) {
                    eWorld.destroyBlock(cPos.north().east(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.north().east(), true, totalBroken) + 1;
                }
                if (eWorld.getBlockState(cPos.north().west()).getBlock().is(oBlock)) {
                    eWorld.destroyBlock(cPos.north().west(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.north().west(), true, totalBroken) + 1;
                }
                if (eWorld.getBlockState(cPos.south().east()).getBlock().is(oBlock)) {
                    eWorld.destroyBlock(cPos.south().east(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.south().east(), true, totalBroken) + 1;
                }
                if (eWorld.getBlockState(cPos.south().west()).getBlock().is(oBlock)) {
                    eWorld.destroyBlock(cPos.south().west(), true);
                    totalBroken = feller(eWorld, player, oBlock, cPos.south().west(), true, totalBroken) + 1;
                }
            }
            if (eWorld.getBlockState(cPos.above()).getBlock().is(oBlock)) {
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
        if (event.getEntityLiving() instanceof PlayerEntity && !event.getEntityLiving().level.isClientSide()) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            // Slime charmer effect
            if (event.getSource().getEntity() instanceof SlimeEntity) {
                if (isRingEquipped(player, ModItems.SLIME_CHARMER_RING.get())) {
                    event.setCanceled(true);
                }
            }

            // Yoba effect
            if (isRingEquipped(player, ModItems.YOBA_RING.get())) {
                if (new Random().nextInt(20) == 1) {
                    player.level.playSound(null, player.xo, player.yo, player.zo, ModSoundEvents.YOBA_SOUND.get(), SoundCategory.PLAYERS, 1, 1);
                    player.addEffect(new EffectInstance(Effects.ABSORPTION, 80, 0));
                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerKillEntity(final LivingDeathEvent event) {
        if (event.getSource() instanceof EntityDamageSource && !event.getEntityLiving().level.isClientSide()) {
            if (event.getSource().getEntity() instanceof PlayerEntity && !(event.getEntityLiving() instanceof AnimalEntity)) {
                PlayerEntity player = (PlayerEntity) event.getSource().getEntity();

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
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 50, 0));
                }

                // Napalm effect
                if (isRingEquipped(player, ModItems.NAPALM_RING.get())) {
                    double x = event.getEntityLiving().xo;
                    double y = event.getEntityLiving().yo;
                    double z = event.getEntityLiving().zo;
                    event.getEntityLiving().level.explode(player, x, y, z, 1, Explosion.Mode.NONE);
                }

                // Warrior effect
                if (isRingEquipped(player, ModItems.WARRIOR_RING.get())) {
                    if (new Random().nextInt(20) == 1) {
                        player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 60, 2));
                    }
                }
            }
        }
    }

    private static boolean isRingEquipped(PlayerEntity player, Item item) {
        for (int i = 0; i < CuriosApi.getCuriosHelper().getEquippedCurios(player).resolve().get().getSlots(); i++) {
            if (CuriosApi.getCuriosHelper().getEquippedCurios(player).resolve().get().getStackInSlot(i).getItem() == item)
                return true;
        }
        return false;
    }

    // Zombies can now spawn with wood club in hand
    @SubscribeEvent
    public static void giveClub(final EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof ZombieEntity)) {
            return;
        }
        if (!event.getEntity().level.isClientSide()) {
            ZombieEntity zombie = (ZombieEntity) event.getEntity();
            if (Math.random() > (1 - StardewArmoryConfig.club_rate.get())) {
                zombie.setItemInHand(Hand.MAIN_HAND, new ItemStack(ModItems.WOOD_CLUB.get()));
            }
        }
    }
}
