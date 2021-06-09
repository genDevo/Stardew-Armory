package net.gendevo.stardewarmory.setup.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

import javax.annotation.Nullable;
import java.util.List;

public class SpecialItem extends Item {

    public SpecialItem(Properties properties) {
        super(properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        if (InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), GLFW.GLFW_KEY_LEFT_SHIFT)) {
            tooltip.add(new StringTextComponent("\u00A75TEsto \u00A71toolo"));

        } else {
            tooltip.add(new StringTextComponent("Press \u00A76SHIFT\u00A7r for more info"));
        }
    }


    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (player.isInWater()) {
            player.addEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 3));
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.addEffect(new EffectInstance(Effects.GLOWING, 200, 5));
        return ActionResult.success(playerIn.getItemInHand(handIn));
    }

    @Override
    public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
        if (getItemCategory() == tab) {
            ItemStack istack = new ItemStack(this);
            istack.enchant(Enchantments.FIRE_ASPECT, 1);
            list.add(istack);
        }
    }
}


