package net.yesman.scpff.level.entity.custom;

import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.level.sound.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SCP058 extends Monster implements GeoEntity {
    public final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(SCP058.class, EntityDataSerializers.BYTE);
    public SCP058(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 7.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 5f)
                .add(Attributes.MAX_HEALTH, 58.0D);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(18, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 1.5F, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Animal.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, Piglin.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, ZombifiedPiglin.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, SCP939.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, SCP049.class, true));
        this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, SCP1507.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.SCP058BEATING.get();
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    public void setClimbing(boolean pClimbing) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (pClimbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }
        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    public static final RawAnimation WALKING = RawAnimation.begin().thenLoop("animation.scp058.moving");
    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.scp058.idle");
    public static final RawAnimation ATTACK = RawAnimation.begin().thenLoop("animation.scp058.attack");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 3, state -> {
            if (this.swinging) {
                state.getController().setAnimation(ATTACK);
            } else if (!state.isMoving()) {
                state.getController().setAnimation(IDLE);
            } else if (state.isMoving()) {
                state.getController().setAnimation(WALKING);
            }
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
