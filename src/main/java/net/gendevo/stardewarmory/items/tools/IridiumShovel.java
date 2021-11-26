package net.gendevo.stardewarmory.items.tools;


import net.gendevo.stardewarmory.setup.ModSoundEvents;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class IridiumShovel extends ShovelItem {
    public boolean smeltMode;

    public IridiumShovel(IItemTier p_i48469_1_, float p_i48469_2_, float p_i48469_3_, Properties p_i48469_4_) {
        super(p_i48469_1_, p_i48469_2_, p_i48469_3_, p_i48469_4_);
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClientSide()) {
            smeltMode = !smeltMode;
        } else {
            if (smeltMode) {
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
            if (smeltMode) {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.iridium_shovel_on"));
            } else {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.iridium_shovel_off"));
            }
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.hold_shift"));
        }
    }



}
