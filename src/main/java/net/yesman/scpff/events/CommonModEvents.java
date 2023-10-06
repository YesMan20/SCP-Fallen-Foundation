package net.yesman.scpff.events;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.entity.custom.*;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void entityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntity.SCP_650.get(), SCP650.createAttributes().build());
        event.put(ModEntity.SCP_049.get(), SCP049.createAttributes().build());
        event.put(ModEntity.SCP_939.get(), SCP939.createAttributes().build());
        event.put(ModEntity.SCP_173.get(), SCP173.createAttributes().build());
        event.put(ModEntity.SCP_1507.get(), SCP1507.createAttributes().build());
        event.put(ModEntity.SCP_058.get(), SCP058.createAttributes().build()); // TODO custom attributes
        event.put(ModEntity.SCP_2521.get(), SCP2521.createMobAttributes().build());
    }

}
