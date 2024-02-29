package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP939;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP939Model extends DefaultedEntityGeoModel<SCP939> {
    public SCP939Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp939"), true);
    }
}
