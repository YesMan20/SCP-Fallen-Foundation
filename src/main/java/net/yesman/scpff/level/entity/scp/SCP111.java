package net.yesman.scpff.level.entity.scp;

import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.event.ForgeEventFactory;
import net.yesman.scpff.level.entity.FFEntitiesRegistry;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.SCP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;
import java.util.Comparator;

public class SCP111 extends TamableAnimal implements GeoEntity, SCP {
    private static final EntityDataAccessor<Boolean> SMALL;
    protected int small;
    private static final EntityDataAccessor<Integer> DATA_DARK_TICKS_REMAINING;
    private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(SCP111.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(SCP111.class, EntityDataSerializers.BYTE);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SCP111(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setTame(false);
    }

    /**
     * Basic Entity Stuff
     */

    @Override
    public Classification getClassification() {
        return Classification.SAFE;
    }

    @Override
    public String getNameId() {
        return "\"Dragon Snails\"";
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3F)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0f)
                .add(Attributes.MAX_HEALTH, 47.0D);
    }

    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(8, new FollowMobGoal(this, (float) 1, 10, 5));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1));
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 10));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new PanicGoal(this, 1));
    }

    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("animation.scp111.idle", Animation.LoopType.LOOP);
    private static final RawAnimation SIT_ANIM = RawAnimation.begin().then("animation.scp111.sitting", Animation.LoopType.LOOP);
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controller) {
        controller.add(new AnimationController<>(this, "Controller", 3, state -> {
            if (this.isInSittingPose()) {
                state.getController().setAnimation(SIT_ANIM);
            } else {
                state.getController().setAnimation(IDLE_ANIM);
            }
            return PlayState.CONTINUE;
        }));
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob pOtherParent) {
        SCP111 scp111 = FFEntitiesRegistry.SCP_111.get().create(serverLevel);
        if (scp111 != null && pOtherParent instanceof SCP111 scp111_1) {
            if (this.random.nextBoolean()) {
                scp111.setVariant(this.getVariant());
            } else {
                scp111.setVariant(scp111_1.getVariant());
            }
        }
        return scp111;
    }

    public void aiStep() {
        super.aiStep();
        int $$0 = this.getDarkTicksRemaining();
        if ($$0 > 0) {
            this.setDarkTicks($$0 - 1);
        }
        if (this.getVariant().id == 2) {
            this.level().addParticle(ParticleTypes.GLOW, this.getRandomX(0.6), this.getRandomY(), this.getRandomZ(0.6), 0.0, 0.0, 0.0);
        }
    }

    public boolean canBeLeashed(@NotNull Player player) {
        return true;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PARROT_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PARROT_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PARROT_DEATH;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SMALL, false);
        this.entityData.define(DATA_DARK_TICKS_REMAINING, 0);
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(DATA_VARIANT, 0);
    }

    private void setDarkTicks(int pDarkTicks) {
        this.entityData.set(DATA_DARK_TICKS_REMAINING, pDarkTicks);
    }

    public int getDarkTicksRemaining() {
        return (Integer)this.entityData.get(DATA_DARK_TICKS_REMAINING);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("variant", this.getVariant().ordinal());
        pCompound.putInt("DarkTicksRemaining", this.getDarkTicksRemaining());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setDarkTicks(pCompound.getInt("DarkTicksRemaining"));
        if (pCompound.contains("variant")) {
            this.entityData.set(DATA_VARIANT, pCompound.getInt("variant"));
        }
    }

    public boolean canMate(Animal pOtherAnimal) {
        if (!this.isTame()) {
            return false;
        } else if (!(pOtherAnimal instanceof SCP111 scp111)) {
            return false;
        } else {
            return scp111.isTame() && super.canMate(pOtherAnimal);
        }
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.level().isClientSide) {
            boolean flag = this.isOwnedBy(pPlayer) || this.isTame() || itemstack.is(Items.WHEAT) && !this.isTame();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (this.isTame()) {
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                this.heal((float)itemstack.getFoodProperties(this).getNutrition());
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                this.gameEvent(GameEvent.EAT, this);
                return InteractionResult.SUCCESS;
            } else {
                InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
                if ((!interactionresult.consumesAction() || this.isBaby()) && this.isOwnedBy(pPlayer)) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    return InteractionResult.SUCCESS;
                } else {
                    return interactionresult;
                }
            }
        } else if (itemstack.is(Items.WHEAT)) {
            if (!pPlayer.getAbilities().instabuild) {
                itemstack.shrink(1);
            }

            if (this.random.nextInt(3) == 0 && !ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                this.tame(pPlayer);
                this.navigation.stop();
                this.setTarget((LivingEntity)null);
                this.setOrderedToSit(true);
                this.level().broadcastEntityEvent(this, (byte)7);
            } else {
                this.level().broadcastEntityEvent(this, (byte)6);
            }

            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(pPlayer, pHand);
        }
    }

    /**
     * Small stuffs :)
     */

    public boolean isSmall() {
        return this.getSmall() < 0;
    }

    public int getSmall() {
        if (this.level().isClientSide) {
            return (Boolean)this.entityData.get(SMALL) ? -1 : 1;
        } else {
            return this.small;
        }
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if (SMALL.equals(pKey)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(pKey);
    }

    public void setSmallThing(int pSmall) {
        int $$1 = this.getSmall();
        this.small = pSmall;
        if ($$1 < 0 && pSmall >= 0 || $$1 >= 0 && pSmall < 0) {
            this.entityData.set(SMALL, pSmall < 0);
        }
    }

    public void setSmall(boolean pSmall) {
        this.setSmallThing(pSmall ? -24000 : 0);
    }

    /**
     * Variant Stuffs
     */

    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance,
                                        @NotNull MobSpawnType mobSpawnType, @org.jetbrains.annotations.Nullable SpawnGroupData spawnGroupData,
                                        @Nullable CompoundTag compoundTag) {
        SCP111.Variants variant = Util.getRandom(SCP111.Variants.values(), this.random);
        setVariant(variant);
        if (RandomSource.create().nextFloat() > 0.7F) {
            setSmall(true);
        }
        return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    public enum Variants {
        SLIMYBELLY(1),
        GLOWDRAKE(2),
        GOOWYVERN(3),
        GUNKYVERN(4),
        OOZEDRAKE(5),
        BLOBWORM(6);

        private static final SCP111.Variants[] BY_ID = Arrays.stream(values()).sorted(Comparator.
                comparingInt(SCP111.Variants::getId)).toArray(SCP111.Variants[]::new);
        private final int id;

        Variants(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }

        public static SCP111.Variants byId(int id) {
            return BY_ID[id % BY_ID.length];
        }
    }

    @NotNull
    public SCP111.Variants getVariant() {
        return SCP111.Variants.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_VARIANT);
    }

    public void setVariant(SCP111.Variants variant) {
        this.entityData.set(DATA_VARIANT, variant.getId() & 255);
    }

    static {
        SMALL = SynchedEntityData.defineId(SCP111.class, EntityDataSerializers.BOOLEAN);
        DATA_DARK_TICKS_REMAINING = SynchedEntityData.defineId(SCP111.class, EntityDataSerializers.INT);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
