package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP2521;

public class SCP2521Model extends RotatedHeadModel<SCP2521> {
    @Override
    public ResourceLocation getModelResource(SCP2521 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp2521.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP2521 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp2521.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP2521 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp2521.animation.json");
    }
}
