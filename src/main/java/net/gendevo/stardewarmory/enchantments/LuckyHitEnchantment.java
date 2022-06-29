package net.gendevo.stardewarmory.enchantments;

import net.gendevo.stardewarmory.config.ModConfigs;
import net.gendevo.stardewarmory.sound.ModSounds;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;

import java.util.Random;

import static java.lang.Math.abs;

public class LuckyHitEnchantment extends Enchantment {
    public LuckyHitEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (!user.world.isClient()) {
            level = Math.min(level, 5);
            Random rand = new Random();
            int critChance = abs(9 - level);
            if (user.hasStatusEffect(StatusEffects.LUCK)) {
                critChance--;
            }
            int randomInt = rand.nextInt(critChance);
            if (randomInt == 1 && user instanceof PlayerEntity) {
                target.damage(DamageSource.player((PlayerEntity) user), (user.getMainHandStack().getMaxDamage()*2));
                if (ModConfigs.LUCKY_HIT_SOUND) {
                    user.world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.LUCKY_HIT_SOUND, SoundCategory.PLAYERS, 0.8f, 1);
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}
