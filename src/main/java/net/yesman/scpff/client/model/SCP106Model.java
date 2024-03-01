package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP106;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP106Model extends GeoModel<SCP106> {
    @Override
    public ResourceLocation getModelResource(SCP106 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/scp106.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP106 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/scp106.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP106 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp106.png");
    }

    @Override
    public void setCustomAnimations(SCP106 animatable, long instanceId, AnimationState<SCP106> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
