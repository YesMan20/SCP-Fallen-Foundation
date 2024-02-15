package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP1507;


public class SCP1507Model extends RotatedHeadModel<SCP1507> {

    @Override
    public ResourceLocation getModelResource(SCP1507 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp1507.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP1507 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp1507.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP1507 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp1507.animation.json");
    }

}
