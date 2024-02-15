package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.client.model.SCP2521Model;
import net.yesman.scpff.level.entity.scp.SCP2521;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP2521Renderer extends GeoEntityRenderer<SCP2521> {
    public SCP2521Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP2521Model());
    }
}
