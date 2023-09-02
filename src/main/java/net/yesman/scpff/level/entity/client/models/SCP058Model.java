package net.yesman.scpff.level.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP058;
import software.bernie.geckolib.model.DefaultedGeoModel;
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
