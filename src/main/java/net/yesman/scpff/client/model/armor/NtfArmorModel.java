package net.yesman.scpff.client.model.armor;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.item.custom.NtfArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class NtfArmorModel extends GeoModel<NtfArmorItem> {
    @Override
    public ResourceLocation getModelResource(NtfArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/armor/ntf_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NtfArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/armor/ntf_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NtfArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/armor/ntf_armor.animation.json");
    }
}
