package net.gendevo.stardewarmory.setup.items;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.NonNullList;

public class EnchantSword extends SwordItem {

    public EnchantSword(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (getItemCategory() == tab) {
            ItemStack istack = new ItemStack(this);
            switch (this.getItemEnchantability(istack)) {
                case 9:
                    istack.enchant(Enchantments.FIRE_ASPECT, 1);
                    break;
                case 10:
                    istack.enchant(Enchantments.SMITE, 1);
                    break;
                case 11:
                    istack.enchant(Enchantments.KNOCKBACK, 1);
                    break;
                case 13:
                    istack.enchant(Enchantments.SHARPNESS, 1);
                    break;
            }
            list.add(istack);
        }
    }
}
