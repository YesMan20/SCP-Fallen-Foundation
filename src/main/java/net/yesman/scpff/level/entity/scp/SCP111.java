package net.yesman.scpff.level.entity.scp;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.CatVariantTags;
import net.minecraft.tags.StructureTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.yesman.scpff.events.Registry;
import net.yesman.scpff.level.entity.FFEntitiesRegistry;
import net.yesman.scpff.level.misc.FFSoundsRegistry;
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
    private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(SCP111.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(SCP111.class, EntityDataSerializers.BYTE);
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SCP111(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
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
                .add(Attributes.MOVEMENT_SPEED, 0.9F)
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
        this.goalSelector.addGoal(16, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(18, new FollowMobGoal(this, (float) 1, 10, 5));
        this.goalSelector.addGoal(18, new RandomStrollGoal(this, 1));
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 2));
        this.goalSelector.addGoal(4, new PanicGoal(this, 2));
    }

    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("animation.scp111.idle", Animation.LoopType.LOOP);
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controller) {
        controller.add(new AnimationController<>(this, "Controller", 3, state -> {
            if (!state.isMoving()) {
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
        this.entityData.define(DATA_FLAGS_ID, (byte)0);
        this.entityData.define(DATA_VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("variant", this.getVariant().ordinal());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
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

    /**
     * Variant Stuffs
     */

    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor serverLevelAccessor, @NotNull DifficultyInstance difficultyInstance,
                                        @NotNull MobSpawnType mobSpawnType, @org.jetbrains.annotations.Nullable SpawnGroupData spawnGroupData,
                                        @Nullable CompoundTag compoundTag) {
        SCP111.Variants variant = Util.getRandom(SCP111.Variants.values(), this.random);
        setVariant(variant);
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

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
