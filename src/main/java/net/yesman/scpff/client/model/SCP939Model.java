package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.entity.scp.SCP939;
import software.bernie.geckolib.model.GeoModel;

public class SCP939Model extends GeoModel<SCP939> {
    @Override
    public ResourceLocation getModelResource(SCP939 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp939.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP939 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp939.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP939 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp939.animation.json");
    }
}
