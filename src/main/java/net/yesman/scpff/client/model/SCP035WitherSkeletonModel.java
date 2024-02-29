package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP035WitherSkeleton;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP035WitherSkeletonModel extends DefaultedEntityGeoModel<SCP035WitherSkeleton> {
    public SCP035WitherSkeletonModel() {
        super(new ResourceLocation(SCPFf.MOD_ID, "wither_skeleton"), true);
    }
}
