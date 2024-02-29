package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP049;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP049Model extends DefaultedEntityGeoModel<SCP049> {
    public SCP049Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp049"), true);
    }
}
