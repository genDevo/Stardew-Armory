package net.gendevo.stardewarmory.item.weapons;

import net.gendevo.stardewarmory.enchantments.LuckyHitEnchantment;
import net.gendevo.stardewarmory.enchantments.ModEnchants;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.collection.DefaultedList;

public class EnchantSword extends SwordItem {
    public EnchantSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (getGroup() == group) {
            ItemStack stack = new ItemStack(this);
            switch (this.getEnchantability()) {
                case 9:
                    stack.addEnchantment(Enchantments.FIRE_ASPECT, 1);
                    break;
                case 10:
                    stack.addEnchantment(Enchantments.SMITE, 1);
                    break;
                case 11:
                    stack.addEnchantment(Enchantments.KNOCKBACK, 1);
                    break;
                case 13:
                    stack.addEnchantment(Enchantments.SHARPNESS, 1);
                    break;
                case 14:
                    stack.addEnchantment(ModEnchants.LUCKY_HIT, 1);
                    break;
                case 20:
                    stack.addEnchantment(ModEnchants.LUCKY_HIT, 3);
                    break;
            }
            stacks.add(stack);
        }
    }

}
