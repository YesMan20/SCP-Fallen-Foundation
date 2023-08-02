package net.yesman.scpff.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.client.renderer.*;
import net.yesman.scpff.level.entity.ModEntity;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntity.SCP_650.get(), SCP650Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_049.get(), SCP049Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_939.get(), SCP939Renderer::new);
        event.registerEntityRenderer(ModEntity.SCP_173.get(), SCP173Renderer::new);
    }
}
