package net.gendevo.stardewarmory.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.conatiners.GalaxyForgeContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GalaxyForgeScreen extends ContainerScreen<GalaxyForgeContainer> {
    private GalaxyForgeContainer container;
    private final ResourceLocation GUI = new ResourceLocation(StardewArmory.MOD_ID,
            "textures/gui/galaxy_forge_gui.png");

    public GalaxyForgeScreen(GalaxyForgeContainer screenContainer, PlayerInventory inv, ITextComponent title) {
        super(screenContainer, inv, title);
        this.container = screenContainer;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.getGuiLeft();
        int j = this.getGuiTop();
        this.blit(matrixStack, i, j, 0, 0, this.getXSize(), this.getYSize());

        if (this.container.hasCinderShards()) {
            this.blit(matrixStack, i+48, j+23, 176, 0, 78,45);
        }
    }
}
