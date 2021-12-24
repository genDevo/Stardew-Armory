package net.gendevo.stardewarmory.util;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.config.StardewArmoryConfig;
import net.gendevo.stardewarmory.data.capabilities.IridiumModeCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;

public class IridiumModeGui extends GuiComponent implements IIngameOverlay {

    private static final ResourceLocation IRIDIUM = new ResourceLocation(StardewArmory.MOD_ID, "textures/gui/iridium_on.png");

    @Override
    public void render(ForgeIngameGui gui, PoseStack mStack, float partialTicks, int width, int height) {
        Minecraft mc = Minecraft.getInstance();
        if (!mc.options.hideGui && StardewArmoryConfig.iridium_indicator.get()) {
            mc.player.getMainHandItem().getCapability(IridiumModeCapability.IRIDIUM_CAPABILITY).ifPresent(h -> {
                if (h.isIridiumMode()) {
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.85f);
                    RenderSystem.setShaderTexture(0, IRIDIUM);
                    double posx = Math.ceil((mc.getWindow().getGuiScaledWidth() / 2f) - 7f);
                    double posy = Math.ceil((mc.getWindow().getGuiScaledHeight() / 2f) - 10f);
                    blit(mStack, (int) posx, (int) posy, this.getBlitOffset(), 0f, 0f, 13, 5, 16, 16);
                }
            });
        }
    }

    public static void register() {
        OverlayRegistry.registerOverlayAbove(
                ForgeIngameGui.CROSSHAIR_ELEMENT,
                "stardewarmory.iridium_mode_overlay",
                new IridiumModeGui()
        );
    }
}

