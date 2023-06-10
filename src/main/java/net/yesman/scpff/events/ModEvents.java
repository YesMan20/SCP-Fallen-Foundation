package net.yesman.scpff.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP049;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSource().getEntity() instanceof SCP049 scp049 && scp049.level instanceof ServerLevel serverLevel) {
                scp049.Cure(serverLevel, player);
            }
        }
    }
}
