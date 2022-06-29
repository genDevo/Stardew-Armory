package net.gendevo.stardewarmory.item;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModMaterials implements ToolMaterial {
    // Daggers
    CARVING_KNIFE(3, 200, 9.0F, 1.0F, 15, () -> Ingredient.ofItems(Items.IRON_NUGGET)),
    IRON_DIRK(3, 200, 9.0F, 1.0F, 15, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    WIND_SPIRE(3, 200, 9.0F, 1.0F, 14, () -> Ingredient.ofItems(Items.QUARTZ)),
    ELF_BLADE(3, 250, 9.0F, 1.0F, 15, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    BURGLARS_SHANK(3, 220, 9.0F, 1.5F, 18, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    CRYSTAL_DAGGER(3, 200, 9.0F, 1.5F, 13, () -> Ingredient.ofItems(Items.QUARTZ)),
    SHADOW_DAGGER(3, 300, 9.0F, 1.0F, 14, () -> Ingredient.ofItems(Items.OBSIDIAN)),
    BROKEN_TRIDENT(3, 110, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.PRISMARINE_SHARD)),
    WICKED_KRIS(3, 300, 9.0F, 1.0F, 9, () -> Ingredient.ofItems(Items.OBSIDIAN)),
    GALAXY_DAGGER(3, 2000, 9.0F, 1.0F, 10, () -> Ingredient.ofItems(ModItems.PRISMATIC_SHARD)),
    DWARF_DAGGER(3, 2000, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.MAGMA_BLOCK)),
    DRAGONTOOTH_SHIV(3, 2500, 9.0F, 1.0F, 13, () -> Ingredient.ofItems(ModItems.DRAGON_TOOTH)),
    IRIDIUM_NEEDLE(3, 2500, 9.0F, 1.0F, 14, () -> Ingredient.ofItems(ModItems.IRIDIUM_INGOT)),
    INFINITY_DAGGER(3, 4000, 9.0F, 1.0F, 20, () -> Ingredient.ofItems(ModItems.PRISMATIC_SHARD)),

    // Clubs
    FEMUR(3, 70, 9.0F, 1.0F, 18, () -> Ingredient.ofItems(Items.BONE)),
    WOOD_CLUB(3, 70, 9.0F, 1.0F, 18, () -> Ingredient.ofItems(Items.STICK)),
    WOOD_MALLET(3, 100, 9.0F, 1.0F, 18, () -> Ingredient.ofItems(Items.STICK)),
    LEAD_ROD(3, 300, 9.0F, 1.0F, 16, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    KUDGEL(3, 350, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.IRON_BLOCK)),
    SLAMMER(3, 325, 9.0F, 1.0F, 11, () -> Ingredient.ofItems(Items.IRON_BLOCK)),
    DWARF_HAMMER(3, 2000, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.MAGMA_BLOCK)),
    DRAGONTOOTH_CLUB(3, 2000, 9.0F, 1.0F, 13, () -> Ingredient.ofItems(ModItems.DRAGON_TOOTH)),
    GALAXY_HAMMER(3, 2500, 9.0F, 1.0F, 10, () -> Ingredient.ofItems(ModItems.PRISMATIC_SHARD)),
    INFINITY_GAVEL(3, 3000, 9.0F, 1.0F, 20, () -> Ingredient.ofItems(ModItems.GALAXY_SOUL)),

    // Swords
    GALAXY_SWORD(3, 2000, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(ModItems.PRISMATIC_SHARD)),
    RUSTY_SWORD(3, 34, 9.0F, 1.0F, 30, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    STEEL_SMALLSWORD(3, 160, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    PIRATES_SWORD(3, 150, 9.0F, 1.5F, 12, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    SILVER_SABER(3, 300, 9.0F, 1.0F, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    CUTLASS(3, 150, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    FOREST_SWORD(3, 55, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.STICK)),
    IRON_EDGE(3, 260, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    INSECT_HEAD(3, 180, 9.0F, 1.0F, 14, () -> Ingredient.ofItems(Items.SPIDER_EYE)),
    BONE_SWORD(3, 110, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.BONE)),
    CLAYMORE(3, 275, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.IRON_BLOCK)),
    NEPTUNES_GLAIVE(3, 400, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.PRISMARINE_CRYSTALS)),
    TEMPLARS_BLADE(3, 300, 9.0F, 1.0F, 10, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    OBSIDIAN_EDGE(3, 300, 9.0F, 1.5F, 14, () -> Ingredient.ofItems(Items.OBSIDIAN)),
    OSSIFIED_BLADE(3, 300, 9.0F, 1.5F, 11, () -> Ingredient.ofItems(ModItems.PREHISTORIC_SCAPULA)),
    TEMPERED_BROADSWORD(3, 300, 9.0F, 1.0F, 11, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    YETI_TOOTH(3, 210, 9.0F, 1.5F, 12, () -> Ingredient.ofItems(Items.LEATHER)),
    STEEL_FALCHION(3, 160, 9.0F, 1.5F, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DARK_SWORD(3, 170, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.OBSIDIAN)),
    LAVA_KATANA(3, 170, 9.0F, 1.5F, 9, () -> Ingredient.ofItems(Items.MAGMA_BLOCK)),
    DWARF_SWORD(3, 2000, 9.0F, 1.0F, 12, () -> Ingredient.ofItems(Items.MAGMA_BLOCK)),
    DRAGONTOOTH_CUTLASS(3, 1200, 9.0F, 1.0F, 13, () -> Ingredient.ofItems(ModItems.DRAGON_TOOTH)),
    INFINITY_BLADE(3, 3000, 9.0F, 1.0F, 20, () -> Ingredient.ofItems(ModItems.GALAXY_SOUL)),

    // Materials
    IRIDIUM(5, 3000, 13.0F, 5.0F, 24, () -> Ingredient.ofItems(ModItems.IRIDIUM_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    ModMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
