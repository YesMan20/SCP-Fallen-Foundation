package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.yesman.scpff.level.entity.client.models.SCP049Model;
import net.yesman.scpff.level.entity.client.models.SCP1507Model;
import net.yesman.scpff.level.entity.custom.SCP049;
import net.yesman.scpff.level.entity.custom.SCP1507;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SCP1507Renderer extends GeoEntityRenderer<SCP1507> {

    public SCP1507Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP1507Model());
        this.shadowRadius = 0.5F;
    }

}
