package net.yesman.scpff.level.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TurtleEggBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.decor.*;
import net.yesman.scpff.level.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SCPFf.MOD_ID);

    /** HC Blocks **/

    public static final RegistryObject<Block> HCWALL = registerBlock("hcwall",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCFLOOR = registerBlock("hcfloor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METALWALL1 = registerBlock("metalwall1",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METALWALL2 = registerBlock("metalwall2",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRICKWALL1 = registerBlock("brickwall1",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRICKWALL2 = registerBlock("brickwall2",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRICKWALL3 = registerBlock("brickwall3",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    /** EZ Blocks **/

    public static final RegistryObject<Block> EZWALL1 = registerBlock("ezwall1",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EZWALL2 = registerBlock("ezwall2",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TILES = registerBlock("tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()));

    /** LC Blocks **/

    public static final RegistryObject<Block> LCWALL1 = registerBlock("lcwall1",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LCWALL2 = registerBlock("lcwall2",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> LCWALL3 = registerBlock("lcwall3",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .explosionResistance(1.8f)
                    .strength(1.8f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    /** Decor Blocks **/

    public static final RegistryObject<Block> PIPECORNER = registerBlock("pipecorner",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .explosionResistance(1.8f)
                    .strength(2f)
                    .destroyTime(9f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> COMPUTER = registerBlock("computer",
            () -> new ComputerBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> CATWALKFENCE = registerBlock("catwalkfence",
            () -> new CatWalkFenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> FILECABINET = registerBlock("filecabinet",
            () -> new FileCabinetBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1.8f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .destroyTime(9f)));

    public static final RegistryObject<Block> CATWALKFENCE2 = registerBlock("catwalkfence2",
            () -> new CatWalkFence2Block(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> CATWALKBLOCK = registerBlock("catwalkblock",
            () -> new CatWalkBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> FLOODLIGHTS = registerBlock("floodlights",
            () -> new FloodLightsBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .lightLevel(s -> 15)
                    .strength(1f)
                    .noOcclusion()));

    public static final RegistryObject<Block> WALLLIGHT = registerBlock("walllight",
            () -> new WallLightBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .lightLevel(s -> 15)
                    .strength(4f)
                    .noOcclusion()));

    public static final RegistryObject<Block> CHAIR = registerBlock("chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f)
                    .noOcclusion()));

    public static final RegistryObject<Block> WIRES = registerBlock("wires",
            () -> new WiresBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()));

    public static final RegistryObject<Block> WIRES_LEFT = registerBlock("wires_left",
            () -> new WiresLeftBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()));

    public static final RegistryObject<Block> WIRES_RIGHT = registerBlock("wires_right",
            () -> new WiresRightBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()));

    public static final RegistryObject<Block> WIRES_THREEWAY = registerBlock("wires_threeway",
            () -> new WiresThreewayBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()));

    public static final RegistryObject<Block> STEELCANISTER = registerBlock("steelcanister",
            () -> new SteelCanisterBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> MICROSCOPE = registerBlock("microscope",
            () -> new MicroscopeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> SCALE = registerBlock("scale",
            () -> new ScaleBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> TESTTUBES = registerBlock("testtubes",
            () -> new TestTubesBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> BEAKERS = registerBlock("beakers",
            () -> new BeakersBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> WIRES_THREEWAY2 = registerBlock("wires_threeway2",
            () -> new WiresThreeway2Block(BlockBehaviour.Properties.of(Material.WOOL)
                    .strength(1f)
                    .sound(SoundType.WOOL)
                    .noOcclusion()));

    public static final RegistryObject<Block> CRATE = registerBlock("crate",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> SERVERSRACK = registerBlock("serversrack",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> LOCKER = registerBlock("locker",
            () -> new LockerBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final RegistryObject<Block> PAPERSTACK = registerBlock("paperstack",
            () -> new PaperStackBlock(BlockBehaviour.Properties.of(Material.WOOL)
                    .sound(SoundType.WOOL)
                    .strength(1f)
                    .noOcclusion()));

    public static final RegistryObject<Block> PIPE = registerBlock("pipe",
            () -> new PipeBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(3f)
                    .noOcclusion()));

    public static final RegistryObject<Block> PIPESIDE = registerBlock("pipeside",
            () -> new PipeSideBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(3f)
                    .noOcclusion()));

    public static final RegistryObject<Block> DESKLAMP = registerBlock("desklamp",
            () -> new DeskLampBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .lightLevel(s -> 12)
                    .sound(SoundType.METAL)
                    .strength(1f)
                    .noOcclusion()));

    public static final RegistryObject<Block> TRASHBIN = registerBlock("trashbin",
            () -> new TrashBinBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .strength(1f)
                    .noOcclusion()));

    public static final RegistryObject<Block> FIREEXTINGUISHERCASE = registerBlock("fireextinguishercase",
            () -> new FireExtinguisherCaseBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(6f)
                    .noOcclusion()));

    public static final RegistryObject<Block> ELECTRICALBOX = registerBlock("electricalbox",
            () -> new ElectricalBoxBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .strength(6f)
                    .noOcclusion()));

    public static final RegistryObject<Block> VENDINGMACHINE = registerBlock("vendingmachine",
            () -> new VendingMachineBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .lightLevel(s -> 4)
                    .strength(6f)
                    .noOcclusion()));

    public static final RegistryObject<Block> BULLETINBOARD = registerBlock("bulletinboard",
            () -> new BulletinBoardBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .requiresCorrectToolForDrops()
                    .strength(2f)
                    .noOcclusion()));

    public static final RegistryObject<Block> SAFELABEL = registerBlock("safelabel",
            () -> new SafeLabelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    public static final RegistryObject<Block> KETERLABEL = registerBlock("keterlabel",
            () -> new EuclidLabelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    public static final RegistryObject<Block> EUCLIDLABEL = registerBlock("euclidlabel",
            () -> new EuclidLabelBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2f)
                    .requiresCorrectToolForDrops()
                    .noOcclusion()));

    /** MISC Blocks **/

    public static final RegistryObject<Block> CAUTIONLINE = registerBlock("cautionline",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOL)
                    .sound(SoundType.WOOL)
                    .destroyTime(1.2f)
                    .explosionResistance(0.8f)
                    .strength(0.8f)));

    public static final RegistryObject<Block> FACILITYLIGHT = registerBlock("facilitylight",
            () -> new Block(BlockBehaviour.Properties.of(Material.GLASS)
                    .lightLevel(s -> 15)
                    .sound(SoundType.GLASS)
                    .destroyTime(1.2f)
                    .explosionResistance(0.8f)
                    .requiresCorrectToolForDrops()
                    .strength(0.8f)));

    public static final RegistryObject<Block> REINFORCEDIRON = registerBlock("reinforcediron",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .sound(SoundType.METAL)
                    .destroyTime(50f)
                    .explosionResistance(1299f)
                    .requiresCorrectToolForDrops()
                    .strength(50f)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
