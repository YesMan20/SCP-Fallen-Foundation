package net.yesman.scpff.level.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.monster.warden.WardenAi;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.eventbus.api.BusBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.misc.RunnableCooldownHandler;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class SCP939 extends Monster implements GeoEntity {
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(SCP939.class, EntityDataSerializers.BYTE);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Boolean> DATA_HAS_TARGET = SynchedEntityData.defineId(SCP939.class, EntityDataSerializers.BOOLEAN);

    public SCP939(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MAX_HEALTH, 37.0D);
    }

    @Override
    public void checkDespawn() {

    }

    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    /** Blindness **/

    /** Climbing **/

    public boolean onClimbable() {
        return this.isClimbing();
    }

    protected PathNavigation createNavigation(Level pLevel) {
        return new WallClimberNavigation(this, pLevel);
    }

    public double getPassengersRidingOffset() {
        return (double)(this.getBbHeight() * 0.5F);
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

    public void tick() {
        super.tick();
        if (!this.level.isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
        for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(20, 20, 20))) {
            if (entity instanceof Mob mob) {
                if (RandomSource.create().nextFloat() > 0.99F) {
                    try {
                        Method ambientSound = Mob.class.getDeclaredMethod("getAmbientSound");
                        ambientSound.setAccessible(true);

                        SoundEvent ambientSoundEvent = (SoundEvent) ambientSound.invoke(mob);
                        if (ambientSoundEvent != null) {
                            this.playSound(ambientSoundEvent);
                        }
                    } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                        SCPFf.LOGGER.error("Could not fetch sound \n {}", e.getMessage());
                    }
                }
            }
        }
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.pig.death"));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(13, new BreakDoorGoal(this, e -> true));
        this.goalSelector.addGoal(14, new RandomSwimmingGoal(this, 1, 40));
        this.goalSelector.addGoal(16, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(18, new FollowMobGoal(this, (float) 1, 10, 5));
        this.goalSelector.addGoal(18, new RandomStrollGoal(this, 1));
        this.targetSelector.addGoal(17, new HurtByTargetGoal(this).setAlertOthers());
        this.targetSelector.addGoal(17, new RestrictSunGoal(this));
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
        this.targetSelector.addGoal(2, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Animal.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, WanderingTrader.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Piglin.class, true, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, ZombifiedPiglin.class, true, true));
    }

    private static final RawAnimation ATTACK_ANIM = RawAnimation.begin().then("animation.scp939.attack", Animation.LoopType.PLAY_ONCE);
    private static final RawAnimation CHASE_ANIM = RawAnimation.begin().then("animation.scp939.aggresive", Animation.LoopType.LOOP);
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("animation.scp939.idle", Animation.LoopType.LOOP);
    private static final RawAnimation WALK_ANIM = RawAnimation.begin().then("animation.scp939.moving", Animation.LoopType.LOOP);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controller) {
        controller.add(new AnimationController<>(this, "Controller", 0, state -> {
             if (this.swinging) {
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

    @Override
    public void setTarget(@Nullable LivingEntity pTarget) {
        super.setTarget(pTarget);
        this.setHasTarget(pTarget != null);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_HAS_TARGET, false);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
    }

    public boolean hasTarget() {
        return this.entityData.get(DATA_HAS_TARGET);
    }

    public void setHasTarget(boolean hasTarget) {
        this.entityData.set(DATA_HAS_TARGET, hasTarget);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
