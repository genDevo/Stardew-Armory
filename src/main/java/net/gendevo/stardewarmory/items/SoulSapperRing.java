package net.gendevo.stardewarmory.items;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class SoulSapperRing extends Item implements ICurioItem {

    public SoulSapperRing(Properties properties) {
        super(properties);
    }

//    @Override
//    public void curioTick(String identifier, int index, LivingEntity living, ItemStack stack) {
//        if (living.tickCount % 40 == 0) {
//            living.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 80, 0, true, true));
//        }
//    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }


    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
        atts.put(Attributes.MOVEMENT_SPEED,
                new AttributeModifier(uuid, StardewArmory.MOD_ID + ":speed_bonus", 0.1,
                        AttributeModifier.Operation.MULTIPLY_TOTAL));
        atts.put(Attributes.ARMOR,
                new AttributeModifier(uuid, StardewArmory.MOD_ID + ":armor_bonus", 2,
                        AttributeModifier.Operation.ADDITION));
        return atts;
    }



}
