package net.yesman.scpff.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP111;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class GlowdrakeGlowLayer<T extends SCP111> extends GeoRenderLayer<T> {
    private static final RenderType GLOWDRAKE_GLOW = RenderType.eyes(new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111glowdrake_glowmask.png"));
    private static final RenderType EMPTY = RenderType.eyes(new ResourceLocation(SCPFf.MOD_ID, "textures/misc/empty.png"));
    public GlowdrakeGlowLayer(GeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    protected RenderType getRenderType(T animatable) {
        if (animatable.getVariant().getId() == 2) {
            return GLOWDRAKE_GLOW;
        }
        return EMPTY;
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType emissiveRenderType = getRenderType(animatable);

        getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveRenderType,
                bufferSource.getBuffer(emissiveRenderType), partialTick, 15728640, OverlayTexture.NO_OVERLAY,
                1, 1, 1, 1);
    }
}
