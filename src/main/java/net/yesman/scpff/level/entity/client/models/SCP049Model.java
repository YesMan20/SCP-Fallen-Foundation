package net.yesman.scpff.level.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP049;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class SCP049Model extends RotatedHeadModel<SCP049> {

    @Override
    public ResourceLocation getModelResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp049.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp049.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp049.animation.json");
    }

    @Override
    public void setCustomAnimations(SCP049 animatable, long instanceId, AnimationState<SCP049> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
