package net.gendevo.stardewarmory.util;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;


@OnlyIn(Dist.CLIENT)
public class KeybindSetup {
    public static KeyMapping iridiumKey;

    public static void register(final FMLClientSetupEvent e) {
        iridiumKey = create("iridium_tool_mode_key", KeyEvent.VK_R);

        ClientRegistry.registerKeyBinding(iridiumKey);
    }

    public static KeyMapping create(String name, int key) {
        return new KeyMapping("key." + StardewArmory.MOD_ID + "." + name, key, "key.category." + StardewArmory.MOD_ID);
    }
}
