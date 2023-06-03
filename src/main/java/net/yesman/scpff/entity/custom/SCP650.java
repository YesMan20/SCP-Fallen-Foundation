package net.yesman.scpff.entity.custom;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.yesman.scpff.misc.Helper;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;

public class SCP650 extends Mob implements IAnimatable {
    AnimationFactory cache = GeckoLibUtil.createFactory(this);
    private int cooldownTick = 0;

    public SCP650(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
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

    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return cache;
    }

    @Override
    public void tick() {
        this.setXRot(0);
        this.setYRot(0);
        this.setYHeadRot(0);
        for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(30), (val) -> val instanceof Player player && !player.isCreative())) {
            if (!this.level.isClientSide && entity instanceof Player player) {
                List<Entity> lookedAt = Helper.lookingAtInRange(player, 30);
                assert lookedAt != null;
                boolean isMe = lookedAt.contains(this);
                if (!isMe && player.hasLineOfSight(this) && this.cooldownTick + 200 < this.tickCount) {
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
        return pSource.equals(DamageSource.OUT_OF_WORLD);
    }
}
