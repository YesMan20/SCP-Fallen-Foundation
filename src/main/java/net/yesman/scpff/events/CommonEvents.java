package net.yesman.scpff.events;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.entity.custom.SCP035WitherSkeleton;
import net.yesman.scpff.level.item.ModItems;
import net.yesman.scpff.level.item.custom.WeightedArmorItem;
import net.yesman.scpff.misc.*;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {

    @SubscribeEvent
    public static void changeTarget(LivingChangeTargetEvent event) {
        if (event.getNewTarget() == null || event.getEntity() == null) return;
        if (event.getNewTarget().getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SCP268.get()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void toolTip(ItemTooltipEvent event) {
        Item item = event.getItemStack().getItem();

        // Object classes
        if (item.getClass().isAnnotationPresent(Safe.class)) {
            event.getToolTip().add(Component.literal("§aSafe"));

        } else if (item.getClass().isAnnotationPresent(Euclid.class)) {
            event.getToolTip().add(Component.literal("§6Euclid"));

        } else if (item.getClass().isAnnotationPresent(Keter.class)) {
            event.getToolTip().add(Component.literal("§cKeter"));
        }

        // Weighted armor
        if (item instanceof WeightedArmorItem) {
            event.getToolTip().add(Component.literal("§9+" + WeightedArmorItem.weight + " Weight"));
        }
    }
}
