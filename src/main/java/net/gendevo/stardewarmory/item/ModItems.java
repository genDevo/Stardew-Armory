package net.gendevo.stardewarmory.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.item.tools.IridiumAxe;
import net.gendevo.stardewarmory.item.tools.IridiumHoe;
import net.gendevo.stardewarmory.item.tools.IridiumPickaxe;
import net.gendevo.stardewarmory.item.tools.IridiumShovel;
import net.gendevo.stardewarmory.item.weapons.DwarfSword;
import net.gendevo.stardewarmory.item.weapons.EnchantSword;
import net.gendevo.stardewarmory.item.weapons.NeptuneSword;
import net.gendevo.stardewarmory.item.weapons.UnobtainableSword;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item PRISMATIC_SHARD = registerItem("prismatic_shard",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item CINDER_SHARD = registerItem("cinder_shard",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item REINFORCED_HANDLE = registerItem("reinforced_handle",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRIDIUM_INGOT = registerItem("iridium_ingot",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item GALAXY_SOUL = registerItem("galaxy_soul",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DRAGON_TOOTH = registerItem("dragon_tooth",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item PREHISTORIC_SCAPULA = registerItem("prehistoric_scapula",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item RAW_IRIDIUM = registerItem("raw_iridium",
            new Item(new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));

    // Tools
    public static final Item IRIDIUM_PICKAXE = registerItem("iridium_pickaxe",
            new IridiumPickaxe(ModMaterials.IRIDIUM, 1, -2.8F, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRIDIUM_SHOVEL = registerItem("iridium_shovel",
            new IridiumShovel(ModMaterials.IRIDIUM, 1.5F, -3.0F, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRIDIUM_HOE = registerItem("iridium_hoe",
            new IridiumHoe(ModMaterials.IRIDIUM, -5, 0F, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRIDIUM_AXE = registerItem("iridium_axe",
            new IridiumAxe(ModMaterials.IRIDIUM, 5, -3.0F, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));

    // Swords
    public static final Item GALAXY_SWORD = registerItem("galaxy_sword",
            new SwordItem(ModMaterials.GALAXY_SWORD, 7, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DRAGONTOOTH_CUTLASS = registerItem("dragontooth_cutlass",
            new EnchantSword(ModMaterials.DRAGONTOOTH_CUTLASS, 9, -2.5f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item SILVER_SABER = registerItem("silver_saber",
            new EnchantSword(ModMaterials.SILVER_SABER, 7, -2.4f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item RUSTY_SWORD = registerItem("rusty_sword",
            new SwordItem(ModMaterials.RUSTY_SWORD, 2, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item STEEL_SMALLSWORD = registerItem("steel_smallsword",
            new SwordItem(ModMaterials.STEEL_SMALLSWORD, 4, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item PIRATES_SWORD = registerItem("pirates_sword",
            new SwordItem(ModMaterials.PIRATES_SWORD, 3, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item CUTLASS = registerItem("cutlass",
            new SwordItem(ModMaterials.CUTLASS, 4, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item FOREST_SWORD = registerItem("forest_sword",
            new SwordItem(ModMaterials.FOREST_SWORD, 2, -2.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRON_EDGE = registerItem("iron_edge",
            new SwordItem(ModMaterials.IRON_EDGE, 5, -2.8f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item INSECT_HEAD = registerItem("insect_head",
            new EnchantSword(ModMaterials.INSECT_HEAD, 4, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item BONE_SWORD = registerItem("bone_sword",
            new SwordItem(ModMaterials.BONE_SWORD, 2, -2.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item CLAYMORE = registerItem("claymore",
            new SwordItem(ModMaterials.CLAYMORE, 9, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item NEPTUNES_GLAIVE = registerItem("neptunes_glaive",
            new NeptuneSword(ModMaterials.NEPTUNES_GLAIVE, 5, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item TEMPLARS_BLADE = registerItem("templars_blade",
            new EnchantSword(ModMaterials.TEMPLARS_BLADE, 4, -2.4f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item OBSIDIAN_EDGE = registerItem("obsidian_edge",
            new EnchantSword(ModMaterials.OBSIDIAN_EDGE, 4, -2.8f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item OSSIFIED_BLADE = registerItem("ossified_blade",
            new EnchantSword(ModMaterials.OSSIFIED_BLADE, 4, -2.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item TEMPERED_BROADSWORD = registerItem("tempered_broadsword",
            new EnchantSword(ModMaterials.TEMPERED_BROADSWORD, 10, -3.1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item YETI_TOOTH = registerItem("yeti_tooth",
            new SwordItem(ModMaterials.YETI_TOOTH, 4, -2.4f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item STEEL_FALCHION = registerItem("steel_falchion",
            new EnchantSword(ModMaterials.STEEL_FALCHION, 4, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DARK_SWORD = registerItem("dark_sword",
            new SwordItem(ModMaterials.DARK_SWORD, 5, -2.8f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item LAVA_KATANA = registerItem("lava_katana",
            new EnchantSword(ModMaterials.LAVA_KATANA, 5, -2.8f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DWARF_SWORD = registerItem("dwarf_sword",
            new DwarfSword(ModMaterials.DWARF_SWORD, 6, -2.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item INFINITY_BLADE = registerItem("infinity_blade",
            new EnchantSword(ModMaterials.INFINITY_BLADE, 10, -1.8f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));

    //Daggers
    public static final Item CARVING_KNIFE = registerItem("carving_knife",
            new SwordItem(ModMaterials.CARVING_KNIFE, 0, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRON_DIRK = registerItem("iron_dirk",
            new SwordItem(ModMaterials.IRON_DIRK, 2, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item WIND_SPIRE = registerItem("wind_spire",
            new EnchantSword(ModMaterials.WIND_SPIRE, 1, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item ELF_BLADE = registerItem("elf_blade",
            new SwordItem(ModMaterials.ELF_BLADE, 1, -1.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item BURGLARS_SHANK = registerItem("burglars_shank",
            new SwordItem(ModMaterials.BURGLARS_SHANK, 1, -2.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item CRYSTAL_DAGGER = registerItem("crystal_dagger",
            new EnchantSword(ModMaterials.CRYSTAL_DAGGER, 1, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item SHADOW_DAGGER = registerItem("shadow_dagger",
            new SwordItem(ModMaterials.SHADOW_DAGGER, 2, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item BROKEN_TRIDENT = registerItem("broken_trident",
            new SwordItem(ModMaterials.BROKEN_TRIDENT, 2, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item WICKED_KRIS = registerItem("wicked_kris",
            new EnchantSword(ModMaterials.WICKED_KRIS, 2, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item GALAXY_DAGGER = registerItem("galaxy_dagger",
            new SwordItem(ModMaterials.GALAXY_DAGGER, 4, -1.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DWARF_DAGGER = registerItem("dwarf_dagger",
            new DwarfSword(ModMaterials.DWARF_DAGGER, 3, -1.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DRAGONTOOTH_SHIV = registerItem("dragontooth_shiv",
            new EnchantSword(ModMaterials.DRAGONTOOTH_SHIV, 1, -1.6f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item IRIDIUM_NEEDLE = registerItem("iridium_needle",
            new EnchantSword(ModMaterials.IRIDIUM_NEEDLE, 2, -1.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item INFINITY_DAGGER = registerItem("infinity_dagger",
            new EnchantSword(ModMaterials.INFINITY_DAGGER, 7, -0.5f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));

    //Clubs
    public static final Item FEMUR = registerItem("femur",
            new SwordItem(ModMaterials.FEMUR, 3, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item WOOD_CLUB = registerItem("wood_club",
            new SwordItem(ModMaterials.WOOD_CLUB, 3, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item WOOD_MALLET = registerItem("wood_mallet",
            new SwordItem(ModMaterials.WOOD_MALLET, 4, -3.1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item LEAD_ROD = registerItem("lead_rod",
            new SwordItem(ModMaterials.LEAD_ROD, 6, -3.2f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item KUDGEL = registerItem("kudgel",
            new SwordItem(ModMaterials.KUDGEL, 5, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item SLAMMER = registerItem("slammer",
            new EnchantSword(ModMaterials.SLAMMER, 5, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DWARF_HAMMER = registerItem("dwarf_hammer",
            new DwarfSword(ModMaterials.DWARF_HAMMER, 8, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item DRAGONTOOTH_CLUB = registerItem("dragontooth_club",
            new EnchantSword(ModMaterials.DRAGONTOOTH_CLUB, 8, -3.0f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item GALAXY_HAMMER = registerItem("galaxy_hammer",
            new SwordItem(ModMaterials.GALAXY_HAMMER, 10, -2.4f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));
    public static final Item INFINITY_GAVEL = registerItem("infinity_gavel",
            new EnchantSword(ModMaterials.INFINITY_GAVEL, 13, -2.4f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP)));

    // "Unobtainable" Weapons
    public static final Item ALEX_BAT = registerItem("alex_bat",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "alex"));
    public static final Item SAM_GUITAR = registerItem("sam_guitar",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "sam"));
    public static final Item HARVEY_MALLET = registerItem("harvey_mallet",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "harvey"));
    public static final Item MARU_WRENCH = registerItem("maru_wrench",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "maru"));
    public static final Item PENNY_FRYER = registerItem("penny_fryer",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "penny"));
    public static final Item SEB_MACE = registerItem("seb_mace",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "seb"));
    public static final Item HALEY_IRON = registerItem("haley_iron",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "haley"));
    public static final Item ABBY_PLANCHETTE = registerItem("abby_planchette",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "abby"));
    public static final Item ELLIOT_PENCIL = registerItem("elliot_pencil",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "elliot"));
    public static final Item LEAH_WHITTLER = registerItem("leah_whittler",
            new UnobtainableSword(ToolMaterials.WOOD, 1, -1f, new FabricItemSettings().group(StardewArmory.ITEM_GROUP), "leah"));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(StardewArmory.MODID, name), item);
    }

    public static void registerModItems() {
        StardewArmory.LOGGER.debug("Registering mod item for " + StardewArmory.MODID);
    }
}
