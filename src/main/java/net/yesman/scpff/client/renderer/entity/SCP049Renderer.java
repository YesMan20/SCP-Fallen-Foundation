package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.client.model.SCP049Model;
import net.yesman.scpff.level.entity.scp.SCP049;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP049Renderer extends GeoEntityRenderer<SCP049> {

    public SCP049Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP049Model());
        this.shadowRadius = 0.5F;
    }

}
