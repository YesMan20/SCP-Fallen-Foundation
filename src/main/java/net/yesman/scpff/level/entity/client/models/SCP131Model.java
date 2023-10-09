package net.yesman.scpff.level.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP131;

public class SCP131Model extends RotatedHeadModel<SCP131> {

    @Override
    public ResourceLocation getModelResource(SCP131 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp131.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP131 object) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp131/" + object.getModel() + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP131 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp131.animation.json");
    }

}
