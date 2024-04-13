package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP106;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP106Model extends DefaultedEntityGeoModel<SCP106> {
    public SCP106Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp106"), true);
    }
}
