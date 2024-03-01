package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.renderer.entity.SCP111Renderer;
import net.yesman.scpff.level.entity.scp.SCP058;
import net.yesman.scpff.level.entity.scp.SCP111;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP111Model extends GeoModel<SCP111> {
    @Override
    public ResourceLocation getModelResource(SCP111 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/scp111.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP111 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/scp111.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP111 animatable) {
        return new ResourceLocation(SCP111Renderer.LOCATION_BY_VARIANT.get(animatable.getVariant()) + ".png");
    }

    @Override
    public void setCustomAnimations(SCP111 animatable, long instanceId, AnimationState<SCP111> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
