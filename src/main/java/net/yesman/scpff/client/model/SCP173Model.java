package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP173;
import software.bernie.geckolib.model.GeoModel;

public class SCP173Model extends GeoModel<SCP173> {
    @Override
    public ResourceLocation getTextureResource(SCP173 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp173/" + animatable.getModel() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP173 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/scp173/" + animatable.getModel() + ".animation.json");
    }
    @Override
    public ResourceLocation getModelResource(SCP173 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/scp173/" + animatable.getModel() + ".geo.json");
    }

}
