package net.gendevo.stardewarmory.items.tools;

import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {
    //Daggers
    CARVING_KNIFE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    IRON_DIRK(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    WIND_SPIRE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    ELF_BLADE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    BURGLARS_SHANK(3, 3000, 9.0F, 1.5F, 12, () -> {
        return null;
    }),
    CRYSTAL_DAGGER(3, 3000, 9.0F, 1.5F, 12, () -> {
        return null;
    }),
    SHADOW_DAGGER(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    BROKEN_TRIDENT(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    WICKED_KRIS(3, 3000, 9.0F, 1.0F, 9, () -> {
        return null;
    }),
    GALAXY_DAGGER(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DWARF_DAGGER(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DRAGONTOOTH_SHIV(3, 3000, 9.0F, 1.0F, 13, () -> {
        return null;
    }),
    IRIDIUM_NEEDLE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    INFINITY_DAGGER(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    //Clubs
    FEMUR(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    WOOD_CLUB(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    WOOD_MALLET(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    LEAD_ROD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    KUDGEL(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    SLAMMER(3, 3000, 9.0F, 1.0F, 11, () -> {
        return null;
    }),
    DWARF_HAMMER(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DRAGONTOOTH_CLUB(3, 3000, 9.0F, 1.0F, 13, () -> {
        return null;
    }),
    GALAXY_HAMMER(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    INFINITY_GAVEL(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    //Swords
    GALAXY_SWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(ModItems.PRISMATIC_SHARD.get());
    }),
    RUSTY_SWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    STEEL_SMALLSWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    PIRATES_SWORD(3, 3000, 9.0F, 1.5F, 12, () -> {
        return null;
    }),
    SILVER_SABER(3, 3000, 9.0F, 1.0F, 10, () -> {
        return null;
    }),
    CUTLASS(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    FOREST_SWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    IRON_EDGE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    INSECT_HEAD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Items.SPIDER_EYE);
    }),
    BONE_SWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.BONES);
    }),
    CLAYMORE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    NEPTUNES_GLAIVE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    TEMPLARS_BLADE(3, 3000, 9.0F, 1.0F, 10, () -> {
        return null;
    }),
    OBSIDIAN_EDGE(3, 3000, 9.0F, 1.5F, 12, () -> {
        return Ingredient.of(Items.OBSIDIAN);
    }),
    OSSIFIED_BLADE(3, 3000, 9.0F, 1.5F, 11, () -> {
        return Ingredient.of(ModItems.PREHISTORIC_SCAPULA.get());
    }),
    TEMPERED_BROADSWORD(3, 3000, 9.0F, 1.0F, 11, () -> {
        return null;
    }),
    YETI_TOOTH(3, 3000, 9.0F, 1.5F, 12, () -> {
        return null;
    }),
    STEEL_FALCHION(3, 3000, 9.0F, 1.5F, 12, () -> {
        return null;
    }),
    DARK_SWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    LAVA_KATANA(3, 3000, 9.0F, 1.5F, 9, () -> {
        return Ingredient.of(Items.MAGMA_BLOCK);
    }),
    DWARF_SWORD(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DRAGONTOOTH_CUTLASS(3, 3000, 9.0F, 1.0F, 13, () -> {
        return Ingredient.of(ModItems.DRAGON_TOOTH.get());
    }),
    INFINITY_BLADE(3, 3000, 9.0F, 1.0F, 12, () -> {
        return null;
    });


    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}