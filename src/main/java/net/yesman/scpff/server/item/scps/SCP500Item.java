package net.yesman.scpff.server.item.scps;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.SCP;

import java.util.Map;

public class SCP500Item extends Item implements SCP {
    public SCP500Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        Player player = (Player) pLivingEntity;
        if (!player.isCreative()) {
            pStack.shrink(1);
        }

        Map<MobEffect, MobEffectInstance> effects = pLivingEntity.getActiveEffectsMap();
        effects.entrySet().removeIf(mobEffectMobEffectInstanceEntry -> !mobEffectMobEffectInstanceEntry.getKey().isBeneficial());

        return pStack;
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 1;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.EAT;
    }

    @Override
    public Classification getClassification() {
        return Classification.SAFE;
    }

    @Override
    public String getNameId() {
        return "Panacea";
    }
}
