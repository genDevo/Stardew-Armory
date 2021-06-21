package net.gendevo.stardewarmory.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import java.util.Random;

import javax.annotation.Nullable;
import java.util.List;

public class CritSword extends SwordItem {
    float realDamage = 2.0f;
    public CritSword(IItemTier p_i48460_1_, int damageIn, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, damageIn, p_i48460_3_, p_i48460_4_);
        realDamage = realDamage + damageIn;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A7oChance to critically strike target"));

    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        Random rand = new Random();
        int critChance = 6;
        if (player.hasEffect(Effects.LUCK)) {
            critChance = critChance - 2;
        }
        int randomInt = rand.nextInt(critChance);
        if (randomInt == 1) {
            entity.hurt(DamageSource.playerAttack(player), realDamage*2);
            player.playSound(SoundEvents.NOTE_BLOCK_BIT, 1, 8);
        }
        return false;
    }
}
