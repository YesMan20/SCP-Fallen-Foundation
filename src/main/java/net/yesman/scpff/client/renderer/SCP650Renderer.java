package net.yesman.scpff.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.client.models.SCP650Model;
import net.yesman.scpff.entity.custom.SCP650;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SCP650Renderer extends GeoEntityRenderer<SCP650> {

    public SCP650Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP650Model());
        this.shadowRadius = 0.5F;
    }

}
