package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP650;
import software.bernie.geckolib.model.GeoModel;

public class SCP650Model extends GeoModel<SCP650> {

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
