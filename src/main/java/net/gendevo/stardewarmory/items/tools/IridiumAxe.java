package net.gendevo.stardewarmory.items.tools;

import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class IridiumAxe extends AxeItem {
    public boolean fellMode = false;

    public IridiumAxe(IItemTier p_i48530_1_, float p_i48530_2_, float p_i48530_3_, Properties p_i48530_4_) {
        super(p_i48530_1_, p_i48530_2_, p_i48530_3_, p_i48530_4_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide()) {
            fellMode = !fellMode;
        } else {
            if (fellMode) {
                ((ClientWorld)world).playLocalSound(player.blockPosition(), ModSoundEvents.TOGGLE_OFF_SOUND.get(), SoundCategory.PLAYERS, 1, 1, false);
            } else {
                ((ClientWorld)world).playLocalSound(player.blockPosition(), ModSoundEvents.TOGGLE_ON_SOUND.get(), SoundCategory.PLAYERS, 1, 1, false);
            }
        }
        return ActionResult.success(player.getItemInHand(hand));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        if (InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(new StringTextComponent("Feller mode is curently " + (fellMode ? "\u00A7aENABLED" : "\u00A7cDISABLED")));

        } else {
            tooltip.add(new StringTextComponent("Press \u00A76SHIFT\u00A7r for more info"));
        }
    }
}