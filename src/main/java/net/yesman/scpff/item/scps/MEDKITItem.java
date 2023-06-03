package net.yesman.scpff.item.scps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class MEDKITItem extends Item {
    public MEDKITItem(Properties pProperties) { super(pProperties); }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return pStack.getItem().isEdible() ? UseAnim.BLOCK : UseAnim.NONE;
    }

    public SoundEvent getEatingSound() {
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
        if (pStack.getItem().isEdible()) {
            return pStack.getFoodProperties(null).isFastFood() ? 7 : 12;
        } else {
            return 0;
        }
    }
}
