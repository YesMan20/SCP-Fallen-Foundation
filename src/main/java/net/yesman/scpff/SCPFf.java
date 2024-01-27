package net.yesman.scpff;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.yesman.scpff.server.config.FFServerConfigsRegistry;
import net.yesman.scpff.server.block.FFBlocksRegistry;
import net.yesman.scpff.server.block.entity.FFBlockEntitiesRegistry;
import net.yesman.scpff.server.entity.FFEntitiesRegistry;
import net.yesman.scpff.server.entity.init.EntityInit;
import net.yesman.scpff.server.item.FFItemsRegistry;
import net.yesman.scpff.server.misc.FFCreativeTabRegistry;
import net.yesman.scpff.server.painting.FFPaintingsRegistry;
import net.yesman.scpff.server.sound.FFSoundsRegistry;
import net.yesman.scpff.networking.ModMessages;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SCPFf.MOD_ID)
public class SCPFf {
    public static final String MOD_ID = "scpff";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SCPFf() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FFItemsRegistry.register(modEventBus);
        FFBlocksRegistry.register(modEventBus);
        FFPaintingsRegistry.register(modEventBus);
        FFBlockEntitiesRegistry.register(modEventBus);
        FFEntitiesRegistry.MOD_ENTITES.register(modEventBus);
        FFCreativeTabRegistry.CREATIVE_TABS.register(modEventBus);

        FFSoundsRegistry.register(modEventBus);

        EntityInit.init();

        modEventBus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, FFServerConfigsRegistry.SPEC, "scpff-server.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModMessages::register);
    }

}
