package net.yesman.scpff.events;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.data.PlayerData;
import net.yesman.scpff.data.client.GeneralClientData;
import net.yesman.scpff.level.entity.custom.SCP2521;
import net.yesman.scpff.level.item.ModItems;
import net.yesman.scpff.level.item.custom.WeightedArmorItem;
import net.yesman.scpff.misc.*;
import net.yesman.scpff.networking.ModMessages;
import net.yesman.scpff.networking.packet.S2C.EnableMovementPacketS2CPacket;

import java.util.HashMap;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEvents {

    public static HashMap<Player, PlayerData> PlayerRuntimeData = new HashMap<>();
    public static SCP2521 active2521 = null;

    @SubscribeEvent
    public static void changeTarget(LivingChangeTargetEvent event) {
        if (event.getNewTarget() == null || event.getEntity() == null) return;
        if (event.getNewTarget().getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.SCP268.get()) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void chatEvent(ServerChatEvent event) {
        if (event.getPlayer() == null) return;
        ServerPlayer player = event.getPlayer();
        PlayerData data = PlayerData.getData(player);
        if (data.in2521Event()) {
            event.setCanceled(true);
            return;
        }
        if (!player.isCreative() && SCP2521.has2521InString(event.getRawText())) {
            BlockPos summonPos = BlockPos.containing(player.getEyePosition().add(Helper.calculateViewVector(player.getXRot(), player.getYRot()).scale(-1)));
            new SCP2521.SCP2521Event(summonPos, player.level, player, () -> {
                ModMessages.sendToPlayer(new EnableMovementPacketS2CPacket(false), player);
                RunnableCooldownHandler.addDelayedRunnable(() -> {
                    ModMessages.sendToPlayer(new EnableMovementPacketS2CPacket(true), player);
                    player.kill();
                }, 100);
            });
        }
    }

    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof ServerPlayer serverPlayer) {
            checkFor2521(serverPlayer, serverPlayer.getItemInHand(InteractionHand.MAIN_HAND));
            checkFor2521(serverPlayer, serverPlayer.getItemInHand(InteractionHand.OFF_HAND));
        }
    }

    @SubscribeEvent
    public static void pickupItem(PlayerEvent.ItemPickupEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            checkFor2521(serverPlayer, event.getStack());
        }
    }

    private static void checkFor2521(ServerPlayer serverPlayer, ItemStack stack) {
        if (stack.isEmpty() || serverPlayer.isCreative()) return;
        PlayerData data = PlayerData.getData(serverPlayer);
        if (stack.hasCustomHoverName() && !data.in2521Event()) {
            if (SCP2521.has2521InString(stack.getHoverName().toString())) {
                data.updateData();
                new SCP2521.SCP2521Event(null, serverPlayer.level, serverPlayer, () -> {
                    ModMessages.sendToPlayer(new EnableMovementPacketS2CPacket(false), serverPlayer);
                    RunnableCooldownHandler.addDelayedRunnable(() -> {
                        ModMessages.sendToPlayer(new EnableMovementPacketS2CPacket(true), serverPlayer);
                        stack.shrink(stack.getCount());
                    }, 100);
                });
            }
        }
    }

    @SubscribeEvent
    public static void playerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity().level.isClientSide) return;
        PlayerData data = PlayerData.getData(event.getEntity());
        data.player = (ServerPlayer) event.getEntity();
        data.updateData();
    }

    @SubscribeEvent
    public static void clientDisconnect(ClientPlayerNetworkEvent.LoggingOut event) {
        GeneralClientData.canMove = true;
        GeneralClientData.in2521Event = false;
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
