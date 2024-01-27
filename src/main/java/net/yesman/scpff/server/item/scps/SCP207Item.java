package net.yesman.scpff.server.item.scps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.SCP;

public class SCP207Item extends Item implements SCP {
    public SCP207Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public Classification getClassification() {
        return Classification.SAFE;
    }
}
