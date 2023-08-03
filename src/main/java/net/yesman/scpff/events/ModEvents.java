package net.yesman.scpff.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP049;
import net.yesman.scpff.level.item.ModItems;

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
    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Pre event) {
        Player player = event.getEntity();
        if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SCP268.get()) {
            event.setCanceled(true);
            player.setInvisible(true);
        } else if (!player.hasEffect(MobEffects.INVISIBILITY)){
            player.setInvisible(false);
        }
    }
}
