package net.yesman.scpff.level.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.decor.ContainmentCase;
import net.yesman.scpff.level.block.decor.*;
import net.yesman.scpff.level.block.scp.SCP330Block;
import net.yesman.scpff.level.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SCPFf.MOD_ID);


    /** HC Blocks **/
    public static final RegistryObject<Block> HCWALL = registerBlock("hcwall", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCWALL_STAIRS = registerBlock("hcwall_stairs", () ->
            new StairBlock(() -> ModBlocks.HCWALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCWALL_SLAB = registerBlock("hcwall_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCFLOOR = registerBlock("hcfloor", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCFLOOR_SLAB = registerBlock("hcfloor_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCFLOOR_STAIRS = registerBlock("hcfloor_stairs", () ->
            new StairBlock(() -> ModBlocks.HCFLOOR.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METALWALL1 = registerBlock("metalwall1", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METALWALL2 = registerBlock("metalwall2", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRICKWALL1 = registerBlock("brickwall1", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRICKWALL2 = registerBlock("brickwall2", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BRICKWALL3 = registerBlock("brickwall3", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));


    /** EZ Blocks **/
    public static final RegistryObject<Block> EZWALL1 = registerBlock("ezwall1", () ->
            new TooltipBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops(), "§8§oCan be used with White Concrete"));

    public static final RegistryObject<Block> EZWALL2 = registerBlock("ezwall2", () ->
            new TooltipBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops(), "§8§oCan be used with White Concrete"));

    public static final RegistryObject<Block> TILES = registerBlock("tiles", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TILE_SLAB = registerBlock("tile_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TILE_STAIRS = registerBlock("tile_stairs", () ->
            new StairBlock(() -> ModBlocks.TILES.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE).strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WHITE_CONCRETE_STAIRS = registerBlock("whiteconcretestairs", () ->
            new StairBlock(Blocks.WHITE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> WHITE_CONCRETE_SLAB = registerBlock("whiteconcreteslab", () ->
            new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GRAY_CONCRETE_STAIRS = registerBlock("grayconcretestairs", () ->
            new StairBlock(Blocks.GRAY_CONCRETE::defaultBlockState, BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GRAY_CONCRETE_SLAB = registerBlock("grayconcreteslab", () ->
            new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).destroyTime(9f).requiresCorrectToolForDrops()));

    /** LC Blocks **/
    public static final RegistryObject<Block> LCWALL1 = registerBlock("lcwall1", () ->
            new TooltipBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).requiresCorrectToolForDrops(), "§8§oCan be used with White Concrete"));

    public static final RegistryObject<Block> LCWALL2 = registerBlock("lcwall2", () ->
            new TooltipBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8f).strength(1.8f).requiresCorrectToolForDrops(), "§8§oCan be used with White Concrete"));

    public static final RegistryObject<Block> LCWALL3 = registerBlock("lcwall3", () ->
            new TooltipBlock(BlockBehaviour.Properties.of(Material.STONE).explosionResistance(1.8F).strength(1.8F).requiresCorrectToolForDrops(), "§8§oCan be used with White Concrete"));


    /** Decoration Blocks **/

    public static final RegistryObject<Block> VENTBLOCK = registerBlock("ventblock", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8F).strength(2F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> VENT_COVER = registerBlock("vent_cover", () ->
            new TrapDoorBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL).noOcclusion().strength(2F).explosionResistance(1.8F).requiresCorrectToolForDrops(), BlockSetType.IRON));

    public static final RegistryObject<Block> PIPECORNER = registerBlock("pipecorner", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).explosionResistance(1.8F).strength(2F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> FILECABINET = registerBlock("filecabinet", () ->
            new FileCabinetBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.8F).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> COMPUTER = registerBlock("computer", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.COMPUTER_S, BlockShapes.COMPUTER_N, BlockShapes.COMPUTER_E, BlockShapes.COMPUTER_W));

    public static final RegistryObject<Block> CATWALKFENCE = registerBlock("catwalkfence", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(4F).noOcclusion(),
                    BlockShapes.CAT_WALK_FENCE_S, BlockShapes.CAT_WALK_FENCE_N, BlockShapes.CAT_WALK_FENCE_E, BlockShapes.CAT_WALK_FENCE_W));

    public static final RegistryObject<Block> CATWALKFENCE2 = registerBlock("catwalkfence2", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(4F).noOcclusion(),
                    BlockShapes.CAT_WALK_FENCE_S, BlockShapes.CAT_WALK_FENCE_N, BlockShapes.CAT_WALK_FENCE_E, BlockShapes.CAT_WALK_FENCE_W));

    public static final RegistryObject<Block> CATWALKSTAIRS = registerBlock("catwalkstairs", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(4F).noOcclusion(),
                    BlockShapes.CAT_WALK_STAIRS_N, BlockShapes.CAT_WALK_STAIRS_E, BlockShapes.CAT_WALK_STAIRS_S, BlockShapes.CAT_WALK_STAIRS_W));


    public static final RegistryObject<Block> CATWALKBLOCK = registerBlock("catwalkblock", () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(4F).noOcclusion(),
                    BlockShapes.CAT_WALK_BLOCK));

    public static final RegistryObject<Block> FLOODLIGHTS = registerBlock("floodlights", () ->
            new FloodLightsBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).lightLevel((s) -> s.getValue(BlockStateProperties.LIT) ? 15 : 0).strength(1F).noOcclusion()));

    public static final RegistryObject<Block> WALLLIGHT = registerBlock("walllight", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().lightLevel(s -> 15).strength(4f).noOcclusion(),
                    BlockShapes.WALL_LIGHT_BLOCK));

    public static final RegistryObject<Block> CHAIR = registerBlock("chair", () ->
            new ChairBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1F).noOcclusion()));

    public static final RegistryObject<Block> WIRES = registerBlock("wires", () ->
            new WireBlock(BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET));

    public static final RegistryObject<Block> WIRES_LEFT = registerBlock("wires_left", () ->
            new WireBlock(BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET));

    public static final RegistryObject<Block> WIRES_RIGHT = registerBlock("wires_right", () ->
            new WireBlock(BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET));

    public static final RegistryObject<Block> WIRES_THREEWAY = registerBlock("wires_threeway", () ->
            new WireBlock(BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET));

    public static final RegistryObject<Block> WIRES_THREEWAY2 = registerBlock("wires_threeway2", () ->
            new WireBlock(BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET, BlockShapes.CARPET));

    public static final RegistryObject<Block> STEELCANISTER = registerBlock("steelcanister", () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3F).sound(SoundType.METAL).noOcclusion(),
                    BlockShapes.STEEL_CANISTER));

    public static final RegistryObject<Block> MICROSCOPE = registerBlock("microscope", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.MICROSCOPE_S, BlockShapes.MICROSCOPE_N, BlockShapes.MICROSCOPE_E, BlockShapes.MICROSCOPE_W));

    public static final RegistryObject<Block> SCALE = registerBlock("scale", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.5F).sound(SoundType.METAL).noOcclusion(),
                    BlockShapes.SCALE_S, BlockShapes.SCALE_N, BlockShapes.SCALE_E, BlockShapes.SCALE_W));

    public static final RegistryObject<Block> TESTTUBES = registerBlock("testtubes", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.5F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.TEST_TUBES_S, BlockShapes.TEST_TUBES_N, BlockShapes.TEST_TUBES_E, BlockShapes.TEST_TUBES_W));

    public static final RegistryObject<Block> BEAKERS = registerBlock("beakers", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1.5F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.BEAKERS, BlockShapes.BEAKERS, BlockShapes.BEAKERS, BlockShapes.BEAKERS));

    public static final RegistryObject<Block> CRATE = registerBlock("crate", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> SERVERSRACK = registerBlock("serversrack", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.BLOCK, BlockShapes.BLOCK, BlockShapes.BLOCK, BlockShapes.BLOCK));

    public static final RegistryObject<Block> LOCKER = registerBlock("locker", () ->
            new LockerBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4F).sound(SoundType.METAL).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> INTERCOMMICROPHONE = registerBlock("intercommicrophone", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1f).sound(SoundType.METAL).noOcclusion(),
                    BlockShapes.INTERCOM_MICROPHONE_S, BlockShapes.INTERCOM_MICROPHONE_N, BlockShapes.INTERCOM_MICROPHONE_E, BlockShapes.INTERCOM_MICROPHONE_W));

    public static final RegistryObject<Block> INTERCOMSPEAKER = registerBlock("intercomspeaker", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).strength(1f).sound(SoundType.METAL).noOcclusion(),
                    BlockShapes.INTERCOM_SPEAKER_S, BlockShapes.INTERCOM_SPEAKER_N, BlockShapes.INTERCOM_SPEAKER_E, BlockShapes.INTERCOM_SPEAKER_W));

    public static final RegistryObject<Block> PAPERSTACK = registerBlock("paperstack", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(1F).noOcclusion(),
                    BlockShapes.PAPER_STACK_S, BlockShapes.PAPER_STACK_N, BlockShapes.PAPER_STACK_E, BlockShapes.PAPER_STACK_W));

    public static final RegistryObject<Block> PIPE = registerBlock("pipe", () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(3F).noOcclusion(),
                    BlockShapes.PIPE));

    public static final RegistryObject<Block> PIPESIDE = registerBlock("pipeside", () ->
            new PipeSideBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(3F).noOcclusion()));

    public static final RegistryObject<Block> DESKLAMP = registerBlock("desklamp", () ->
            new LampBlock(BlockBehaviour.Properties.of(Material.METAL).lightLevel((s) -> s.getValue(BlockStateProperties.LIT) ? 15 : 0).sound(SoundType.METAL).strength(1F).noOcclusion(),
                    BlockShapes.DESK_LAMP_S, BlockShapes.DESK_LAMP_N, BlockShapes.DESK_LAMP_E, BlockShapes.DESK_LAMP_W));

    public static final RegistryObject<Block> TRASHBIN = registerBlock("trashbin", () ->
            new TrashBinBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(1F).noOcclusion()));

    public static final RegistryObject<Block> FIREEXTINGUISHERCASE = registerBlock("fireextinguishercase", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(6f).noOcclusion(),
                    BlockShapes.FIRE_EXTINGUISHER_S, BlockShapes.FIRE_EXTINGUISHER_N, BlockShapes.FIRE_EXTINGUISHER_E, BlockShapes.FIRE_EXTINGUISHER_W));

    public static final RegistryObject<Block> ELECTRICALBOX = registerBlock("electricalbox", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().strength(6f).noOcclusion(),
                    BlockShapes.ELECTRICAL_BOX_S, BlockShapes.ELECTRICAL_BOX_N, BlockShapes.ELECTRICAL_BOX_E, BlockShapes.ELECTRICAL_BOX_W));

    public static final RegistryObject<Block> VENDINGMACHINE = registerBlock("vendingmachine", () ->
            new VendingMachineBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).requiresCorrectToolForDrops().lightLevel(s -> 4).strength(6F).noOcclusion()));

    public static final RegistryObject<Block> BULLETINBOARD = registerBlock("bulletinboard", () ->
            new BulletinBoardBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).requiresCorrectToolForDrops().strength(2F).noOcclusion()));

    public static final RegistryObject<Block> SAFELABEL = registerBlock("safelabel", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2F).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.LABEL_S, BlockShapes.LABEL_N, BlockShapes.LABEL_E, BlockShapes.LABEL_W));

    public static final RegistryObject<Block> EUCLIDLABEL = registerBlock("euclidlabel", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2F).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.LABEL_S, BlockShapes.LABEL_N, BlockShapes.LABEL_E, BlockShapes.LABEL_W));

    public static final RegistryObject<Block> KETERLABEL = registerBlock("keterlabel", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2F).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.LABEL_S, BlockShapes.LABEL_N, BlockShapes.LABEL_E, BlockShapes.LABEL_W));

    public static final RegistryObject<Block> TRUSSBEAM = registerBlock("trussbeam", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(2F).noOcclusion()));

    public static final RegistryObject<Block> TRUSSBEAM_FENCE = registerBlock("trussbeam_fence", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(2F).requiresCorrectToolForDrops().noOcclusion(),
                    BlockShapes.TRUSSBEAM_FENCE_S, BlockShapes.TRUSSBEAM_FENCE_N, BlockShapes.TRUSSBEAM_FENCE_E, BlockShapes.TRUSSBEAM_FENCE_W));

    public static final RegistryObject<Block> SCP173CRAP = registerBlock("scp173crap", () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.SPONGE).noCollission().sound(SoundType.SLIME_BLOCK).strength(2F).noOcclusion().requiresCorrectToolForDrops(), BlockShapes.CARPET));

    public static final RegistryObject<Block> SCP106CORROSIONLAYER = registerBlock("scp106corrosionlayer", () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.SPONGE).noCollission().sound(SoundType.SLIME_BLOCK).strength(2F).noOcclusion().requiresCorrectToolForDrops(), BlockShapes.CARPET));

    public static final RegistryObject<Block> SCP106CORROSION = registerBlock("scp106corrosion", () ->
            new DecorationBlock(BlockBehaviour.Properties.of(Material.SPONGE).noCollission().sound(SoundType.SLIME_BLOCK).strength(2F).noOcclusion().speedFactor(0.2f).requiresCorrectToolForDrops(), BlockShapes.BLOCK));

    public static final RegistryObject<Block> CONTAINMENT_CASE = registerBlock("containment_case", () ->
            new ContainmentCase(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(2F).noOcclusion()));

    public static final RegistryObject<Block> CONTAINMENT_CASE_BOTTOM = registerBlock("containment_case_bottom", () ->
            new HorizontalDecorationBlock(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(2F).noOcclusion(), BlockShapes.CONTAINMENT_CASE_BOTTOM));

    /** MISC Blocks **/

    public static final RegistryObject<Block> CAUTIONLINE = registerBlock("cautionline", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.8F).explosionResistance(0.8F)));

    public static final RegistryObject<Block> CAUTIONLINE_STAIRS = registerBlock("cautionline_stairs", () ->
            new StairBlock(() -> ModBlocks.CAUTIONLINE.get().defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.8F).explosionResistance(0.8F)));

    public static final RegistryObject<Block> CAUTIONLINE_SLAB = registerBlock("cautionline_slab", () ->
            new SlabBlock(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOL).strength(0.8F).explosionResistance(0.8F)));

    public static final RegistryObject<Block> FACILITYLIGHT = registerBlock("facilitylight", () ->
            new Block(BlockBehaviour.Properties.of(Material.GLASS).lightLevel(s -> 15).sound(SoundType.GLASS).strength(0.8F).explosionResistance(0.8F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> REINFORCEDIRON = registerBlock("reinforcediron", () ->
            new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).sound(SoundType.METAL).strength(50F).explosionResistance(1000F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SCP_330 = registerBlock("scp_330", () ->
            new SCP330Block(BlockBehaviour.Properties.of(Material.METAL).strength(3.0F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));


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
