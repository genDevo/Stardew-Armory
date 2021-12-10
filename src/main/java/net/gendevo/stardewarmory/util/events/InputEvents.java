package net.gendevo.stardewarmory.util.events;

import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.network.ModNetwork;
import net.gendevo.stardewarmory.network.PacketToggleIridium;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)

public class InputEvents {

    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;
        onInput(mc, event.getKey(), event.getAction());
    }

    @SubscribeEvent
    public static void onMouseClick(InputEvent.MouseInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null) return;
        onInput(mc, event.getButton(), event.getAction());
    }

    private static void onInput(Minecraft mc, int key, int action) {
        if (mc.screen == null && KeybindSetup.iridiumKey.consumeClick()) {
            ModNetwork.CHANNEL.sendToServer(new PacketToggleIridium(key));
            assert mc.level != null;
        }
    }
}
