package net.yesman.scpff.level.entity.goals;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.yesman.scpff.level.entity.custom.SCP049;
import net.yesman.scpff.level.item.ModItems;

import java.util.ArrayList;
import java.util.List;

import static net.yesman.scpff.level.entity.init.EntityInit.VOICE_LINES;

public class SCP049LookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
    private final SCP049 scp049;
    public SCP049LookForPlayerGoal(SCP049 scp049, Class<Player> pTargetType, boolean pMustSee) {
        super(scp049, pTargetType, pMustSee);
        this.scp049 = scp049;
    }

    @Override
    public boolean canUse() {
        Player pendingTarget = this.scp049.level.getNearestPlayer(TargetingConditions.forCombat().range(this.getFollowDistance()).selector((livingEntity -> {
            if (livingEntity instanceof Player player && player.isCreative()) {
                return false;
            }
            return !livingEntity.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SCP268.get());
        })), this.scp049);
        if (RandomSource.create().nextFloat() > 0.7F && pendingTarget != null) {
            pendingTarget.displayClientMessage(Component.literal("I SENSE THE DISEASE").withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), false);
            this.findTarget();
            return true;
        }
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        if (RandomSource.create().nextFloat() > 0.99F) {
            if (this.target instanceof Player player) {
                player.displayClientMessage(Component.literal(VOICE_LINES.get(RandomSource.create().nextInt(VOICE_LINES.size()))).withStyle(ChatFormatting.RED).withStyle(ChatFormatting.BOLD), false);
            }
        }
        return super.canContinueToUse();
    }
}
