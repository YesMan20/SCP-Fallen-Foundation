package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP058;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP058Model extends DefaultedEntityGeoModel<SCP058> {
    public SCP058Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp058"), true);
    }
}
