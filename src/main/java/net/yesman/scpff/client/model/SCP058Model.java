package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.entity.scp.SCP058;
import software.bernie.geckolib.model.GeoModel;

public class SCP058Model extends GeoModel<SCP058> {
    @Override
    public ResourceLocation getModelResource(SCP058 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp058.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP058 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp058.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP058 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp058.animation.json");
    }
}
