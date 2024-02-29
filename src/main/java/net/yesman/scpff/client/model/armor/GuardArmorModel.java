package net.yesman.scpff.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.item.custom.GuardArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GuardArmorModel extends GeoModel<GuardArmorItem> {
    @Override
    public ResourceLocation getModelResource(GuardArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/armor/guard_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GuardArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/armor/guard_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GuardArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/armor/guard_armor.animation.json");
    }
}
