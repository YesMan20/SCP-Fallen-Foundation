package net.yesman.scpff.level.item.scps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.SCP;

public class SCP109Item extends Item implements SCP {
    public SCP109Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        return pStack;
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
        return Classification.EUCLID;
    }

    @Override
    public String getNameId() {
        return "Infinite Canteen";
    }
}
