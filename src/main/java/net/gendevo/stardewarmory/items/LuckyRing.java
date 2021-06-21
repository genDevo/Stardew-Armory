package net.gendevo.stardewarmory.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class LuckyRing extends Item implements ICurioItem {

    public LuckyRing(Properties properties) {
        super(properties);
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity living, ItemStack stack) {
        if (living.tickCount % 40 == 0) {
            living.addEffect(new EffectInstance(Effects.LUCK, 80, 0, true, true));
        }
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}