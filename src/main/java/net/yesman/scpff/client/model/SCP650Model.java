package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP650;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP650Model extends DefaultedEntityGeoModel<SCP650> {
    public SCP650Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp650"), true);
    }
}
