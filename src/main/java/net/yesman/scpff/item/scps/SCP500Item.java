package net.yesman.scpff.item.scps;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class SCP500Item extends Item {
    public SCP500Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        if (pStack.getItem().isEdible()) {
            return pStack.getFoodProperties(null).isFastFood() ? 1 : 2;
        } else {
            return 0;
        }
    }
}
