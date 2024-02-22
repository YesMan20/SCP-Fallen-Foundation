package net.yesman.scpff.level.entity.scp;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.Helper;
import net.yesman.scpff.misc.SCP;
import net.yesman.scpff.networking.ModMessages;
import net.yesman.scpff.networking.packet.S2C.BlinkS2CPacket;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.List;

public class SCP173 extends Monster implements GeoEntity, SCP {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> DATA_MODEL = SynchedEntityData.defineId(SCP173.class, EntityDataSerializers.INT); // Used for SCP-173 rendering.
    public int blink = 0;


    public SCP173(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        ((GroundPathNavigation) this.getNavigation()).setCanOpenDoors(true);
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
        return "The Sculpture";
    }

    @Override
    protected void registerGoals() {
        this.addBehaviourGoals();
        this.setPersistenceRequired();
    }

    protected void addBehaviourGoals() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 100.0f)
                .add(Attributes.ATTACK_DAMAGE, 100.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MAX_HEALTH, 37.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.GRINDSTONE_USE, 0.15f, 1);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controller) {
        controller.add(new AnimationController<>(this, "controller", state -> state.setAndContinue(RawAnimation.begin().then("animation." + this.getModel() + ".idle", Animation.LoopType.LOOP))));
    }


    @Override
    public void tick() {
        super.tick();
        List<ServerPlayer> playersLookingAtMe = new ArrayList<>();

        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(this.blinkRadius()))) {
            if (entity instanceof ServerPlayer player && !player.isCreative()) {

                if (Helper.isInAngle(player, this.blockPosition(), 90) && this.hasLineOfSight(player)) {
                    playersLookingAtMe.add(player);
                }

            }
        }

        for (Entity entity : this.level().getEntities(this, this.getBoundingBox().inflate(this.blinkRadius()))) {
            if (entity instanceof ServerPlayer player && !player.isCreative()) {

                if (!playersLookingAtMe.isEmpty()) {
                    if (this.blink + this.blinkCooldown() < this.tickCount) {
                        this.blink = this.tickCount;
                        this.blinkTowards(player);
                        playersLookingAtMe.forEach(player1 -> {
                            ModMessages.sendToPlayer(new BlinkS2CPacket(this.blinkDuration()), player1);
                        });
                        this.tryToAttack(player, this.distanceToSqr(player));
                    }
                } else {
                    if (this.blink + this.blinkCooldownNoLook() < this.tickCount) {
                        this.blink = this.tickCount;
                        this.blinkTowards(player);
                        this.tryToAttack(player, this.distanceToSqr(player));
                    }
                }

            }
        }


    }

    public void tryToAttack(LivingEntity enemy, double distToEnemySqr) {
        if (enemy.isDeadOrDying()) return;
        if (this.inRange(enemy, distToEnemySqr)) {
            this.doHurtTarget(enemy);
        }
    }

    protected boolean inRange(LivingEntity enemy, double distToEnemySqr) {
        return distToEnemySqr <= this.getBbWidth() * 2.0F * this.getBbWidth() * 2.0F + enemy.getBbWidth();
    }


    public void blinkTowards(Entity entity) {
        if (entity == null) return;
        GroundPathNavigation pathNavigation = (GroundPathNavigation) this.getNavigation();

        Path path = pathNavigation.createPath(entity, 0);
        if (path != null && path.getNodeCount() >= path.getDistToTarget()) {
            this.lookAt(EntityAnchorArgument.Anchor.EYES, entity.position());
            int nodeToTP = Mth.lerpInt((float) Math.min(path.getNodeCount(), 25) / 32, 0, 20);
            Node node = path.getNode(nodeToTP);
            this.teleportTo(node.x, node.y, node.z);
        }

    }

    public int blinkRadius() {
        return 32;
    }

    public int blinkCooldown() {
        return 100;
    }

    public int blinkCooldownNoLook() {
        return 8;
    }

    public int blinkDuration() {
        return 10;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_MODEL, 0);
    }

    public String getModel() {
        return Variants.values()[this.entityData.get(DATA_MODEL)].resourceName;
    }

    public Variants getVariant() {
        return Variants.values()[this.entityData.get(DATA_MODEL)];
    }

    public void setModel(Variants model) {
        this.entityData.set(DATA_MODEL, model.ordinal());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("variant", this.getVariant().ordinal());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("variant")) {
            this.entityData.set(DATA_MODEL, pCompound.getInt("variant"));
        }
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
        SCP_173F("scp173f"),
        SCP_173("scp173"),
        SCP_173U("scp173u"),
        SCP_173V("scp173v"),
        SCP_173R("scp173r"),
        SCP_173B("scp173b");

        public final String resourceName;

        Variants(String resourceName) {
            this.resourceName = resourceName;
        }

    }

    /**
     * damage related stuff
     */

    @Override
    public boolean isFreezing() {
        return false;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    public boolean canFreeze() {
        return false;
    }

    @Override
    public boolean isAffectedByPotions() {
        return false;
    }

    @Override
    protected boolean isAffectedByFluids() {
        return false;
    }

    @Override
    public boolean isPreventingPlayerRest(Player pPlayer) {
        return true;
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    public boolean ignoreExplosion() {
        return true;
    }

    @Override
    public boolean canBeHitByProjectile() {
        return false;
    }

    /*@Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return pSource.is(DamageTypes.IN_WALL)
                || pSource.is(DamageTypes.LAVA)
                || pSource.is(DamageTypes.EXPLOSION)
                || pSource.is(DamageTypes.CACTUS)
                || pSource.is(DamageTypes.FREEZE) && super.hurt(pSource, pAmount);
    }*/
}
