package net.yesman.scpff.level.entity.client.models;

import net.minecraft.util.Mth;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public abstract class RotatedHeadModel<E extends GeoEntity> extends GeoModel<E> {

    @Override
    public void setCustomAnimations(E animatable, long instanceId, AnimationState<E> animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("Head");
        EntityModelData modelData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        if (head != null) {
            head.setRotY(head.getRotY() + modelData.netHeadYaw() * Mth.DEG_TO_RAD);
            head.setRotX(head.getRotX() + modelData.headPitch() * Mth.DEG_TO_RAD);
        }
    }

}
