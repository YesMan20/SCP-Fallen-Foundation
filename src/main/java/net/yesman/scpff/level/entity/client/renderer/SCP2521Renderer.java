package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.level.entity.client.models.SCP058Model;
import net.yesman.scpff.level.entity.client.models.SCP2521Model;
import net.yesman.scpff.level.entity.custom.SCP058;
import net.yesman.scpff.level.entity.custom.SCP2521;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP2521Renderer extends GeoEntityRenderer<SCP2521> {
    public SCP2521Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP2521Model());
    }
}
