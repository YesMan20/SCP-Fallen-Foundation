package net.yesman.scpff.server.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.yesman.scpff.server.entity.scp.SCP131;
import net.yesman.scpff.server.entity.scp.SCP173;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SledgeHammerItem extends PickaxeItem {
    public SledgeHammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity target, InteractionHand pUsedHand) {
        Level level = pPlayer.level();

        if (pPlayer.level().isClientSide && target instanceof SCP173 scp173 || target instanceof SCP131 scp131) {
            level.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ANVIL_USE, SoundSource.PLAYERS, 0.7F, 1.0F);
            pPlayer.swing(pUsedHand);
            for (int i = 0; i < 10; i++) {
                pPlayer.level().addParticle(ParticleTypes.CLOUD, target.getRandomX(0.5D), target.getRandomY(), target.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }
        if (target instanceof SCP173 scp173) {
            SCP173.Variants variant = scp173.getVariant();
            SCP173.Variants newVariant = SCP173.Variants.values().length <= variant.ordinal() + 1 ? SCP173.Variants.values()[0] : SCP173.Variants.values()[variant.ordinal() + 1];
            scp173.setModel(newVariant);
        }
        if (target instanceof SCP131 scp131) {
            SCP131.Variants variant = scp131.getVariant();
            SCP131.Variants newVariant = SCP131.Variants.values().length <= variant.ordinal() + 1 ? SCP131.Variants.values()[0] : SCP131.Variants.values()[variant.ordinal() + 1];
            scp131.setModel(newVariant);
        }
        return super.interactLivingEntity(pStack, pPlayer, target, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.scpff.sledgehammer"));
        super.appendHoverText(stack, level, tooltip, flag);
    }
}
