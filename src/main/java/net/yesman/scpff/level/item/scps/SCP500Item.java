package net.yesman.scpff.level.item.scps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.Map;


public class SCP500Item extends Item {
    public SCP500Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        pStack.shrink(1);
        Map<MobEffect, MobEffectInstance> effects = pLivingEntity.getActiveEffectsMap();
        effects.entrySet().removeIf(mobEffectMobEffectInstanceEntry -> !mobEffectMobEffectInstanceEntry.getKey().isBeneficial());

        return pStack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 3;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }
}
