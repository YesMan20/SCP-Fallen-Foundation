package net.yesman.scpff;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.level.block.ModBlocks;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.item.ModItems;
import net.yesman.scpff.level.item.custom.IgnoreOnLoad;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SCPFf.MOD_ID)
public class SCPFf
{
    public static final String MOD_ID = "scpff";
    public static final Logger LOGGER = LogUtils.getLogger();
    public SCPFf()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntity.MOD_ENTITES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerItemTab);
        modEventBus.addListener(this::registerBlockTab);
        modEventBus.addListener(this::registerEggTab);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    public void registerItemTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(SCPFf.MOD_ID, "scpfftab_item"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ITEMICON.get()))
                        .title(Component.translatable("creativemodetab.scpff_item"))
                        .displayItems((enabledFeatures, entries) -> {

                            for (RegistryObject<Item> key : ModItems.ITEMS.getEntries()) {
                                if (!(key.get() instanceof IgnoreOnLoad || key.get() instanceof ForgeSpawnEggItem || key.get() instanceof BlockItem)) {
                                    entries.accept(key.get());
                                }
                            }

                        }));
    }

    public void registerBlockTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(SCPFf.MOD_ID, "scpfftab_block"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BLOCKICON.get()))
                        .title(Component.translatable("creativemodetab.scpff_block"))
                        .displayItems((enabledFeatures, entries) -> {

                            for (RegistryObject<Block> key : ModBlocks.BLOCKS.getEntries()) {
                                entries.accept(key.get());
                            }

                        }));
    }

    public void registerEggTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(SCPFf.MOD_ID, "scpfftab_scps"),
                builder -> builder.icon(() -> new ItemStack(ModItems.SCPICON.get()))
                        .title(Component.translatable("creativemodetab.scpff_scps"))
                        .displayItems((enabledFeatures, entries) -> {


                            for (RegistryObject<Item> key : ModItems.ITEMS.getEntries()) {
                                if (key.get() instanceof ForgeSpawnEggItem) {
                                    entries.accept(key.get());
                                }
                            }

                        }));
    }

}
