package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.renderer.entity.SCP111Renderer;
import net.yesman.scpff.level.entity.scp.SCP111;
import net.yesman.scpff.level.entity.scp.SCP131;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SCP131Model extends DefaultedEntityGeoModel<SCP131> {
    public SCP131Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp131"), true);
    }

    @Override
    public ResourceLocation getTextureResource(SCP131 animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp131/" + animatable.getModel() + ".png");
    }
}
