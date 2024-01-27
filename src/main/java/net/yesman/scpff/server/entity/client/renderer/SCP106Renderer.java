package net.yesman.scpff.server.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.server.entity.client.models.SCP106Model;
import net.yesman.scpff.server.entity.scp.SCP106;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP106Renderer extends GeoEntityRenderer<SCP106> {

    public SCP106Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP106Model());
        this.shadowRadius = 0.5F;
    }

}
