package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP106;
import net.yesman.scpff.level.entity.scp.SCP650;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP650Model extends GeoModel<SCP650> {
    @Override
    public ResourceLocation getModelResource(SCP650 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/scp650.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP650 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/scp650.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP650 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp650.png");
    }
}
