package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP035WitherSkeleton;
import net.yesman.scpff.level.entity.scp.SCP106;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP035WitherSkeletonModel extends GeoModel<SCP035WitherSkeleton> {
    @Override
    public ResourceLocation getModelResource(SCP035WitherSkeleton animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/wither_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP035WitherSkeleton animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/wither_skeleton.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP035WitherSkeleton animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/wither_skeleton.png");
    }

    @Override
    public void setCustomAnimations(SCP035WitherSkeleton animatable, long instanceId, AnimationState<SCP035WitherSkeleton> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
