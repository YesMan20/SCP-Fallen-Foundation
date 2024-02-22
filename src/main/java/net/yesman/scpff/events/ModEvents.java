package net.yesman.scpff.events;

import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.scp.SCP049;
import net.yesman.scpff.level.item.FFItemsRegistry;
import net.yesman.scpff.level.misc.FFParticlesRegistry;
import net.yesman.scpff.level.misc.SCP173SmokeParticles;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (event.getSource().getEntity() instanceof SCP049 scp049 && scp049.level() instanceof ServerLevel serverLevel) {
                scp049.Cure(serverLevel, player);
            }
        }
    }
    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Pre event) {
        Player player = event.getEntity();
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == FFItemsRegistry.SCP268.get()) {
            event.setCanceled(true);
            player.setInvisible(true);
        } else if (!player.hasEffect(MobEffects.INVISIBILITY)){
            player.setInvisible(false);
        }
    }

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(FFParticlesRegistry.SCP173SMOKE_PARTICLES.get(),
                SCP173SmokeParticles.Provider::new);
    }
}
