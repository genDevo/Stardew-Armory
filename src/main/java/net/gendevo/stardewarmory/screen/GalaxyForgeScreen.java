package net.gendevo.stardewarmory.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.conatiners.GalaxyForgeContainer;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GalaxyForgeScreen extends AbstractContainerScreen<GalaxyForgeContainer> {
    private GalaxyForgeContainer container;
    private final ResourceLocation GUI = new ResourceLocation(StardewArmory.MOD_ID,
            "textures/gui/galaxy_forge_gui.png");

    public GalaxyForgeScreen(GalaxyForgeContainer screenContainer, Inventory inv, Component title) {
        super(screenContainer, inv, title);
        this.container = screenContainer;
    }

    @Override
    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pPoseStack, pMouseX, pMouseY);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI);

        int i = this.getGuiLeft();
        int j = this.getGuiTop();

        this.blit(pPoseStack, i, j, 0, 0, this.getXSize(), this.getYSize());

        if (this.container.hasCinderShards()) {
            this.blit(pPoseStack, i+48, j+23, 176, 0, 78,45);
        }
    }
}
