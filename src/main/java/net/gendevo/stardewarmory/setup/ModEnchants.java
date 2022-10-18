package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.enchantments.CritEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchants {

    public static final RegistryObject<Enchantment> LUCKY_HIT = Registration.ENCHANTMENTS.register("lucky_hit", () ->
            new CritEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[] {EquipmentSlot.MAINHAND}));

    static void register() {}
}
