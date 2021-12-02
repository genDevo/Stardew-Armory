package net.gendevo.stardewarmory.items.weapons;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class UnobtainableSword extends SwordItem {
    private String whichToolTip;

    public UnobtainableSword(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_, String whichToolTip) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
        this.whichToolTip = whichToolTip;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        switch (whichToolTip) {
            case "alex": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.alex"));
                break;
            }
            case "sam": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.sam"));
                break;
            }
            case "harvey": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.harvey"));
                break;
            }
            case "maru": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.maru"));
                break;
            }
            case "penny": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.penny"));
                break;
            }
            case "seb": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.seb"));
                break;
            }
            case "haley": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.haley"));
                break;
            }
            case "abby": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.abby"));
                break;
            }
            case "elliot": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.elliot"));
                break;
            }
            case "leah": {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.leah"));
                break;
            }
        }

    }
}
