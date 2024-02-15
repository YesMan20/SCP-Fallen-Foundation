package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.level.entity.ChairEntity;

public class ChairRenderer extends EntityRenderer<ChairEntity> {
    public ChairRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(ChairEntity pEntity) {
        return null;
    }
}
