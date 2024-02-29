package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP131;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP131Model extends DefaultedEntityGeoModel<SCP131> {
    public SCP131Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp131"), true);
    }

    @Override
    public ResourceLocation getTextureResource(SCP131 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp131/" + animatable.getModel() + ".png");
    }
}
