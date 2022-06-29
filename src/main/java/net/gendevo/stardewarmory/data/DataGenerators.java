package net.gendevo.stardewarmory.data;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class DataGenerators {
    public static final Set<String> genItems = new HashSet<>();
    public static final Set<String> hhItems = new HashSet<>();
    public static final Set<String> blockItems = new HashSet<>();

    public static String createItemModelJson(String id, String type) {
        if ("generated".equals(type) || "handheld".equals(type)) {
            //The two types of item. "handheld" is used mostly for tools and the like, while "generated" is used for everything else.
            return "{\n" +
                    "  \"parent\": \"item/" + type + "\",\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"stardewarmory:" + id + "\"\n" +
                    "  }\n" +
                    "}";
        } else {
            //If the type is invalid, return an empty json string.
            return "";
        }
    }

    private static void initSets() {
        // Materials
        genItems.add("prismatic_shard");
        genItems.add("cinder_shard");
        genItems.add("reinforced_handle");
        genItems.add("iridium_ingot");
        genItems.add("galaxy_soul");
        genItems.add("dragon_tooth");
        genItems.add("prehistoric_scapula");
        genItems.add("raw_iridium");

        // Swords / Tools
        hhItems.add("galaxy_sword");
        hhItems.add("yeti_tooth");
        hhItems.add("dragontooth_cutlass");
        hhItems.add("silver_saber");
        hhItems.add("rusty_sword");
        hhItems.add("steel_smallsword");
        hhItems.add("pirates_sword");
        hhItems.add("cutlass");
        hhItems.add("forest_sword");
        hhItems.add("iron_edge");
        hhItems.add("insect_head");
        hhItems.add("bone_sword");
        hhItems.add("claymore");
        hhItems.add("neptunes_glaive");
        hhItems.add("templars_blade");
        hhItems.add("obsidian_edge");
        hhItems.add("ossified_blade");
        hhItems.add("tempered_broadsword");
        hhItems.add("steel_falchion");
        hhItems.add("dark_sword");
        hhItems.add("lava_katana");
        hhItems.add("dwarf_sword");
        hhItems.add("infinity_blade");
        hhItems.add("carving_knife");
        hhItems.add("iron_dirk");
        hhItems.add("wind_spire");
        hhItems.add("elf_blade");
        hhItems.add("burglars_shank");
        hhItems.add("crystal_dagger");
        hhItems.add("shadow_dagger");
        hhItems.add("broken_trident");
        hhItems.add("wicked_kris");
        hhItems.add("galaxy_dagger");
        hhItems.add("dwarf_dagger");
        hhItems.add("dragontooth_shiv");
        hhItems.add("iridium_needle");
        hhItems.add("infinity_dagger");
        hhItems.add("femur");
        hhItems.add("wood_club");
        hhItems.add("wood_mallet");
        hhItems.add("lead_rod");
        hhItems.add("kudgel");
        hhItems.add("slammer");
        hhItems.add("dwarf_hammer");
        hhItems.add("dragontooth_club");
        hhItems.add("galaxy_hammer");
        hhItems.add("infinity_gavel");
        hhItems.add("alex_bat");
        hhItems.add("sam_guitar");
        hhItems.add("harvey_mallet");
        hhItems.add("maru_wrench");
        hhItems.add("penny_fryer");
        hhItems.add("seb_mace");
        hhItems.add("haley_iron");
        hhItems.add("abby_planchette");
        hhItems.add("elliot_pencil");
        hhItems.add("leah_whittler");

        hhItems.add("iridium_pickaxe");
        hhItems.add("iridium_shovel");
        hhItems.add("iridium_hoe");
        hhItems.add("iridium_axe");

        // Blocks
        blockItems.add("iridium_ore");
    }

    public static String getItemModelType(String id) {
        initSets();
        String noItem = id.split("/")[1];
        AtomicReference<String> result = new AtomicReference<>("");

        genItems.iterator().forEachRemaining((item) -> {
            if (item.equals(noItem)) {
                result.set("generated");
            }
        });

        if (result.get().equals("")) {
            hhItems.iterator().forEachRemaining((item) -> {
                if (item.equals(noItem)) {
                    result.set("handheld");
                }
            });
        }

        if (result.get().equals("")) {
            blockItems.iterator().forEachRemaining((item) -> {
                if (item.equals(noItem)) {
                    result.set("block");
                }
            });
        }
        return result.get();
    }
}
