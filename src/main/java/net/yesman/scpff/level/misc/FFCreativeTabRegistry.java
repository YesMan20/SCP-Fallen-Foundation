package net.yesman.scpff.level.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.FFBlocksRegistry;
import net.yesman.scpff.level.item.FFItemsRegistry;

public class FFCreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SCPFf.MOD_ID);

    private static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }

    public static final RegistryObject<CreativeModeTab> SCP_SPAWN_EGGS = CREATIVE_TABS.register("scpff_scps", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.scpff_scps"))
            .icon(() -> new ItemStack(FFItemsRegistry.SCPICON.get()))
            .displayItems((parameters, output) -> {
                output.accept(FFBlocksRegistry.SCP106CORROSION.get());
                output.accept(FFBlocksRegistry.SCP106CORROSIONLAYER.get());
                output.accept(FFBlocksRegistry.SCP173CRAP.get());
                output.accept(FFItemsRegistry.SCP_131_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_049_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_173_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_650_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_1507_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_058_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_106_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP_939_SPAWN_EGG.get());
                output.accept(FFItemsRegistry.SCP207.get());
                output.accept(FFItemsRegistry.SCP500.get());
                output.accept(FFItemsRegistry.SCP1023ARC.get());
                output.accept(FFItemsRegistry.SCP1025.get());
                output.accept(FFItemsRegistry.SCP109.get());
                output.accept(FFItemsRegistry.SCP268.get());
                output.accept(FFItemsRegistry.SCP035.get());
                output.accept(FFBlocksRegistry.SCP_330.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> SCP_BLOCKS = CREATIVE_TABS.register("scpff_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.scpff_blocks"))
            .icon(() -> new ItemStack(FFItemsRegistry.BLOCKICON.get()))
            .displayItems((parameters, output) -> {
                output.accept(FFBlocksRegistry.BRICKWALL1.get());
                output.accept(FFBlocksRegistry.BRICKWALL2.get());
                output.accept(FFBlocksRegistry.BRICKWALL3.get());
                output.accept(FFBlocksRegistry.EZWALL1.get());
                output.accept(FFBlocksRegistry.EZWALL2.get());
                output.accept(FFBlocksRegistry.LCWALL1.get());
                output.accept(FFBlocksRegistry.LCWALL2.get());
                output.accept(FFBlocksRegistry.LCWALL3.get());
                output.accept(FFBlocksRegistry.HCWALL.get());
                output.accept(FFBlocksRegistry.HCWALL_STAIRS.get());
                output.accept(FFBlocksRegistry.HCWALL_SLAB.get());
                output.accept(FFBlocksRegistry.HCFLOOR.get());
                output.accept(FFBlocksRegistry.HCFLOOR_STAIRS.get());
                output.accept(FFBlocksRegistry.HCFLOOR_SLAB.get());
                output.accept(FFBlocksRegistry.TILES.get());
                output.accept(FFBlocksRegistry.TILE_STAIRS.get());
                output.accept(FFBlocksRegistry.TILE_SLAB.get());
                output.accept(FFBlocksRegistry.METALDOOR.get());
                output.accept(FFBlocksRegistry.FACILITYLIGHT.get());
                output.accept(FFBlocksRegistry.MIRROR.get());
                output.accept(FFBlocksRegistry.REINFORCEDIRON.get());
                output.accept(FFBlocksRegistry.WHITE_CONCRETE_STAIRS.get());
                output.accept(FFBlocksRegistry.WHITE_CONCRETE_SLAB.get());
                output.accept(FFBlocksRegistry.GRAY_CONCRETE_STAIRS.get());
                output.accept(FFBlocksRegistry.GRAY_CONCRETE_SLAB.get());
                output.accept(FFBlocksRegistry.METALWALL1.get());
                output.accept(FFBlocksRegistry.METALWALL2.get());
                output.accept(FFBlocksRegistry.CAUTIONLINE.get());
                output.accept(FFBlocksRegistry.CAUTIONLINE_STAIRS.get());
                output.accept(FFBlocksRegistry.CAUTIONLINE_SLAB.get());
                output.accept(FFBlocksRegistry.VENTBLOCK.get());
                output.accept(FFBlocksRegistry.VENT_COVER.get());
                output.accept(FFBlocksRegistry.PIPE.get());
                output.accept(FFBlocksRegistry.PIPESIDE.get());
                output.accept(FFBlocksRegistry.PIPECORNER.get());
                output.accept(FFBlocksRegistry.FILECABINET.get());
                output.accept(FFBlocksRegistry.LOCKER.get());
                output.accept(FFBlocksRegistry.COMPUTER.get());
                output.accept(FFBlocksRegistry.CHAIR.get());
                output.accept(FFBlocksRegistry.DESKLAMP.get());
                output.accept(FFBlocksRegistry.PAPERSTACK.get());
                output.accept(FFBlocksRegistry.PAPER.get());
                output.accept(FFBlocksRegistry.TRASHBIN.get());
                output.accept(FFBlocksRegistry.BULLETINBOARD.get());
                output.accept(FFBlocksRegistry.CATWALKBLOCK.get());
                output.accept(FFBlocksRegistry.CATWALKSTAIRS.get());
                output.accept(FFBlocksRegistry.CATWALKFENCE.get());
                output.accept(FFBlocksRegistry.CATWALKFENCE2.get());
                output.accept(FFBlocksRegistry.FLOODLIGHTS.get());
                output.accept(FFBlocksRegistry.WALLLIGHT.get());
                output.accept(FFBlocksRegistry.MICROSCOPE.get());
                output.accept(FFBlocksRegistry.SCALE.get());
                output.accept(FFBlocksRegistry.TESTTUBES.get());
                output.accept(FFBlocksRegistry.BEAKERS.get());
                output.accept(FFBlocksRegistry.CRATE.get());
                output.accept(FFBlocksRegistry.SERVERSRACK.get());
                output.accept(FFBlocksRegistry.INTERCOMMICROPHONE.get());
                output.accept(FFBlocksRegistry.INTERCOMSPEAKER.get());
                output.accept(FFBlocksRegistry.FIREEXTINGUISHERCASE.get());
                output.accept(FFBlocksRegistry.ELECTRICALBOX.get());
                output.accept(FFBlocksRegistry.VENDINGMACHINE.get());
                output.accept(FFBlocksRegistry.VENDINGMACHINETWO.get());
                output.accept(FFBlocksRegistry.SAFELABEL.get());
                output.accept(FFBlocksRegistry.EUCLIDLABEL.get());
                output.accept(FFBlocksRegistry.KETERLABEL.get());
                output.accept(FFBlocksRegistry.TRUSSBEAM.get());
                output.accept(FFBlocksRegistry.TRUSSBEAM_FENCE.get());
                output.accept(FFBlocksRegistry.CONTAINMENT_CASE_BOTTOM.get());
                output.accept(FFBlocksRegistry.CONTAINMENT_CASE.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> SCP_ARMOR = CREATIVE_TABS.register("scpff_armory", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.scpff_armory"))
            .icon(() -> new ItemStack(FFItemsRegistry.ARMORYICON.get()))
            .displayItems((parameters, output) -> {
                output.accept(FFItemsRegistry.DCLASS_ARMOR_BOOTS.get());
                output.accept(FFItemsRegistry.DCLASS_ARMOR_LEGGINGS.get());
                output.accept(FFItemsRegistry.DCLASS_ARMOR_CHESTPLATE.get());
                output.accept(FFItemsRegistry.RESEARCHER_ARMOR_BOOTS.get());
                output.accept(FFItemsRegistry.RESEARCHER_ARMOR_LEGGINGS.get());
                output.accept(FFItemsRegistry.RESEARCHER_ARMOR_CHESTPLATE.get());
                output.accept(FFItemsRegistry.GUARD_ARMOR_BOOTS.get());
                output.accept(FFItemsRegistry.GUARD_ARMOR_LEGGINGS.get());
                output.accept(FFItemsRegistry.GUARD_ARMOR_CHESTPLATE.get());
                output.accept(FFItemsRegistry.GUARD_ARMOR_HELMET.get());
                output.accept(FFItemsRegistry.NTF_ARMOR_BOOTS.get());
                output.accept(FFItemsRegistry.NTF_ARMOR_LEGGINGS.get());
                output.accept(FFItemsRegistry.NTF_ARMOR_CHESTPLATE.get());
                output.accept(FFItemsRegistry.NTF_ARMOR_HELMET.get());
            }).build());

    public static final RegistryObject<CreativeModeTab> SCP_ITEMS = CREATIVE_TABS.register("scpff_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativemodetab.scpff_items"))
            .icon(() -> new ItemStack(FFItemsRegistry.ITEMICON.get()))
            .displayItems((parameters, output) -> {
                output.accept(FFItemsRegistry.KEYCARD1.get());
                output.accept(FFItemsRegistry.KEYCARD2.get());
                output.accept(FFItemsRegistry.KEYCARD3.get());
                output.accept(FFItemsRegistry.KEYCARD4.get());
                output.accept(FFItemsRegistry.KEYCARD5.get());
                output.accept(FFItemsRegistry.CANDY1.get());
                output.accept(FFItemsRegistry.CANDY2.get());
                output.accept(FFItemsRegistry.CANDY3.get());
                output.accept(FFItemsRegistry.CANDY4.get());
                output.accept(FFItemsRegistry.MOP.get());
                output.accept(FFItemsRegistry.SLEDGEHAMMER.get());
                output.accept(FFItemsRegistry.MEDKIT.get());
                output.accept(FFItemsRegistry.SCP500PILLBOTTLE.get());
                output.accept(FFItemsRegistry.SCP939SPINE.get());
                output.accept(FFItemsRegistry.SCP939DAGGER.get());
            }).build());

}
