package net.yesman.scpff.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.yesman.scpff.client.renderer.entity.SCP035WitherSkeletonRenderer;
import net.yesman.scpff.server.item.FFItemsRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity> {

    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/world/entity/LivingEntity;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", cancellable = true)
    public void render(T pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight, CallbackInfo ci) {
        if (!(pEntity instanceof AbstractClientPlayer clientPlayer)) {
            return;
        }
        if (clientPlayer.getHealth() <= clientPlayer.getMaxHealth() / 1.5F && clientPlayer.getItemBySlot(EquipmentSlot.HEAD).is(FFItemsRegistry.SCP035.get())) {
            SCP035WitherSkeletonRenderer renderer = this.getGeckoRenderer();
            if (renderer == null) {
                return;
            }
            renderer.render(clientPlayer, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
            ci.cancel();
        }
    }

    public SCP035WitherSkeletonRenderer getGeckoRenderer() {
        EntityRenderDispatcher entityRenderDispatcher = Minecraft.getInstance().getEntityRenderDispatcher();
        EntityRenderer<?> entityRenderer = ((EntityRenderDispatcherAccessor) entityRenderDispatcher).getRenderers().get(EntityType.PLAYER);

        if (!(entityRenderer instanceof SCP035WitherSkeletonRenderer SCP035WitherSkeletonRenderer)) {
            return null;
        }

        return SCP035WitherSkeletonRenderer;
    }

}
