package net.yesman.scpff.level.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.level.entity.goals.SCP049LookForPlayerGoal;
import net.yesman.scpff.misc.RunnableCooldownHandler;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;

public class SCP049 extends Monster implements GeoEntity, NeutralMob {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Boolean> DATA_HAS_TARGET = SynchedEntityData.defineId(SCP049.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> DATA_IS_CURING = SynchedEntityData.defineId(SCP049.class, EntityDataSerializers.BOOLEAN);
    private static final AttributeModifier modifier = new AttributeModifier("049", -1, AttributeModifier.Operation.MULTIPLY_BASE);

    public SCP049(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("scpff:scp049breathing"));
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(18, new RandomStrollGoal(this, 1));
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(3, new SCP049LookForPlayerGoal(this, Player.class, true));
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

    private static final RawAnimation ATTACK_ANIM = RawAnimation.begin().then("animation.scp049.attack", Animation.LoopType.PLAY_ONCE);
    private static final RawAnimation CHASE_ANIM = RawAnimation.begin().then("animation.scp049.aggressive", Animation.LoopType.LOOP);
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("animation.scp049.idle", Animation.LoopType.LOOP);
    private static final RawAnimation WALK_ANIM = RawAnimation.begin().then("animation.scp049.moving", Animation.LoopType.LOOP);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controller) {
        controller.add(new AnimationController<>(this, "Controller", 3, state -> {
            if (this.isCuring()) {
                state.getController().setAnimation(ATTACK_ANIM);
            } else if (this.hasTarget() && state.isMoving()) {
                state.getController().setAnimation(CHASE_ANIM);
            } else if (!state.isMoving()) {
                state.getController().setAnimation(IDLE_ANIM);
            } else if (state.isMoving()) {
                state.getController().setAnimation(WALK_ANIM);
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
                Husk husk = new Husk(EntityType.HUSK, level);
                husk.teleportTo(this.getX(), this.getY(), this.getZ());
                husk.setPersistenceRequired();
                level.addFreshEntity(husk);
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
    public AnimatableInstanceCache getAnimatableInstanceCache() {
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
