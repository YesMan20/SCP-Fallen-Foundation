package net.yesman.scpff.level.item.custom;

import net.minecraft.ChatFormatting;
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
import net.yesman.scpff.misc.Helper;
import net.yesman.scpff.level.entity.scp.SCP131;
import net.yesman.scpff.level.entity.scp.SCP173;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SledgeHammerItem extends PickaxeItem {
    public SledgeHammerItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pTarget, InteractionHand pUsedHand) {
        if (pTarget instanceof SCP173 scp173) {
            SCP173.Variants variant = scp173.getVariant();
            SCP173.Variants newVariant = SCP173.Variants.values().length <= variant.ordinal() + 1 ? SCP173.Variants.values()[0] : SCP173.Variants.values()[variant.ordinal() + 1];
            scp173.setModel(newVariant);
            this.smash(pPlayer.level(), pPlayer, pTarget);

        } else if (pTarget instanceof SCP131 scp131) {
            SCP131.Variants variant = scp131.getVariant();
            SCP131.Variants newVariant = SCP131.Variants.values().length <= variant.ordinal() + 1 ? SCP131.Variants.values()[0] : SCP131.Variants.values()[variant.ordinal() + 1];
            scp131.setModel(newVariant);
            this.smash(pPlayer.level(), pPlayer, pTarget);
        }
        return super.interactLivingEntity(pStack, pPlayer, pTarget, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        Helper.showTooltipOnShift(Component.translatable("tooltip.scpff.sledgehammer").withStyle(ChatFormatting.BLUE), tooltip);
        super.appendHoverText(stack, level, tooltip, flag);
    }

    // i dont know what to call this method
    private void smash(Level level, Player player, LivingEntity entity) {
        if (level.isClientSide) {
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_USE, SoundSource.PLAYERS, 0.7F, 1.0F);
            player.swing(player.getUsedItemHand());
            for (int i = 0; i < 10; i++) {
                player.level().addParticle(ParticleTypes.CLOUD, entity.getRandomX(0.5D), entity.getRandomY(), entity.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
            }
        }
    }
}
