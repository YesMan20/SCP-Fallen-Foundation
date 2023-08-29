package net.yesman.scpff.events;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.ModBlocks;
import net.yesman.scpff.level.block.client.ContainmentCaseRenderer;
import net.yesman.scpff.level.block.entity.ModBlockEntities;
import net.yesman.scpff.level.entity.client.renderer.*;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.entity.custom.SCP1507;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntity.SCP_650.get(), SCP650Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_049.get(), SCP049Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_939.get(), SCP939Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_173.get(), SCP173Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_1507.get(), SCP1507Renderer::new);
        event.registerEntityRenderer(EntityType.PLAYER, SCP035WitherSkeletonRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.CONTAINMENT_BLOCK.get(), ContainmentCaseRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CONTAINMENT_CASE.get(), RenderType.cutout()); // TODO deprecated
    }

}
