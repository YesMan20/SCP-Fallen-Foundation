package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.level.entity.client.models.SCP058Model;
import net.yesman.scpff.level.entity.custom.SCP058;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP058Renderer extends GeoEntityRenderer<SCP058> {
    public SCP058Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP058Model());
    }
}
