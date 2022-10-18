package net.gendevo.stardewarmory.items.misc;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RawIridium extends Item {
    public RawIridium(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (pEntity.tickCount % 40 == 0 && pIsSelected) {
            ((LivingEntity)pEntity).addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, true, false));
        }
    }
}
