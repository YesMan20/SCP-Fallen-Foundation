package net.yesman.scpff.level.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP049;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SCP049Model extends AnimatedGeoModel<SCP049> {

    @Override
    public ResourceLocation getModelResource(SCP049 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp049.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP049 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp049.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP049 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp049.animation.json");
    }
}
