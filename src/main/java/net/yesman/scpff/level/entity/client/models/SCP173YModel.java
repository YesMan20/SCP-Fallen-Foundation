package net.yesman.scpff.level.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP173;
import software.bernie.geckolib.model.GeoModel;

public class SCP173YModel extends GeoModel<SCP173> {

    @Override
    public ResourceLocation getModelResource(SCP173 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp173/scp173y.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP173 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp173/scp173y.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP173 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp173/scp173y.animation.json");
    }
}
