package net.gendevo.stardewarmory.data;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class DataGenerators {

    public static String createItemModelJson(String id, String type) {
        if ("generated".equals(type) || "handheld".equals(type)) {
            //The two types of items. "handheld" is used mostly for tools and the like, while "generated" is used for everything else.
            return "{\n" +
                    "  \"parent\": \"item/" + type + "\",\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"stardewarmory:" + id + "\"\n" +
                    "  }\n" +
                    "}";
        } else if ("block".equals(type)) {
            return "";
        } else {
            //If the type is invalid, return an empty json string.
            return "";
        }
    }

    public static String getItemModelType(String id) {
        String noItem = id.split("/")[1];
        AtomicReference<String> result = new AtomicReference<>("");

        Set<String> blockItems = new HashSet<>();
        blockItems.add("iridium_ore");
        blockItems.iterator().forEachRemaining((item) -> {
            if (item.equals(noItem)) {
                result.set("block");
            }
        });

        if (result.get().equals("")) {
            Set<String> hhItems = new HashSet<>();
            hhItems.add("galaxy_hammer");
            hhItems.iterator().forEachRemaining((item) -> {
                if (item.equals(noItem)) {
                    result.set("handheld");
                }
            });
        }

        if (result.get().equals("")) {
            Set<String> genItems = new HashSet<>();
            genItems.add("prismatic_shard");
            genItems.iterator().forEachRemaining((item) -> {
                if (item.equals(noItem)) {
                    result.set("generated");
                }
            });
        }
        return result.get().equals("") ? "generated" : result.get();
    }
}
