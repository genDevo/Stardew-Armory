package net.gendevo.stardewarmory.items.weapons;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import javax.annotation.Nullable;
import java.util.List;

public class UnobtainableSword extends SwordItem {
    private final String whichToolTip;

    public UnobtainableSword(Tier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_, String whichToolTip) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
        this.whichToolTip = whichToolTip;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable net.minecraft.world.level.Level pLevel, List<Component> tooltip, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, tooltip, pIsAdvanced);
        switch (whichToolTip) {
            case "alex" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.alex")));
            }
            case "sam" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.sam")));
            }
            case "harvey" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.harvey")));
            }
            case "maru" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.maru")));
            }
            case "penny" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.penny")));
            }
            case "seb" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.seb")));
            }
            case "haley" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.haley")));
            }
            case "abby" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.abby")));
            }
            case "elliot" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.elliot")));
            }
            case "leah" -> {
                tooltip.add(MutableComponent.create(new TranslatableContents("tooltip.stardewarmory.leah")));
            }
        }
    }    
}
