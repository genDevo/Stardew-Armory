package net.gendevo.stardewarmory.enchantments;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.util.ModSoundEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;

import java.util.Random;

public class CritEnchantment extends Enchantment {


    public CritEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType[] slots) {
        super(rarity, type, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        Random rand = new Random();
        int critChance = (int) (9 - Math.ceil(Math.sin((level*Math.PI)/3)+level));
        if (user.hasEffect(Effects.LUCK)) {
            critChance--;
        }
        int randomInt = rand.nextInt(critChance);
        if (randomInt == 1) {
            target.hurt(DamageSource.playerAttack((PlayerEntity) user), (8 + (level*4)));
            target.playSound(ModSoundEvents.LUCKY_HIT_SOUND.get(), 10, 1);
            StardewArmory.LOGGER.debug("The chance was 1/" + critChance);
        }
    }
}
