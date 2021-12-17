package net.gendevo.stardewarmory.items.weapons;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.Nullable;
import java.util.List;

public class UnobtainableSword extends SwordItem {
    private String whichToolTip;

    public UnobtainableSword(Tier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_, String whichToolTip) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
        this.whichToolTip = whichToolTip;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable net.minecraft.world.level.Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, tooltip, pIsAdvanced);
        switch (whichToolTip) {
            case "alex": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.alex"));
                break;
            }
            case "sam": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.sam"));
                break;
            }
            case "harvey": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.harvey"));
                break;
            }
            case "maru": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.maru"));
                break;
            }
            case "penny": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.penny"));
                break;
            }
            case "seb": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.seb"));
                break;
            }
            case "haley": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.haley"));
                break;
            }
            case "abby": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.abby"));
                break;
            }
            case "elliot": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.elliot"));
                break;
            }
            case "leah": {
                tooltip.add(new TranslatableComponent("tooltip.stardewarmory.leah"));
                break;
            }
        }
    }    
}
