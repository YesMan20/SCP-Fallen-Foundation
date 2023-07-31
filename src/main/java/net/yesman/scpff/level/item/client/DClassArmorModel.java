package net.yesman.scpff.level.item.client;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.item.custom.DClassArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class DClassArmorModel extends GeoModel<DClassArmorItem> {
    @Override
    public ResourceLocation getModelResource(DClassArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/armor/dclass_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DClassArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/armor/dclass_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DClassArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/dclass_armor.animation.json");
    }
}
