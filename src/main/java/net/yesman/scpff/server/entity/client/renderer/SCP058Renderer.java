package net.yesman.scpff.server.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.server.entity.client.models.SCP058Model;
import net.yesman.scpff.server.entity.scp.SCP058;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP058Renderer extends GeoEntityRenderer<SCP058> {
    public SCP058Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP058Model());
    }
}
