package net.yesman.scpff.level.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.yesman.scpff.level.entity.custom.SCP173;

public class SledgeHammer extends PickaxeItem {
    public SledgeHammer(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget instanceof SCP173 scp173) {
            SCP173.Variants variant = scp173.getVariant();
            SCP173.Variants newVariant = SCP173.Variants.values().length <= variant.ordinal() + 1 ? SCP173.Variants.values()[0] : SCP173.Variants.values()[variant.ordinal() + 1];
            scp173.setModel(newVariant);
        }
        return super.interactLivingEntity(pStack, pPlayer, pInteractionTarget, pUsedHand);
    }
}
