package net.yesman.scpff.level.item.client;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.item.scps.SCP268ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class SCP268Model extends GeoModel<SCP268ArmorItem> {
    @Override
    public ResourceLocation getModelResource(SCP268ArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/scp268.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP268ArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/armor/scp268.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP268ArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp268.animation.json");
    }
}
