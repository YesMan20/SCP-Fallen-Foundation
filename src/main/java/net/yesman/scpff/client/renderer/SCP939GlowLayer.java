package net.yesman.scpff.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP111;
import net.yesman.scpff.level.entity.scp.SCP939;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class SCP939GlowLayer<T extends SCP939> extends GeoRenderLayer<T> {
    private static final RenderType SCP939_GLOW = RenderType.eyes(new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp939_glowmask.png"));
    public SCP939GlowLayer(GeoRenderer<T> entityRendererIn) {
        super(entityRendererIn);
    }

    protected RenderType getRenderType(T animatable) {
        return SCP939_GLOW;
    }

    @Override
    public void render(PoseStack poseStack, T animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType emissiveRenderType = getRenderType(animatable);

        getRenderer().reRender(bakedModel, poseStack, bufferSource, animatable, emissiveRenderType,
                bufferSource.getBuffer(emissiveRenderType), partialTick, 15728640, OverlayTexture.NO_OVERLAY,
                1, 1, 1, 1);
    }
}
