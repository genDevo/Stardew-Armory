package net.gendevo.stardewarmory.items.weapons;

import net.gendevo.stardewarmory.setup.ModEnchants;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantments;

public class EnchantSword extends SwordItem {

    public EnchantSword(Tier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        if (getItemCategory() == tab) {
            ItemStack stack = new ItemStack(this);
            switch (this.getItemEnchantability(stack)) {
                case 9 -> stack.enchant(Enchantments.FIRE_ASPECT, 1);
                case 10 -> stack.enchant(Enchantments.SMITE, 1);
                case 11 -> stack.enchant(Enchantments.KNOCKBACK, 1);
                case 13 -> stack.enchant(Enchantments.SHARPNESS, 1);
                case 14 -> stack.enchant(ModEnchants.LUCKY_HIT.get(), 1);
                case 20 -> stack.enchant(ModEnchants.LUCKY_HIT.get(), 3);
            }
            list.add(stack);
        }
        super.fillItemCategory(tab, list);
    }

    @Override
    public void onCraftedBy(ItemStack stack, net.minecraft.world.level.Level pLevel, Player pPlayer) {
        if (!stack.isEnchanted()) {
            switch (this.getItemEnchantability(stack)) {
                case 9 -> stack.enchant(Enchantments.FIRE_ASPECT, 1);
                case 10 -> stack.enchant(Enchantments.SMITE, 1);
                case 11 -> stack.enchant(Enchantments.KNOCKBACK, 1);
                case 13 -> stack.enchant(Enchantments.SHARPNESS, 1);
                case 14 -> stack.enchant(ModEnchants.LUCKY_HIT.get(), 1);
                case 20 -> stack.enchant(ModEnchants.LUCKY_HIT.get(), 3);
            }
        }
        super.onCraftedBy(stack, pLevel, pPlayer);
    }
}
