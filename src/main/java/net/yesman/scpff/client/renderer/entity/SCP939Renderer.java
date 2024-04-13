package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.client.model.SCP939Model;
import net.yesman.scpff.client.renderer.entity.layers.SCP939GlowLayer;
import net.yesman.scpff.level.entity.scp.SCP939;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP939Renderer extends GeoEntityRenderer<SCP939> {

    public SCP939Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP939Model());
        this.shadowRadius = 0.5F;
        this.addRenderLayer(new SCP939GlowLayer<>(this));
    }
}
