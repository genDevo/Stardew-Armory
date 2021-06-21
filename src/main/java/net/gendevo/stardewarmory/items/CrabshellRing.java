package net.gendevo.stardewarmory.items;

import com.google.common.collect.HashMultimap;
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

public class CrabshellRing extends Item implements ICurioItem {

    public CrabshellRing(Properties properties) {
        super(properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        Multimap<Attribute, AttributeModifier> atts = HashMultimap.create();
        atts.put(Attributes.ARMOR,
                new AttributeModifier(uuid, StardewArmory.MOD_ID + ":armor_bonus", 3,
                        AttributeModifier.Operation.ADDITION));
        return atts;
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }
}
