package net.yesman.scpff.server.item.client;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.item.custom.ResearcherArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class ResearcherArmorModel extends GeoModel<ResearcherArmorItem> {
    @Override
    public ResourceLocation getModelResource(ResearcherArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/armor/researcher_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ResearcherArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/armor/researcher_suit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ResearcherArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/researcher_suit.animation.json");
    }
}
