package net.yesman.scpff.level.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.eventbus.api.BusBuilder;
import net.minecraftforge.registries.ForgeRegistries;
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
import software.bernie.geckolib.util.GeckoLibUtil;

public class SCP939 extends Monster implements GeoEntity {
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

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.ambient"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.death"));
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
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Animal.class, true, true));
        this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Player.class, true, true));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal(this, Villager.class, true, true));
        this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, IronGolem.class, true, true));
        this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, WanderingTrader.class, true, true));
        this.targetSelector.addGoal(10, new NearestAttackableTargetGoal(this, Piglin.class, true, true));
        this.targetSelector.addGoal(11, new NearestAttackableTargetGoal(this, ZombifiedPiglin.class, true, true));
    }

    public static void init() {
        SpawnPlacements.register(ModEntity.SCP_939.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            return false;
        });
        DungeonHooks.addDungeonMob(ModEntity.SCP_939.get(), 180);
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
