package net.gendevo.stardewarmory.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GalaxyForgeScreen extends HandledScreen<GalaxyForgeScreenHandler> {
    private static final Identifier TEXTURE =
            new Identifier(StardewArmory.MODID, "textures/gui/galaxy_forge_gui.png");

    public GalaxyForgeScreen(GalaxyForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        // Center the title
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if (handler.hasShards()) {
            this.drawTexture(matrices, x+46, y+23, 176, 0, 78, 23);
        }

        if (handler.isCrafting()) {
            int progress = handler.getScaledProgress();
            this.drawTexture(matrices, x+57, y+39, 176, 23, progress, 29);
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}
