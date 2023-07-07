package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.level.entity.client.models.SCP939Model;
import net.yesman.scpff.level.entity.custom.SCP939;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP939Renderer extends GeoEntityRenderer<SCP939> {

    public SCP939Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP939Model());
        this.shadowRadius = 0.5F;
    }
}
