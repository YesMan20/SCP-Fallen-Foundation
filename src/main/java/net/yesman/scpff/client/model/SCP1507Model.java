package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP1507;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP1507Model extends DefaultedEntityGeoModel<SCP1507> {
    public SCP1507Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp1507"), true);
    }
}
