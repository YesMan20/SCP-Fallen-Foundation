package net.yesman.scpff.level.entity.custom;

import net.minecraft.world.entity.EntityType;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SCP035WitherSkeleton implements GeoReplacedEntity {
    public final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    @Override
    public EntityType<?> getReplacingEntityType() {
        return EntityType.PLAYER;
    }

    public static final RawAnimation WALKING = RawAnimation.begin().thenLoop("animation.witherskeleton.moving");
    public static final RawAnimation ATTACKING = RawAnimation.begin().thenPlay("animation.witherskeleton.attack");

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.witherskeleton.idle");
    public static final RawAnimation CROUCH = RawAnimation.begin().thenLoop("animation.witherskeleton.crouching");

    public static final RawAnimation CROUCH_WALKING = RawAnimation.begin().thenLoop("animation.witherskeleton.crouching_moving");

    public static final RawAnimation SITTING = RawAnimation.begin().thenLoop("animation.witherskeleton.sitting");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, state -> {
            if (state.getData(DataTickets.ENTITY).getVehicle() != null) {
                state.setAndContinue(SITTING);
                return PlayState.CONTINUE;
            }
            if (state.isMoving()) {
                state.setAndContinue(state.getData(DataTickets.ENTITY).isCrouching() ? CROUCH_WALKING : WALKING);
            } else {
                state.setAndContinue(state.getData(DataTickets.ENTITY).isCrouching() ? CROUCH : IDLE);
            }
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
