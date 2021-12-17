package net.gendevo.stardewarmory.enchantments;

import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Random;

public class CritEnchantment extends Enchantment {


    public CritEnchantment(Enchantment.Rarity rarity, EnchantmentCategory category, EquipmentSlot[] slots) {
        super(rarity, category, slots);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if (!user.level.isClientSide()) {
            Random rand = new Random();
            int critChance = (int) (9 - Math.ceil(Math.sin((level * Math.PI) / 3) + level));
            if (user.hasEffect(MobEffects.LUCK)) {
                critChance--;
            }
            int randomInt = rand.nextInt(critChance);
            if (randomInt == 1) {
                target.hurt(DamageSource.playerAttack((Player) user), (8 + (level * 4)));
                if (StardewArmoryConfig.crit_sound.get()) {
                    user.level.playSound(null, user.xo, user.yo, user.zo, ModSoundEvents.LUCKY_HIT_SOUND.get(), SoundSource.PLAYERS, 0.8f, 1);
                }
            }
        }
    }
}
