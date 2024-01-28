package net.yesman.scpff.events;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.renderer.block.ContainmentCaseRenderer;
import net.yesman.scpff.client.renderer.entity.*;
import net.yesman.scpff.server.block.entity.FFBlockEntitiesRegistry;
import net.yesman.scpff.server.entity.FFEntitiesRegistry;
import net.yesman.scpff.client.model.armor.SCP035Model;
import net.yesman.scpff.client.model.armor.SCP268Model;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_650.get(), SCP650Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_049.get(), SCP049Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_939.get(), SCP939Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_173.get(), SCP173Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_1507.get(), SCP1507Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_058.get(), SCP058Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_2521.get(), SCP2521Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_106.get(), SCP106Renderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.SCP_131.get(), SCP131Renderer::new);
        event.registerEntityRenderer(EntityType.PLAYER, SCP035WitherSkeletonRenderer::new);
        event.registerEntityRenderer(FFEntitiesRegistry.CHAIR.get(), ChairRenderer::new);

        event.registerBlockEntityRenderer(FFBlockEntitiesRegistry.CONTAINMENT_BLOCK.get(), ContainmentCaseRenderer::new);
    }

    @SubscribeEvent
    public static void entityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SCP035Model.LAYER_LOCATION, SCP035Model::createBodyLayer);
        event.registerLayerDefinition(SCP268Model.LAYER_LOCATION, SCP268Model::createBodyLayer);
    }
}
