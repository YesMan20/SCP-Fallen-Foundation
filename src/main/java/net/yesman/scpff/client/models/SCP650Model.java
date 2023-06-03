package net.yesman.scpff.client.models;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.entity.custom.SCP650;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SCP650Model extends AnimatedGeoModel<SCP650> {

    @Override
    public ResourceLocation getModelResource(SCP650 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp650.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP650 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp650.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP650 animatable) {
        return null;
    }
}
