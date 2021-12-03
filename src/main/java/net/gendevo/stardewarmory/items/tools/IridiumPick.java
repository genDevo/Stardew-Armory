package net.gendevo.stardewarmory.items.tools;

import net.gendevo.stardewarmory.data.capabilities.IridiumCapabilityManager;
import net.gendevo.stardewarmory.util.KeybindSetup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class IridiumPick extends PickaxeItem {

    public IridiumPick(IItemTier p_i48478_1_, int p_i48478_2_, float p_i48478_3_, Properties p_i48478_4_) {
        super(p_i48478_1_, p_i48478_2_, p_i48478_3_, p_i48478_4_);
    }

    @Override
    public ITextComponent getDescription() {
        return super.getDescription();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        stack.getCapability(IridiumCapabilityManager.IRIDIUM_CAPABILITY).ifPresent(h -> {
            if (h.isIridiumMode() ) {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.iridium_pick_on"));
            } else {
                tooltip.add(new TranslationTextComponent("tooltip.stardewarmory.iridium_pick_off"));
            }
        });
        if (!Objects.isNull(world)) {
            tooltip.add(new StringTextComponent(new TranslationTextComponent("tooltip.stardewarmory.press").getString() +
                    KeybindSetup.iridiumKey.getKey().getName().replaceAll("key.keyboard.", "").toUpperCase() +
                    new TranslationTextComponent("tooltip.stardewarmory.toggle").getString()));
        }
    }
}
