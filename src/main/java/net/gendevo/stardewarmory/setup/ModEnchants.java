package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.enchantments.CritEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;

public class ModEnchants {

    public static final RegistryObject<Enchantment> LUCKY_HIT = Registration.ENCHANTMENTS.register("lucky_hit", () -> new CritEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND}));

    static void register() {}
}
