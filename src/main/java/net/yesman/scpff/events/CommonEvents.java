package net.yesman.scpff.events;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.entity.custom.SCP049;
import net.yesman.scpff.level.entity.custom.SCP650;
import net.yesman.scpff.level.item.ModItems;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {


    @SubscribeEvent
    public static void changeTarget(LivingChangeTargetEvent event) {
        if (event.getNewTarget() == null || event.getEntity() == null) return;
        if (event.getNewTarget().getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SCP268.get()) {
            event.setCanceled(true);
        }
    }

}
