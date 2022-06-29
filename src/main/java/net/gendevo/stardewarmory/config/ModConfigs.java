package net.gendevo.stardewarmory.config;

import com.mojang.datafixers.util.Pair;
import net.gendevo.stardewarmory.StardewArmory;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static String TEST;
    public static boolean LUCKY_HIT_SOUND;
    public static double SOME_DOUBLE;
    public static int MAX_DAMAGE_DOWSING_ROD;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(StardewArmory.MODID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("key.test.value1", "Just a Testing string!"), "String");
        configs.addKeyValuePair(new Pair<>("key.test.value3", 4142.5), "double");
        configs.addKeyValuePair(new Pair<>("dowsing.rod.max.damage", 32), "int");
    }

    private static void assignConfigs() {
        TEST = CONFIG.getOrDefault("key.test.value1", "Nothing");
        LUCKY_HIT_SOUND = CONFIG.getOrDefault("lucky_hit_sound", true);
        SOME_DOUBLE = CONFIG.getOrDefault("key.test.value3", 42.0d);
        MAX_DAMAGE_DOWSING_ROD = CONFIG.getOrDefault("dowsing.rod.max.damage", 32);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
