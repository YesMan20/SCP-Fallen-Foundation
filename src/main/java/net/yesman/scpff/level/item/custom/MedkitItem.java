package net.yesman.scpff.level.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class MedkitItem extends Item {
    public MedkitItem(Properties pProperties) { super(pProperties); }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public SoundEvent getDrinkingSound() {
        return SoundEvents.CHAIN_PLACE;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pLivingEntity.setHealth(pLivingEntity.getHealth() + 46);
        pStack.shrink(1);
        return pStack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 12;
    }
}
