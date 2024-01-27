package net.yesman.scpff.server.entity.ai.goals;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.yesman.scpff.server.entity.scp.SCP049;
import net.yesman.scpff.server.item.FFItemsRegistry;

import static net.yesman.scpff.server.entity.init.EntityInit.VOICE_LINES;

public class SCP049LookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
    private final SCP049 scp049;
    public SCP049LookForPlayerGoal(SCP049 scp049, Class<Player> pTargetType, boolean pMustSee) {
        super(scp049, pTargetType, pMustSee);
        this.scp049 = scp049;
    }

    @Override
    public boolean canUse() {
        Player pendingTarget = this.scp049.level().getNearestPlayer(TargetingConditions.forCombat().range(this.getFollowDistance()).selector((livingEntity -> {
            if (livingEntity instanceof Player player && player.isCreative() || livingEntity instanceof AbstractVillager villager) {
                return false;
            }
            return !livingEntity.getItemBySlot(EquipmentSlot.HEAD).is(FFItemsRegistry.SCP268.get());
        })), this.scp049);
        if (RandomSource.create().nextFloat() > 0.99F && pendingTarget != null) {
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
