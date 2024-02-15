package net.yesman.scpff.level.block;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.yesman.scpff.misc.Helper;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipBlock extends Block {
    private final Component component;

    public TooltipBlock(Component component, Properties property) {
        super(property);
        this.component = component;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        Helper.showTooltipOnShift(this.component, tooltip);
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
