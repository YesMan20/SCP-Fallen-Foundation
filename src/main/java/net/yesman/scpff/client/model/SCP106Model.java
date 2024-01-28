package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.entity.scp.SCP106;
import software.bernie.geckolib.core.animation.AnimationState;

public class SCP106Model extends RotatedHeadModel<SCP106> {

    @Override
    public ResourceLocation getModelResource(SCP106 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp106.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP106 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp106.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP106 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp106.animation.json");
    }

    @Override
    public void setCustomAnimations(SCP106 animatable, long instanceId, AnimationState<SCP106> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
