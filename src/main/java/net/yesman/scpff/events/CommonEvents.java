package net.yesman.scpff.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.entity.custom.SCP049;
import net.yesman.scpff.level.entity.custom.SCP650;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonEvents {

    @SubscribeEvent
    public static void entityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntity.SCP_650.get(), SCP650.createAttributes().build());
        event.put(ModEntity.SCP_049.get(), SCP049.createAttributes().build());
    }

}
