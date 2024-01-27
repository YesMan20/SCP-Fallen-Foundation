package net.yesman.scpff.server.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.server.entity.client.models.SCP1507Model;
import net.yesman.scpff.server.entity.scp.SCP1507;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP1507Renderer extends GeoEntityRenderer<SCP1507> {

    public SCP1507Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP1507Model());
        this.shadowRadius = 0.5F;
    }

}
