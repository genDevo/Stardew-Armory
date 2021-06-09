package net.gendevo.stardewarmory.setup.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RubyRing extends Item implements ICurioItem {

    public RubyRing(Properties properties) {
        super(properties);
    }

    @Override
    public void curioTick(String identifier, int index, LivingEntity living, ItemStack stack) {
        if (living.tickCount % 40 == 0) {
            living.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 80, 0, true, true));
        }
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }



    //    @Override
//    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
//        Multimap<Attribute, AttributeModifier> atts = LinkedHashMultimap.create();
//        atts.put(Attributes.MOVEMENT_SPEED,
//                new AttributeModifier(uuid, TestoModo.MOD_ID + ":speed_bonus", 0.1,
//                        AttributeModifier.Operation.MULTIPLY_TOTAL));
//        atts.put(Attributes.ARMOR,
//                new AttributeModifier(uuid, TestoModo.MOD_ID + ":armor_bonus", 2,
//                        AttributeModifier.Operation.ADDITION));
//        return atts;
//    }


}
