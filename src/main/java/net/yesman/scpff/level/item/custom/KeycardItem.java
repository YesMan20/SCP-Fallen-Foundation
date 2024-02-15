package net.yesman.scpff.level.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.yesman.scpff.SCPFf;

public class KeycardItem extends Item {
    public final int level;

    public KeycardItem(Properties property, int level) {
        super(property);
        this.level = level;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        // Not necessary, purely for testing
        SCPFf.LOGGER.info("[KEYCARD VALUE]: " + level);
        return super.useOn(context);
    }

    public int getLevel() {
        return level;
    }
}
