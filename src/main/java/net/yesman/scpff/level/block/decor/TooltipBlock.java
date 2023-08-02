package net.yesman.scpff.level.block.decor;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipBlock extends Block {
    private final String text;

    public TooltipBlock(Properties property, String text) {
        super(property);
        this.text = text;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> tooltip, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.literal(text));
        } else {
            tooltip.add(Component.literal("§8Shift+ for Info"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
