package net.yesman.scpff.level.entity.scp;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.Helper;
import net.yesman.scpff.misc.SCP;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SCP650 extends Mob implements GeoEntity, SCP {
    AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int cooldownTick = 0;

    public SCP650(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    /**
     * Basic Entity Stuff
     */

    @Override
    public Classification getClassification() {
        return Classification.EUCLID;
    }

    @Override
    public String getNameId() {
        return "Startling Statue";
    }

    @Override
    protected void registerGoals() {
        this.addBehaviourGoals();
    }

    // Isn't necessary, but looks cleaner.
    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
    }

    // Change these to whatever you want.
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.0F)
                .add(Attributes.MAX_HEALTH, 400.0F)
                .add(Attributes.FOLLOW_RANGE, 40.0F)
                .add(Attributes.ATTACK_SPEED, 0.3F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 7f)
                .add(Attributes.ATTACK_DAMAGE, 0.0F);
    }

    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private static final RawAnimation RANDOM2 = RawAnimation.begin().then("animation.scp650.random", Animation.LoopType.LOOP);
    private static final RawAnimation RANDOM1 = RawAnimation.begin().then("animation.scp650.random2", Animation.LoopType.LOOP);
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("animation.scp650.idle", Animation.LoopType.LOOP);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state -> PlayState.CONTINUE));
    }

    /**
     * Entity Main Mechanic
     */

    @Override
    public void tick() {
        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(30), (val) -> val instanceof Player player && !player.isCreative())) {
            if (!this.level().isClientSide && entity instanceof Player player) {
                Entity lookedAt = Helper.lookingAtInRange(player, 30);
                if (lookedAt != this && ((LivingEntity) entity).hasLineOfSight(this) && this.cooldownTick + 200 < this.tickCount) {
                    this.cooldownTick = this.tickCount;
                    Vec3 vec3 = Helper.calculateViewVector(0, entity.getYRot()).scale(-1.0F);
                    Vec3 vec32 = new Vec3(entity.getX(), entity.getY(), entity.getZ()).add(vec3);
                    this.teleportTo(vec32.x, vec32.y, vec32.z);
                }
            }
        }
        super.tick();
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return super.hurt(pSource, pAmount);
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
}
