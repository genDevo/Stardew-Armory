package net.gendevo.stardewarmory.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class StardewArmoryConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> iridium_rate;
    public static final ForgeConfigSpec.ConfigValue<Integer> cinder_rate;
    public static final ForgeConfigSpec.ConfigValue<Integer> savage_rate;
    public static final ForgeConfigSpec.ConfigValue<Float> club_rate;
    public static final ForgeConfigSpec.ConfigValue<Boolean> crit_sound;
    public static final ForgeConfigSpec.ConfigValue<Boolean> guild_spawn;

    static {
        BUILDER.push("Config for the Stardew Armory mod");

        guild_spawn= BUILDER.comment("Should Guild structures spawn in the world. Default value is true")
                .define("Crit bool", true);
        iridium_rate= BUILDER.comment("How many veins of iridium ore should spawn per chunk. Default value is 4")
                .define("Iridium int", 4);
        cinder_rate= BUILDER.comment("How many veins of cinder ore should spawn per chunk. Default value is 20")
                .define("Cinder int", 20);
        club_rate= BUILDER.comment("Chance for a zombie to spawn with a wooden club in hand. Accepts values within a range of [1,0). Default value is 0.05 (5%)")
                .define("Club float", 0.05f);
        crit_sound= BUILDER.comment("Should Lucky Hit play the critical sound effect. Default value is true")
                .define("Crit bool", true);
        savage_rate= BUILDER.comment("How likely the savage ring is to proc after a kill. Default value is 8")
                .define("Savage int", 8);

        BUILDER.pop();
        SPEC=BUILDER.build();
    }
}
