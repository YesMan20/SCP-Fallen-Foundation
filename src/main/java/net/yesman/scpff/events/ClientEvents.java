package net.yesman.scpff.events;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.overlays.BlinkOverlay;
import net.yesman.scpff.level.misc.FFCreativeTabRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ClientEvents {
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            FFCreativeTabRegistry.SCP_BLOCKS.ifPresent(tab -> {
                List<ItemStack> tabItems = new ArrayList<>(FFCreativeTabRegistry.SCP_BLOCKS.get().getDisplayItems().stream().toList());
                if (Minecraft.getInstance().player != null) {
                    // How fast the items are cycled through the tab
                    int tickSpeed = 25;
                    Item nextItem = tabItems.get((int)(Minecraft.getInstance().player.level().getGameTime() / tickSpeed) % tabItems.size()).getItem();
                    tab.iconItemStack = new ItemStack(nextItem);
                }
            });
        } else if (event.phase == TickEvent.Phase.END) return;

        if (BlinkOverlay.currentBlinkTime > 0) {
            BlinkOverlay.currentBlinkTime--;
        }
    }
}
