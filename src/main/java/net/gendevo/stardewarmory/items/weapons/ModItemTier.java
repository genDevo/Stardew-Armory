package net.gendevo.stardewarmory.items.weapons;

import net.gendevo.stardewarmory.setup.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum ModItemTier implements Tier {
    //Daggers
    CARVING_KNIFE(3, 200, 9.0F, 1.0F, 15, () -> {
        return Ingredient.of(Tags.Items.NUGGETS_IRON);
    }),
    IRON_DIRK(3, 200, 9.0F, 1.0F, 15, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    WIND_SPIRE(3, 200, 9.0F, 1.0F, 14, () -> {
        return Ingredient.of(Tags.Items.GEMS_QUARTZ);
    }),
    ELF_BLADE(3, 250, 9.0F, 1.0F, 15, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    BURGLARS_SHANK(3, 220, 9.0F, 1.5F, 18, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    CRYSTAL_DAGGER(3, 200, 9.0F, 1.5F, 13, () -> {
        return Ingredient.of(Tags.Items.GEMS_QUARTZ);
    }),
    SHADOW_DAGGER(3, 300, 9.0F, 1.0F, 14, () -> {
        return Ingredient.of(Tags.Items.OBSIDIAN);
    }),
    BROKEN_TRIDENT(3, 110, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.DUSTS_PRISMARINE);
    }),
    WICKED_KRIS(3, 300, 9.0F, 1.0F, 9, () -> {
        return Ingredient.of(Items.OBSIDIAN);
    }),
    GALAXY_DAGGER(3, 2000, 9.0F, 1.0F, 10, () -> {
        return Ingredient.of(ModItems.PRISMATIC_SHARD.get());
    }),
    DWARF_DAGGER(3, 2000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DRAGONTOOTH_SHIV(3, 2500, 9.0F, 1.0F, 11, () -> {
        return Ingredient.of(ModItems.DRAGON_TOOTH.get());
    }),
    IRIDIUM_NEEDLE(3, 2500, 9.0F, 1.0F, 14, () -> {
        return Ingredient.of(ModItems.IRIDIUM_INGOT.get());
    }),
    INFINITY_DAGGER(3, 4000, 9.0F, 1.0F, 20, () -> {
        return Ingredient.of(ModItems.PRISMATIC_SHARD.get());
    }),
    //Clubs
    FEMUR(3, 70, 9.0F, 1.0F, 18, () -> {
        return Ingredient.of(Tags.Items.BONES);
    }),
    WOOD_CLUB(3, 70, 9.0F, 1.0F, 18, () -> {
        return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    WOOD_MALLET(3, 100, 9.0F, 1.0F, 18, () -> {
        return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    LEAD_ROD(3, 300, 9.0F, 1.0F, 16, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    KUDGEL(3, 350, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON);
    }),
    SLAMMER(3, 325, 9.0F, 1.0F, 11, () -> {
        return Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON);
    }),
    DWARF_HAMMER(3, 2000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DRAGONTOOTH_CLUB(3, 2000, 9.0F, 1.0F, 13, () -> {
        return Ingredient.of(ModItems.DRAGON_TOOTH.get());
    }),
    GALAXY_HAMMER(3, 2500, 9.0F, 1.0F, 10, () -> {
        return Ingredient.of(ModItems.PRISMATIC_SHARD.get());
    }),
    INFINITY_GAVEL(3, 3000, 9.0F, 1.0F, 20, () -> {
        return Ingredient.of(ModItems.GALAXY_SOUL.get());
    }),
    //Swords
    GALAXY_SWORD(3, 2000, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(ModItems.PRISMATIC_SHARD.get());
    }),
    RUSTY_SWORD(3, 34, 9.0F, 1.0F, 30, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    STEEL_SMALLSWORD(3, 160, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    PIRATES_SWORD(3, 150, 9.0F, 1.5F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    SILVER_SABER(3, 8000, 9.0F, 1.0F, 30, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    CUTLASS(3, 150, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    FOREST_SWORD(3, 55, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.RODS_WOODEN);
    }),
    IRON_EDGE(3, 260, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    INSECT_HEAD(3, 180, 9.0F, 1.0F, 14, () -> {
        return Ingredient.of(Items.SPIDER_EYE);
    }),
    BONE_SWORD(3, 110, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.BONES);
    }),
    CLAYMORE(3, 275, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    NEPTUNES_GLAIVE(3, 400, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Items.PRISMARINE_CRYSTALS);
    }),
    TEMPLARS_BLADE(3, 300, 9.0F, 1.0F, 10, () -> {
        return Ingredient.of(Tags.Items.INGOTS_GOLD);
    }),
    OBSIDIAN_EDGE(3, 300, 9.0F, 1.5F, 14, () -> {
        return Ingredient.of(Items.OBSIDIAN);
    }),
    OSSIFIED_BLADE(3, 300, 9.0F, 1.5F, 11, () -> {
        return Ingredient.of(ModItems.PREHISTORIC_SCAPULA.get());
    }),
    TEMPERED_BROADSWORD(3, 300, 9.0F, 1.0F, 11, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    YETI_TOOTH(3, 210, 9.0F, 1.5F, 12, () -> {
        return Ingredient.of(Tags.Items.LEATHER);
    }),
    STEEL_FALCHION(3, 160, 9.0F, 1.5F, 14, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    DARK_SWORD(3, 170, 9.0F, 1.0F, 12, () -> {
        return Ingredient.of(Tags.Items.INGOTS_IRON);
    }),
    LAVA_KATANA(3, 170, 9.0F, 1.5F, 9, () -> {
        return Ingredient.of(Items.MAGMA_BLOCK);
    }),
    DWARF_SWORD(3, 2000, 9.0F, 1.0F, 12, () -> {
        return null;
    }),
    DRAGONTOOTH_CUTLASS(3, 1200, 9.0F, 1.0F, 13, () -> {
        return Ingredient.of(ModItems.DRAGON_TOOTH.get());
    }),
    INFINITY_BLADE(3, 3000, 9.0F, 1.0F, 20, () -> {
        return Ingredient.of(ModItems.GALAXY_SOUL.get());
    }),
    //Tools
    IRIDIUM_PICKAXE(5, 3000, 15.0F, 3.0F, 19, () -> {
        return Ingredient.of(ModItems.IRIDIUM_INGOT.get());
    }),
    IRIDIUM_AXE(5, 3000, 15.0F, 3.0F, 19, () -> {
        return Ingredient.of(ModItems.IRIDIUM_INGOT.get());
    }),
    IRIDIUM_HOE(5, 3000, 15.0F, 1.0F, 19, () -> {
        return Ingredient.of(ModItems.IRIDIUM_INGOT.get());
    }),
    IRIDIUM_SHOVEL(5, 3000, 15.0F, 3.0F, 19, () -> {
        return Ingredient.of(ModItems.IRIDIUM_INGOT.get());
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