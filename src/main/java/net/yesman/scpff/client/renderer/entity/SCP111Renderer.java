package net.yesman.scpff.client.renderer.entity;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.model.SCP111Model;
import net.yesman.scpff.client.renderer.entity.layers.GlowdrakeGlowLayer;
import net.yesman.scpff.level.entity.scp.SCP111;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class SCP111Renderer extends GeoEntityRenderer<SCP111> {
    public static final Map<SCP111.Variants, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SCP111.Variants.class), (p_114874_) -> {
                p_114874_.put(SCP111.Variants.SLIMYBELLY,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111slimybelly"));
                p_114874_.put(SCP111.Variants.GLOWDRAKE,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111glowdrake"));
                p_114874_.put(SCP111.Variants.GOOWYVERN,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111goowyvern"));
                p_114874_.put(SCP111.Variants.GUNKYVERN,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111gunkyvern"));
                p_114874_.put(SCP111.Variants.OOZEDRAKE,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111oozedrake"));
                p_114874_.put(SCP111.Variants.BLOBWORM,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111blobworm"));
            });

    public SCP111Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP111Model<>());
        this.shadowRadius = 0.5F;
        this.addRenderLayer(new GlowdrakeGlowLayer<>(this));
    }

    @Override
    public void preRender(PoseStack poseStack, SCP111 pEntity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        if (pEntity.isTame() && getGeoModel().getBone("Collar").isPresent()) {
            getGeoModel().getBone("Collar").get().setHidden(false);
        } else if (!pEntity.isTame()) {
            getGeoModel().getBone("Collar").get().setHidden(true);
        }
    }

    @Override
    public void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, SCP111 animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay) {
        super.scaleModelForRender(widthScale, heightScale, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
        if (this.animatable.isSmall() && this.animatable.getVariant().getId() != 2) {
            poseStack.scale(0.8f, 0.8f, 0.8f);
        }
    }
}
