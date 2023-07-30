package net.yesman.scpff.level.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.level.block.ModBlocks;
import net.yesman.scpff.misc.Helper;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;

public class SCP173 extends Monster implements GeoEntity {
    private int cooldownTick = 0;
    AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<String> DATA_MODEL = SynchedEntityData.defineId(SCP173.class, EntityDataSerializers.STRING); // Used for SCP-173 rendering.

    public SCP173(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.7)
                .add(Attributes.ATTACK_DAMAGE, 100.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MAX_HEALTH, 37.0D);
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.grindstone.use"))), 0.15f, 1);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controller) {
        controller.add(new AnimationController<>(this, "controller", state -> {
            return state.setAndContinue(RawAnimation.begin().then("animation." + this.getModel() + ".idle", Animation.LoopType.LOOP));
        }));
    }

    @Override
    public void tick() {
        if (this.isOnGround()) {
            this.setNoAi(true);
        }
        for (Entity entity : this.level.getEntities(this, this.getBoundingBox().inflate(30), (val) -> val instanceof Player)) {
            if (!this.level.isClientSide && entity instanceof Player player) {
                Entity lookedAt = Helper.lookingAtInRange(player, 10);
                if ((lookedAt != this && player.hasLineOfSight(this) && this.cooldownTick < this.tickCount)) {
                    this.cooldownTick = this.tickCount;
                    this.setNoAi(false);
                }
            }
        }
        if (this.random.nextFloat() > 0.99F) {
            if (this.level.getBlockState(this.blockPosition()).isAir()) {
                this.level.setBlockAndUpdate(this.blockPosition(), ModBlocks.SCP173CRAP.get().defaultBlockState());
            }
        }
        super.tick();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(18, new RandomStrollGoal(this, 1));
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_MODEL, "scp173y");
    }

    public String getModel() {
        return this.entityData.get(DATA_MODEL);
    }

    public Variants getVariant() { // Could be better.
        return Variants.valueOf(Variants.class, this.getModel().toUpperCase().replace("P173", "P_173"));
    }

    public void setModel(Variants model) {
        this.entityData.set(DATA_MODEL, model.resourceName);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putString("variant", this.getModel());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("variant")) {
            this.entityData.set(DATA_MODEL, pCompound.getString("variant"));
        }
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return pSource.is(DamageTypes.OUT_OF_WORLD) && super.hurt(pSource, pAmount);
    }

    @Override
    public boolean canCollideWith(Entity pEntity) {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    public enum Variants {
        SCP_173Y("scp173y"),
        SCP_173("scp173"),
        SCP_173U("scp173u"),
        SCP_173V("scp173v"),
        SCP_173R("scp173r"),
        SCP_173B("scp173b"),
        SCP_173FM("scp173fm"),
        ;

        public final String resourceName;

        Variants(String resourceName) {
            this.resourceName = resourceName;
        }

    }
}
