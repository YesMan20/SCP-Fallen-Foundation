package net.yesman.scpff.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.overlays.BlinkOverlay;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) return;

        if (BlinkOverlay.currentBlinkTime > 0) {
            BlinkOverlay.currentBlinkTime--;
        }

    }

}
