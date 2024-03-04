package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP035WitherSkeleton;
import net.yesman.scpff.level.entity.scp.SCP106;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP035WitherSkeletonModel extends DefaultedEntityGeoModel<SCP035WitherSkeleton> {
    public SCP035WitherSkeletonModel() {
        super(new ResourceLocation(SCPFf.MOD_ID, "wither_skeleton"), true);
    }
}
