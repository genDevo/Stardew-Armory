package net.gendevo.stardewarmory.util;

import net.gendevo.stardewarmory.StardewArmory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, value = Dist.CLIENT)
public class IridiumModeGui extends Gui {

    private final ResourceLocation iridium = new ResourceLocation(StardewArmory.MOD_ID, "textures/gui/iridium_on.png");
    private Minecraft mc;

    public IridiumModeGui(Minecraft mc) {
        super(mc);
        mc = mc;
    }

//    @SubscribeEvent
//    public void onCrosshairDraw(RenderGameOverlayEvent.Post event) {
//        assert mc.player != null;
//        mc.player.getMainHandItem().getCapability(IridiumCapabilityManager.IRIDIUM_CAPABILITY).ifPresent(h-> {
//            if (h.isIridiumMode()) {
//                if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
//                    RenderSystem.color4f(1f, 1f, 1f, 0.85f);
//                    mc.getTextureManager().bind(iridium);
//                    double posx = Math.ceil((event.getWindow().getGuiScaledWidth()/2f)-7f);
//                    double posy = Math.ceil((event.getWindow().getGuiScaledHeight()/2f)-10f);
//                    blit(event.getMatrixStack(), (int)posx, (int)posy, this.getBlitOffset(), 0f,0f,13,5, 16, 16);
//                }
//            }
//        });
//    }
}

