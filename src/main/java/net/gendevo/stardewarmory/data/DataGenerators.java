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

        // Swords
        hhItems.add("iridium_needle");

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
