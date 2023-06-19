package net.yesman.scpff.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.yesman.scpff.level.item.ModItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MeleeAttackGoal.class)
public class MeleeAttackGoalMixin {

    @Shadow @Final protected PathfinderMob mob;

    @Inject(at = @At("HEAD"), method = "canContinueToUse", cancellable = true)
    public void canContinueInject(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity == null) return;
        if (livingentity.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.SCP268.get())) cir.setReturnValue(false);
    }

}
