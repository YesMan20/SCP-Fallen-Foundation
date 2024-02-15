package net.yesman.scpff.level.entity.scp;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.events.CommonEvents;
import net.yesman.scpff.level.entity.FFEntitiesRegistry;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.Helper;
import net.yesman.scpff.misc.SCP;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SCP2521 extends Monster implements GeoEntity, SCP {
    public final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SCP2521(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    /**
     * Basic Entity Stuff
     */

    public static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.scp2521.idle");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, 0, state -> state.setAndContinue(IDLE)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public Classification getClassification() {
        return Classification.KETER;
    }

    @Override
    public String getNameId() {
        return "●●|●●●●●|●●|●";
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        return pSource.is(DamageTypes.FELL_OUT_OF_WORLD) && super.hurt(pSource, pAmount);
    }

    /**
     * Entity Main Mechanic
     */

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount >= 1000) this.discard();
    }

    public static boolean has2521InString(String s) {
        String base = s.replace(" ", "").replaceAll("[^a-zA-Z0-9]", "");
        String letters = base.replaceAll("[^a-zA-Z]", "");
        String nums = base.replaceAll("[^0-9]", "");
        return base.contains("2521") || letters.contains("twofivetwoone") || base.contains("twofivetwoone") || nums.contains("2521");
    }

    /**
     * Creates an SCP-2521 event. <br>
     * For SCP-2521 to spawn, there needs to be either a summonPos or a player specified.
     *
     * @param summonPos Where SCP-2521 will spawn.
     * @param level Level where SCP-2521 will spawn in.
     * @param player If specified, it will spawn behind the player.
     * @param runnable What to execute when SCP-2521 spawns. - Note: SCP-2521 automatically spawns.
     */
    public record SCP2521Event(@Nullable BlockPos summonPos, Level level, @Nullable Player player,Runnable runnable) {
        public SCP2521Event(@Nullable BlockPos summonPos, Level level, @Nullable Player player,Runnable runnable) {
            this.summonPos = summonPos;
            this.level = level;
            this.runnable = runnable;
            this.player = player;
            SCP2521EventHandler.eventQueue.add(this);
        }
    }

    @Mod.EventBusSubscriber(modid = SCPFf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    private static class SCP2521EventHandler {

        private static final List<SCP2521Event> eventQueue = new ArrayList<>();
        private static int localCounter = 0;

        @SubscribeEvent
        public static void serverTick(TickEvent.ServerTickEvent event) {
            if (event.phase.equals(TickEvent.Phase.END)) return;
            if (eventQueue.isEmpty()) {
                return;
            }
            localCounter++;
            SCP2521Event event1 = eventQueue.get(0);
            if (event1.player == null && event1.summonPos == null) {
                CommonEvents.active2521.discard();
                CommonEvents.active2521 = null;
                localCounter = 0;
                eventQueue.remove(0);
                return;
            }
            if (CommonEvents.active2521 == null) {
                BlockPos summonPos = event1.player == null ? event1.summonPos : BlockPos.containing(event1.player.getEyePosition().add(Helper.calculateViewVector(0, event1.player.getYRot()).scale(-1)));
                SCP2521 scp2521 = new SCP2521(FFEntitiesRegistry.SCP_2521.get(), event1.level);
                scp2521.teleportTo(summonPos.getX(), summonPos.getY(), summonPos.getZ());
                event1.level.addFreshEntity(scp2521);
                scp2521.lookAt(EntityAnchorArgument.Anchor.EYES, event1.player == null ? summonPos.getCenter() : event1.player.getEyePosition());
                CommonEvents.active2521 = scp2521;
            }
            event1.runnable.run();
            if (localCounter >= 100) {
                eventQueue.remove(0);
                CommonEvents.active2521.discard();
                CommonEvents.active2521 = null;
                localCounter = 0;
            }
        }

        @SubscribeEvent
        public static void serverShutdown(ServerStoppingEvent event) {
            if (CommonEvents.active2521 != null) {
                CommonEvents.active2521.discard();
            }
        }

    }

}
