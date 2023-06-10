package net.yesman.scpff.level.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.yesman.scpff.misc.RunnableCooldownHandler;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.UUID;

public class SCP049 extends Monster implements IAnimatable, NeutralMob {
    AnimationFactory cache = GeckoLibUtil.createFactory(this);
    private static final EntityDataAccessor<Boolean> DATA_HAS_TARGET = SynchedEntityData.defineId(SCP049.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_CURING = SynchedEntityData.defineId(SCP049.class, EntityDataSerializers.BOOLEAN);
    private static final AttributeModifier modifier = new AttributeModifier("049", -1, AttributeModifier.Operation.MULTIPLY_BASE);

    public SCP049(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.MAX_HEALTH, 400.0F)
                .add(Attributes.FOLLOW_RANGE, 40.0F)
                .add(Attributes.ATTACK_SPEED, 0.3F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 7f)
                .add(Attributes.ATTACK_DAMAGE, 100.0F);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "Controller", 0, state -> {
            if (this.isCuring()) {
                state.getController().setAnimation(new AnimationBuilder().addAnimation("animation.scp049.attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            } else if (this.hasTarget() && state.isMoving()) {
                state.getController().setAnimation(new AnimationBuilder().addAnimation("animation.scp049.aggressive", ILoopType.EDefaultLoopTypes.LOOP));
            } else if (!state.isMoving()) {
                state.getController().setAnimation(new AnimationBuilder().addAnimation("animation.scp049.idle", ILoopType.EDefaultLoopTypes.LOOP));
            } else if (state.isMoving()) {
                state.getController().setAnimation(new AnimationBuilder().addAnimation("animation.scp049.moving", ILoopType.EDefaultLoopTypes.LOOP));
            }

            return PlayState.CONTINUE;
        }));
    }

    public void Cure(ServerLevel level, Player player) {
        if (player != null) {
            this.setIsCuring(true);
            this.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(modifier);
            RunnableCooldownHandler.addDelayedRunnable(() -> {
                if (this.isDeadOrDying()) return;
                Zombie zombie = new Zombie(EntityType.ZOMBIE, level);
                zombie.teleportTo(this.getX(), this.getY(), this.getZ());
                zombie.setPersistenceRequired();
                level.addFreshEntity(zombie);
                this.setIsCuring(false);
                if (this.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(modifier)) {
                    this.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(modifier);
                }
            }, 20);

        }
    }


    @Override
    public void checkDespawn() {

    }

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);
        this.setHasTarget(pTarget != null);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_HAS_TARGET, false);
        this.entityData.define(DATA_IS_CURING, false);
    }

    public boolean hasTarget() {
        return this.entityData.get(DATA_HAS_TARGET);
    }

    public void setHasTarget(boolean hasTarget) {
        this.entityData.set(DATA_HAS_TARGET, hasTarget);
    }

    public boolean isCuring() {
        return this.entityData.get(DATA_IS_CURING);
    }

    public void setIsCuring(boolean isCuring) {
        this.entityData.set(DATA_IS_CURING, isCuring);
    }

    @Override
    public AnimationFactory getFactory() {
        return cache;
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return 0;
    }

    @Override
    public void setRemainingPersistentAngerTime(int pRemainingPersistentAngerTime) {

    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return null;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pPersistentAngerTarget) {

    }

    @Override
    public void startPersistentAngerTimer() {

    }

}
