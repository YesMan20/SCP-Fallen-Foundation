package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP106;
import net.yesman.scpff.level.entity.scp.SCP2521;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP2521Model extends GeoModel<SCP2521> {
    @Override
    public ResourceLocation getModelResource(SCP2521 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/entity/scp2521.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP2521 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/entity/scp2521.animation.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP2521 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp2521.png");
    }
}
