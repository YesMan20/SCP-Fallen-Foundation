package net.yesman.scpff.misc;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.yesman.scpff.SCPFf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RunnableCooldownHandler { // Thank you, Connor!

    private static final Map<Runnable, Integer> RUNNABLE_TICK_MAP = new ConcurrentHashMap<>();

    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {
        if (event.phase.equals(TickEvent.Phase.END)) return;
        Iterator<Map.Entry<Runnable, Integer>> iterator = RUNNABLE_TICK_MAP.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Runnable, Integer> entry = iterator.next();
            Runnable runnable = entry.getKey();

            if (entry.getValue() == 0) {
                try {
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                iterator.remove();
                continue;
            }

            RUNNABLE_TICK_MAP.put(runnable, entry.getValue() - 1);
        }
    }

    /**
     * Do note, since this depends on a delay to call, not all methods that are in the runnable is gaurenteed to exist
     * once the runnable executes. <br>
     * This is intended to run on the server, or when on client on the logical server side, world.isClientSide doesn't
     * have to be checked <br><br>
     * NOTE: If the server closes before the event executes, the event will not occur and not reload when the server
     * loads, there is no way to save the runnable data unless we dumb it down a lot.
     */
    public static void addDelayedRunnable(Runnable runnable, int delayInTicks) {
        if (FMLEnvironment.dist.isDedicatedServer() || Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            RUNNABLE_TICK_MAP.put(runnable, delayInTicks);
        }
    }

    /**
     * When a Dedicated server stops, clear the runnable map to avoid issues
     */
    @SubscribeEvent
    public static void serverStopped(ServerStoppedEvent event) {
        clear();
    }

    /**
     * Could cause some issues with multiple dimensions, but at least server side specifically it will be ok
     */
    @SubscribeEvent
    public static void worldChange(LevelEvent.Unload event) {
        clear();
    }

    /**
     * Used to clear the map when disconnecting/closing client/server it to avoid multiple errors
     */
    private static void clear() {
        RUNNABLE_TICK_MAP.clear();
    }
}