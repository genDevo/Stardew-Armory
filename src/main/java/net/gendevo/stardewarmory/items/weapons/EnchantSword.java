package net.gendevo.stardewarmory.items.weapons;

import net.gendevo.stardewarmory.setup.ModEnchants;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class EnchantSword extends SwordItem {

    public EnchantSword(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (getItemCategory() == tab) {
            ItemStack stack = new ItemStack(this);
            switch (this.getItemEnchantability(stack)) {
                case 9:
                    stack.enchant(Enchantments.FIRE_ASPECT, 1);
                    break;
                case 10:
                    stack.enchant(Enchantments.SMITE, 1);
                    break;
                case 11:
                    stack.enchant(Enchantments.KNOCKBACK, 1);
                    break;
                case 13:
                    stack.enchant(Enchantments.SHARPNESS, 1);
                    break;
                case 14:
                    stack.enchant(ModEnchants.LUCKY_HIT.get(), 1);
                    break;
                case 20:
                    stack.enchant(ModEnchants.LUCKY_HIT.get(), 3);
                    break;
            }
            list.add(stack);
        }
    }

    @Override
    public void onCraftedBy(ItemStack stack, World p_77622_2_, PlayerEntity p_77622_3_) {
        if (!stack.isEnchanted()) {
            switch (this.getItemEnchantability(stack)) {
                case 9:
                    stack.enchant(Enchantments.FIRE_ASPECT, 1);
                    break;
                case 10:
                    stack.enchant(Enchantments.SMITE, 1);
                    break;
                case 11:
                    stack.enchant(Enchantments.KNOCKBACK, 1);
                    break;
                case 13:
                    stack.enchant(Enchantments.SHARPNESS, 1);
                    break;
                case 14:
                    stack.enchant(ModEnchants.LUCKY_HIT.get(), 1);
                    break;
                case 20:
                    stack.enchant(ModEnchants.LUCKY_HIT.get(), 3);
                    break;
            }
        }
    }
}
