package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.setup.items.*;
import net.gendevo.stardewarmory.setup.tools.ModItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    // Materials
    public static final RegistryObject<Item> PRISMATIC_SHARD = Registration.ITEMS.register("prismatic_shard", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> REINFORCED_HANDLE = Registration.ITEMS.register("reinforced_handle", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> DRAGON_TOOTH = Registration.ITEMS.register("dragon_tooth", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> PREHISTORIC_SCAPULA = Registration.ITEMS.register("prehistoric_scapula", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> SPECIAL_ITEM = Registration.ITEMS.register("special_item", () ->
            new SpecialItem(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));

    //Rings
    public static final RegistryObject<Item> RUBY_RING = Registration.ITEMS.register("ruby_ring", () ->
            new RubyRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> LUCKY_RING = Registration.ITEMS.register("lucky_ring", () ->
            new LuckyRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> CRABSHELL_RING = Registration.ITEMS.register("crabshell_ring", () ->
            new CrabshellRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));

    // Swords
    public static final RegistryObject<SwordItem> GALAXY_SWORD = Registration.ITEMS.register("galaxy_sword", () ->
            new SwordItem(ModItemTier.GALAXY_SWORD, 8, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> DRAGONTOOTH_CUTLASS = Registration.ITEMS.register("dragontooth_cutlass", () ->
            new EnchantSword(ModItemTier.DRAGONTOOTH_CUTLASS, 9, -2.5f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> SILVER_SABER = Registration.ITEMS.register("silver_saber", () ->
            new EnchantSword(ModItemTier.SILVER_SABER, 78, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> RUSTY_SWORD = Registration.ITEMS.register("rusty_sword", () ->
            new SwordItem(ModItemTier.RUSTY_SWORD, 2, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> STEEL_SMALLSWORD = Registration.ITEMS.register("steel_smallsword", () ->
            new SwordItem(ModItemTier.STEEL_SMALLSWORD, 4, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> PIRATES_SWORD = Registration.ITEMS.register("pirates_sword", () ->
            new SwordItem(ModItemTier.PIRATES_SWORD, 3, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> CUTLASS = Registration.ITEMS.register("cutlass", () ->
            new SwordItem(ModItemTier.CUTLASS, 4, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> FOREST_SWORD = Registration.ITEMS.register("forest_sword", () ->
            new SwordItem(ModItemTier.FOREST_SWORD, 2, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> IRON_EDGE = Registration.ITEMS.register("iron_edge", () ->
            new SwordItem(ModItemTier.IRON_EDGE, 7, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> INSECT_HEAD = Registration.ITEMS.register("insect_head", () ->
            new CritSword(ModItemTier.INSECT_HEAD, 4, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> BONE_SWORD = Registration.ITEMS.register("bone_sword", () ->
            new SwordItem(ModItemTier.BONE_SWORD, 2, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> CLAYMORE = Registration.ITEMS.register("claymore", () ->
            new SwordItem(ModItemTier.CLAYMORE, 9, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> NEPTUNES_GLAIVE = Registration.ITEMS.register("neptunes_glaive", () ->
            new NeptuneSword(ModItemTier.NEPTUNES_GLAIVE, 5, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> TEMPLARS_BLADE = Registration.ITEMS.register("templars_blade", () ->
            new EnchantSword(ModItemTier.TEMPLARS_BLADE, 4, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> OBSIDIAN_EDGE = Registration.ITEMS.register("obsidian_edge", () ->
            new CritSword(ModItemTier.OBSIDIAN_EDGE, 4, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> OSSIFIED_BLADE = Registration.ITEMS.register("ossified_blade", () ->
            new EnchantSword(ModItemTier.OSSIFIED_BLADE, 4, -2.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> TEMPERED_BROADSWORD = Registration.ITEMS.register("tempered_broadsword", () ->
            new EnchantSword(ModItemTier.TEMPERED_BROADSWORD, 10, -3.1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> YETI_TOOTH = Registration.ITEMS.register("yeti_tooth", () ->
            new SwordItem(ModItemTier.YETI_TOOTH, 4, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> STEEL_FALCHION = Registration.ITEMS.register("steel_falchion", () ->
            new CritSword(ModItemTier.STEEL_FALCHION, 4, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> DARK_SWORD = Registration.ITEMS.register("dark_sword", () ->
            new SwordItem(ModItemTier.DARK_SWORD, 5, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> LAVA_KATANA = Registration.ITEMS.register("lava_katana", () ->
            new EnchantSword(ModItemTier.LAVA_KATANA, 5, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> DWARF_SWORD = Registration.ITEMS.register("dwarf_sword", () ->
            new SwordItem(ModItemTier.DWARF_SWORD, 6, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    public static final RegistryObject<SwordItem> INFINITY_BLADE = Registration.ITEMS.register("infinity_blade", () ->
            new CritSword(ModItemTier.INFINITY_BLADE, 12, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    //Daggers
    public static final RegistryObject<SwordItem> CARVING_KNIFE = Registration.ITEMS.register("carving_knife", () ->
            new SwordItem(ModItemTier.CARVING_KNIFE, 0, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> IRON_DIRK = Registration.ITEMS.register("iron_dirk", () ->
            new SwordItem(ModItemTier.IRON_DIRK, 1, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> WIND_SPIRE = Registration.ITEMS.register("wind_spire", () ->
            new CritSword(ModItemTier.WIND_SPIRE, 1, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> ELF_BLADE = Registration.ITEMS.register("elf_blade", () ->
            new SwordItem(ModItemTier.ELF_BLADE, 1, -1.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> BURGLARS_SHANK = Registration.ITEMS.register("burglars_shank", () ->
            new SwordItem(ModItemTier.BURGLARS_SHANK, 1, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> CRYSTAL_DAGGER = Registration.ITEMS.register("crystal_dagger", () ->
            new CritSword(ModItemTier.CRYSTAL_DAGGER, 1, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> SHADOW_DAGGER = Registration.ITEMS.register("shadow_dagger", () ->
            new SwordItem(ModItemTier.SHADOW_DAGGER, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> BROKEN_TRIDENT = Registration.ITEMS.register("broken_trident", () ->
            new SwordItem(ModItemTier.BROKEN_TRIDENT, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> WICKED_KRIS = Registration.ITEMS.register("wicked_kris", () ->
            new EnchantSword(ModItemTier.WICKED_KRIS, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> GALAXY_DAGGER = Registration.ITEMS.register("galaxy_dagger", () ->
            new SwordItem(ModItemTier.GALAXY_DAGGER, 4, -1.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DWARF_DAGGER = Registration.ITEMS.register("dwarf_dagger", () ->
            new SwordItem(ModItemTier.DWARF_DAGGER, 3, -1.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DRAGONTOOTH_SHIV = Registration.ITEMS.register("dragontooth_shiv", () ->
            new SwordItem(ModItemTier.DRAGONTOOTH_SHIV, 0, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> IRIDIUM_NEEDLE = Registration.ITEMS.register("iridium_needle", () ->
            new CritSword(ModItemTier.IRIDIUM_NEEDLE, 2, -1.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> INFINITY_DAGGER = Registration.ITEMS.register("infinity_dagger", () ->
            new SwordItem(ModItemTier.INFINITY_DAGGER, 7, -0.5f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    static void register(){}
}
