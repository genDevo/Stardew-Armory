package net.gendevo.stardewarmory.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class StardewArmoryConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ex_int;
    public static final ForgeConfigSpec.ConfigValue<String> ex_string;

    static {
        BUILDER.push("Config for the Stardew Armory mod");

        ex_int= BUILDER.comment("This is an int. Default value is 3.").define("Example int", 3);
        ex_string= BUILDER.comment("This is an string. Default value is NOPE.").define("Example string", "NOPE");

        BUILDER.pop();
        SPEC=BUILDER.build();
    }
}
