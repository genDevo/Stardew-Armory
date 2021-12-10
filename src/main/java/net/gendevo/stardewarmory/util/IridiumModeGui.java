package net.gendevo.stardewarmory.util;

import com.mojang.blaze3d.systems.RenderSystem;
import net.gendevo.stardewarmory.StardewArmory;
import net.gendevo.stardewarmory.data.capabilities.IridiumCapabilityManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = StardewArmory.MOD_ID, value = Dist.CLIENT)
public class IridiumModeGui extends IngameGui {

    private final ResourceLocation iridium = new ResourceLocation(StardewArmory.MOD_ID, "textures/gui/iridium_on.png");
    private Minecraft mc;

    public IridiumModeGui(Minecraft p_i46325_1_) {
        super(p_i46325_1_);
        mc = p_i46325_1_;
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

