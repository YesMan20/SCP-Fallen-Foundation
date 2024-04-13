package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP2521;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP2521Model extends DefaultedEntityGeoModel<SCP2521> {
    public SCP2521Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp2521"));
    }
}
