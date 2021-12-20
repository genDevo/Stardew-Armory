package net.gendevo.stardewarmory.setup;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.items.ModItemTier;
import net.gendevo.stardewarmory.items.misc.RawIridium;
import net.gendevo.stardewarmory.items.rings.*;
import net.gendevo.stardewarmory.items.tools.*;
import net.gendevo.stardewarmory.items.weapons.*;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ModItems {
    // Materials
    public static final RegistryObject<Item> PRISMATIC_SHARD = Registration.ITEMS.register("prismatic_shard", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> IRIDIUM_INGOT = Registration.ITEMS.register("iridium_ingot", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> GALAXY_SOUL = Registration.ITEMS.register("galaxy_soul", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> REINFORCED_HANDLE = Registration.ITEMS.register("reinforced_handle", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> DRAGON_TOOTH = Registration.ITEMS.register("dragon_tooth", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> PREHISTORIC_SCAPULA = Registration.ITEMS.register("prehistoric_scapula", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> CINDER_SHARD = Registration.ITEMS.register("cinder_shard", () ->
            new Item(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<Item> RAW_IRIDIUM = Registration.ITEMS.register("raw_iridium", () ->
            new RawIridium(new Item.Properties().tab(StardewArmory.TAB_STARDEW)));

    //Rings
    public static final RegistryObject<Item> EMERALD_RING = Registration.ITEMS.register("emerald_ring", () ->
            new EmeraldRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> LUCKY_RING = Registration.ITEMS.register("lucky_ring", () ->
            new LuckyRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> CRABSHELL_RING = Registration.ITEMS.register("crabshell_ring", () ->
            new CrabshellRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> SOUL_GLUTTON_RING = Registration.ITEMS.register("soul_glutton_ring", () ->
            new SoulGluttonRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> SLIME_CHARMER_RING = Registration.ITEMS.register("slime_charmer_ring", () ->
            new SlimeCharmerRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> NAPALM_RING = Registration.ITEMS.register("napalm_ring", () ->
            new NapalmRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> SAVAGE_RING = Registration.ITEMS.register("savage_ring", () ->
            new SavageRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> VAMPIRE_RING = Registration.ITEMS.register("vampire_ring", () ->
            new VampireRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> YOBA_RING = Registration.ITEMS.register("yoba_ring", () ->
            new YobaRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));
    public static final RegistryObject<Item> WARRIOR_RING = Registration.ITEMS.register("warrior_ring", () ->
            new WarriorRing(new Item.Properties().tab(StardewArmory.TAB_STARDEW).stacksTo(1)));

    // Swords
    public static final RegistryObject<SwordItem> GALAXY_SWORD = Registration.ITEMS.register("galaxy_sword", () ->
            new SwordItem(ModItemTier.GALAXY_SWORD, 7, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
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
            new SwordItem(ModItemTier.IRON_EDGE, 5, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> INSECT_HEAD = Registration.ITEMS.register("insect_head", () ->
            new EnchantSword(ModItemTier.INSECT_HEAD, 4, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> BONE_SWORD = Registration.ITEMS.register("bone_sword", () ->
            new SwordItem(ModItemTier.BONE_SWORD, 2, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> CLAYMORE = Registration.ITEMS.register("claymore", () ->
            new SwordItem(ModItemTier.CLAYMORE, 9, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> NEPTUNES_GLAIVE = Registration.ITEMS.register("neptunes_glaive", () ->
            new NeptuneSword(ModItemTier.NEPTUNES_GLAIVE, 5, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> TEMPLARS_BLADE = Registration.ITEMS.register("templars_blade", () ->
            new EnchantSword(ModItemTier.TEMPLARS_BLADE, 4, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> OBSIDIAN_EDGE = Registration.ITEMS.register("obsidian_edge", () ->
            new EnchantSword(ModItemTier.OBSIDIAN_EDGE, 4, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> OSSIFIED_BLADE = Registration.ITEMS.register("ossified_blade", () ->
            new EnchantSword(ModItemTier.OSSIFIED_BLADE, 4, -2.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> TEMPERED_BROADSWORD = Registration.ITEMS.register("tempered_broadsword", () ->
            new EnchantSword(ModItemTier.TEMPERED_BROADSWORD, 10, -3.1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> YETI_TOOTH = Registration.ITEMS.register("yeti_tooth", () ->
            new SwordItem(ModItemTier.YETI_TOOTH, 4, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> STEEL_FALCHION = Registration.ITEMS.register("steel_falchion", () ->
            new EnchantSword(ModItemTier.STEEL_FALCHION, 4, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DARK_SWORD = Registration.ITEMS.register("dark_sword", () ->
            new SwordItem(ModItemTier.DARK_SWORD, 5, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> LAVA_KATANA = Registration.ITEMS.register("lava_katana", () ->
            new EnchantSword(ModItemTier.LAVA_KATANA, 5, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DWARF_SWORD = Registration.ITEMS.register("dwarf_sword", () ->
            new DwarfSword(ModItemTier.DWARF_SWORD, 6, -2.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> INFINITY_BLADE = Registration.ITEMS.register("infinity_blade", () ->
            new EnchantSword(ModItemTier.INFINITY_BLADE, 10, -1.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    //Daggers
    public static final RegistryObject<SwordItem> CARVING_KNIFE = Registration.ITEMS.register("carving_knife", () ->
            new SwordItem(ModItemTier.CARVING_KNIFE, 0, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> IRON_DIRK = Registration.ITEMS.register("iron_dirk", () ->
            new SwordItem(ModItemTier.IRON_DIRK, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> WIND_SPIRE = Registration.ITEMS.register("wind_spire", () ->
            new EnchantSword(ModItemTier.WIND_SPIRE, 1, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> ELF_BLADE = Registration.ITEMS.register("elf_blade", () ->
            new SwordItem(ModItemTier.ELF_BLADE, 1, -1.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> BURGLARS_SHANK = Registration.ITEMS.register("burglars_shank", () ->
            new SwordItem(ModItemTier.BURGLARS_SHANK, 1, -2.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> CRYSTAL_DAGGER = Registration.ITEMS.register("crystal_dagger", () ->
            new EnchantSword(ModItemTier.CRYSTAL_DAGGER, 1, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> SHADOW_DAGGER = Registration.ITEMS.register("shadow_dagger", () ->
            new SwordItem(ModItemTier.SHADOW_DAGGER, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> BROKEN_TRIDENT = Registration.ITEMS.register("broken_trident", () ->
            new SwordItem(ModItemTier.BROKEN_TRIDENT, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> WICKED_KRIS = Registration.ITEMS.register("wicked_kris", () ->
            new EnchantSword(ModItemTier.WICKED_KRIS, 2, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> GALAXY_DAGGER = Registration.ITEMS.register("galaxy_dagger", () ->
            new SwordItem(ModItemTier.GALAXY_DAGGER, 4, -1.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DWARF_DAGGER = Registration.ITEMS.register("dwarf_dagger", () ->
            new DwarfSword(ModItemTier.DWARF_DAGGER, 3, -1.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DRAGONTOOTH_SHIV = Registration.ITEMS.register("dragontooth_shiv", () ->
            new EnchantSword(ModItemTier.DRAGONTOOTH_SHIV, 0, -1.6f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> IRIDIUM_NEEDLE = Registration.ITEMS.register("iridium_needle", () ->
            new EnchantSword(ModItemTier.IRIDIUM_NEEDLE, 2, -1.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> INFINITY_DAGGER = Registration.ITEMS.register("infinity_dagger", () ->
            new EnchantSword(ModItemTier.INFINITY_DAGGER, 7, -0.5f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    //Clubs
    public static final RegistryObject<SwordItem> FEMUR = Registration.ITEMS.register("femur", () ->
            new SwordItem(ModItemTier.FEMUR, 3, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> WOOD_CLUB = Registration.ITEMS.register("wood_club", () ->
            new SwordItem(ModItemTier.WOOD_CLUB, 3, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> WOOD_MALLET = Registration.ITEMS.register("wood_mallet", () ->
            new SwordItem(ModItemTier.WOOD_MALLET, 4, -3.1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> LEAD_ROD = Registration.ITEMS.register("lead_rod", () ->
            new SwordItem(ModItemTier.LEAD_ROD, 6, -3.2f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> KUDGEL = Registration.ITEMS.register("kudgel", () ->
            new SwordItem(ModItemTier.KUDGEL, 5, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> SLAMMER = Registration.ITEMS.register("slammer", () ->
            new EnchantSword(ModItemTier.SLAMMER, 5, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DWARF_HAMMER = Registration.ITEMS.register("dwarf_hammer", () ->
            new DwarfSword(ModItemTier.DWARF_HAMMER, 8, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> DRAGONTOOTH_CLUB = Registration.ITEMS.register("dragontooth_club", () ->
            new EnchantSword(ModItemTier.DRAGONTOOTH_CLUB, 8, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> GALAXY_HAMMER = Registration.ITEMS.register("galaxy_hammer", () ->
            new SwordItem(ModItemTier.GALAXY_HAMMER, 10, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<SwordItem> INFINITY_GAVEL = Registration.ITEMS.register("infinity_gavel", () ->
            new EnchantSword(ModItemTier.INFINITY_GAVEL, 13, -2.4f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    // "Unobtainable" Weapons
    public static final RegistryObject<SwordItem> ALEX_BAT = Registration.ITEMS.register("alex_bat", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "alex"));
    public static final RegistryObject<SwordItem> SAM_GUITAR = Registration.ITEMS.register("sam_guitar", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "sam"));
    public static final RegistryObject<SwordItem> HARVEY_MALLET = Registration.ITEMS.register("harvey_mallet", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "harvey"));
    public static final RegistryObject<SwordItem> MARU_WRENCH = Registration.ITEMS.register("maru_wrench", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "maru"));
    public static final RegistryObject<SwordItem> PENNY_FRYER = Registration.ITEMS.register("penny_fryer", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "penny"));
    public static final RegistryObject<SwordItem> SEB_MACE = Registration.ITEMS.register("seb_mace", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "seb"));
    public static final RegistryObject<SwordItem> HALEY_IRON = Registration.ITEMS.register("haley_iron", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "haley"));
    public static final RegistryObject<SwordItem> ABBY_PLANCHETTE = Registration.ITEMS.register("abby_planchette", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "abby"));
    public static final RegistryObject<SwordItem> ELLIOT_PENCIL = Registration.ITEMS.register("elliot_pencil", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "elliot"));
    public static final RegistryObject<SwordItem> LEAH_WHITTLER = Registration.ITEMS.register("leah_whittler", () ->
            new UnobtainableSword(Tiers.WOOD, 1, -1f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW), "leah"));

    // Tools
    public static final RegistryObject<PickaxeItem> IRIDIUM_PICKAXE = Registration.ITEMS.register("iridium_pickaxe", () ->
            new IridiumPick(ModItemTier.IRIDIUM, 1, -2.8f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<AxeItem> IRIDIUM_AXE = Registration.ITEMS.register("iridium_axe", () ->
            new IridiumAxe(ModItemTier.IRIDIUM, 5, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<HoeItem> IRIDIUM_HOE = Registration.ITEMS.register("iridium_hoe", () ->
            new IridiumHoe(ModItemTier.IRIDIUM, -5, -0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));
    public static final RegistryObject<ShovelItem> IRIDIUM_SHOVEL = Registration.ITEMS.register("iridium_shovel", () ->
            new IridiumShovel(ModItemTier.IRIDIUM, 1.5f, -3.0f, (new Item.Properties()).tab(StardewArmory.TAB_STARDEW)));

    static void register(){}
}
