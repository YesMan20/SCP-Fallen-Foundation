package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.client.model.SCP173Model;
import net.yesman.scpff.server.entity.scp.SCP173;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP173Renderer extends GeoEntityRenderer<SCP173> {

    public SCP173Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP173Model());
        this.shadowRadius = 0.5F;
    }

}
