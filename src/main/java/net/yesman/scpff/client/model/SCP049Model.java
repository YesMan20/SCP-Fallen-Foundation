package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP049;
import net.yesman.scpff.level.entity.scp.SCP106;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP049Model extends GeoModel<SCP049> {
    @Override
    public ResourceLocation getModelResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/scp049.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/scp049.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp049.png");
    }

    @Override
    public void setCustomAnimations(SCP049 animatable, long instanceId, AnimationState<SCP049> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
