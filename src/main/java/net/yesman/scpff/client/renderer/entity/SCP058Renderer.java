package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.client.model.SCP058Model;
import net.yesman.scpff.level.entity.scp.SCP058;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP058Renderer extends GeoEntityRenderer<SCP058> {
    public SCP058Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP058Model());
    }
}
