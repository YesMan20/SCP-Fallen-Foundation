package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.level.entity.client.models.SCP131Model;
import net.yesman.scpff.level.entity.custom.SCP131;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP131Renderer extends GeoEntityRenderer<SCP131> {

    public SCP131Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP131Model());
        this.shadowRadius = 0.5F;
    }

}
