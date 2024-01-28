package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.entity.scp.SCP035WitherSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class SCP035WitherSkeletonModel extends GeoModel<SCP035WitherSkeleton> {
    @Override
    public ResourceLocation getModelResource(SCP035WitherSkeleton animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/wither_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP035WitherSkeleton animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/wither_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP035WitherSkeleton animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/wither_skeleton.animation.json");
    }

}
