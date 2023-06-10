package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.level.entity.client.models.SCP049Model;
import net.yesman.scpff.level.entity.custom.SCP049;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SCP049Renderer extends GeoEntityRenderer<SCP049> {

    public SCP049Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP049Model());
        this.shadowRadius = 0.5F;
    }

}
