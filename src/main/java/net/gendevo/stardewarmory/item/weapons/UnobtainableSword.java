package net.gendevo.stardewarmory.item.weapons;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UnobtainableSword extends SwordItem {
    private String whichTooltip;

    public UnobtainableSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, String whichTooltip) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.whichTooltip = whichTooltip;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        switch (whichTooltip) {
            case "alex" -> tooltip.add(Text.translatable("tooltip.stardewarmory.alex"));
            case "sam" -> tooltip.add(Text.translatable("tooltip.stardewarmory.sam"));
            case "harvey" -> tooltip.add(Text.translatable("tooltip.stardewarmory.harvey"));
            case "maru" -> tooltip.add(Text.translatable("tooltip.stardewarmory.maru"));
            case "penny" -> tooltip.add(Text.translatable("tooltip.stardewarmory.penny"));
            case "seb" -> tooltip.add(Text.translatable("tooltip.stardewarmory.seb"));
            case "haley" -> tooltip.add(Text.translatable("tooltip.stardewarmory.haley"));
            case "abby" -> tooltip.add(Text.translatable("tooltip.stardewarmory.abby"));
            case "elliot" -> tooltip.add(Text.translatable("tooltip.stardewarmory.elliot"));
            case "leah" -> tooltip.add(Text.translatable("tooltip.stardewarmory.leah"));
        }
    }
}
