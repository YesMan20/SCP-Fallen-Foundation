package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.entity.scp.SCP173;
import software.bernie.geckolib.model.GeoModel;

public class SCP173Model extends GeoModel<SCP173> {

    @Override
    public ResourceLocation getModelResource(SCP173 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp173/" + object.getModel() + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP173 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp173/" + object.getModel() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP173 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp173/" + animatable.getModel() + ".animation.json");
    }

}
