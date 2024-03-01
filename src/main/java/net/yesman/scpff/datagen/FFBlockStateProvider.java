package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.FFBlocksRegistry;

public class FFBlockStateProvider extends BlockStateProvider {
    public FFBlockStateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, SCPFf.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(FFBlocksRegistry.FACILITYLIGHT);
        blockWithItem(FFBlocksRegistry.HCFLOOR);
        blockWithItem(FFBlocksRegistry.HCWALL);
        blockWithItem(FFBlocksRegistry.REINFORCEDIRON);
        blockWithItem(FFBlocksRegistry.SCP106CORROSION);
        blockWithItem(FFBlocksRegistry.TILES);
        blockWithItem(FFBlocksRegistry.TILE);
        blockWithItem(FFBlocksRegistry.CAUTIONLINE);
        blockWithItem(FFBlocksRegistry.PIPECORNER);
        blockWithItem(FFBlocksRegistry.BRICKWALL1);
        blockWithItem(FFBlocksRegistry.BRICKWALL3);
        blockWithItem(FFBlocksRegistry.METALWALL1);
        blockWithItem(FFBlocksRegistry.METALWALL2);

        sidedBlock(FFBlocksRegistry.BRICKWALL2, new ResourceLocation(SCPFf.MOD_ID, "block/brickwall2"), new ResourceLocation(SCPFf.MOD_ID, "block/brickwall3"), new ResourceLocation(SCPFf.MOD_ID, "block/brickwall3"));
        sidedBlock(FFBlocksRegistry.EZWALL1, new ResourceLocation(SCPFf.MOD_ID, "block/ezwall1"), new ResourceLocation("block/white_concrete"), new ResourceLocation("block/white_concrete"));
        sidedBlock(FFBlocksRegistry.EZWALL2, new ResourceLocation(SCPFf.MOD_ID, "block/ezwall2"), new ResourceLocation("block/white_concrete"), new ResourceLocation("block/white_concrete"));
        sidedBlock(FFBlocksRegistry.LCWALL1, new ResourceLocation(SCPFf.MOD_ID, "block/lcwall1"), new ResourceLocation("block/white_concrete"), new ResourceLocation("block/white_concrete"));
        sidedBlock(FFBlocksRegistry.LCWALL2, new ResourceLocation(SCPFf.MOD_ID, "block/lcwall2"), new ResourceLocation("block/white_concrete"), new ResourceLocation("block/white_concrete"));
        sidedBlock(FFBlocksRegistry.LCWALL3, new ResourceLocation(SCPFf.MOD_ID, "block/lcwall3"), new ResourceLocation("block/white_concrete"), new ResourceLocation("block/white_concrete"));

        stairBlock(FFBlocksRegistry.CAUTIONLINE_STAIRS, FFBlocksRegistry.CAUTIONLINE);
        stairBlock(FFBlocksRegistry.HCFLOOR_STAIRS, FFBlocksRegistry.HCFLOOR);
        stairBlock(FFBlocksRegistry.HCWALL_STAIRS, FFBlocksRegistry.HCWALL);
        stairBlock(FFBlocksRegistry.TILE_STAIRS, FFBlocksRegistry.TILES);
        stairBlock(FFBlocksRegistry.BIG_TILE_STAIRS, FFBlocksRegistry.TILE);
        stairBlock(FFBlocksRegistry.GRAY_CONCRETE_STAIRS, new ResourceLocation("block/gray_concrete"));
        stairBlock(FFBlocksRegistry.WHITE_CONCRETE_STAIRS, new ResourceLocation("block/white_concrete"));

        slabBlock(FFBlocksRegistry.CAUTIONLINE_SLAB, FFBlocksRegistry.CAUTIONLINE);
        slabBlock(FFBlocksRegistry.HCFLOOR_SLAB, FFBlocksRegistry.HCFLOOR);
        slabBlock(FFBlocksRegistry.HCWALL_SLAB, FFBlocksRegistry.HCWALL);
        slabBlock(FFBlocksRegistry.TILE_SLAB, FFBlocksRegistry.TILES);
        slabBlock(FFBlocksRegistry.BIG_TILE_SLAB, FFBlocksRegistry.TILE);
        slabBlock(FFBlocksRegistry.GRAY_CONCRETE_SLAB, new ResourceLocation("block/gray_concrete"));
        slabBlock(FFBlocksRegistry.WHITE_CONCRETE_SLAB, new ResourceLocation("block/white_concrete"));

        horizontalBlockWithItem(FFBlocksRegistry.CONTAINMENT_CASE_BOTTOM);
        horizontalBlockWithItem(FFBlocksRegistry.BEAKERS);
        horizontalBlockWithItem(FFBlocksRegistry.BULLETINBOARD);
        horizontalBlockWithItem(FFBlocksRegistry.CATWALKFENCE);
        horizontalBlockWithItem(FFBlocksRegistry.CATWALKFENCE2);
        horizontalBlockWithItem(FFBlocksRegistry.CATWALKSTAIRS);
        horizontalBlockWithItem(FFBlocksRegistry.CHAIR);
        horizontalBlockWithItem(FFBlocksRegistry.FIREEXTINGUISHERCASE);
        horizontalBlockWithItem(FFBlocksRegistry.ELECTRICALBOX);
        horizontalBlockWithItem(FFBlocksRegistry.EUCLIDLABEL);
        horizontalBlockWithItem(FFBlocksRegistry.FILECABINET);
        horizontalBlockWithItem(FFBlocksRegistry.FLOODLIGHTS);
        horizontalBlockWithItem(FFBlocksRegistry.INTERCOMMICROPHONE);
        horizontalBlockWithItem(FFBlocksRegistry.INTERCOMSPEAKER);
        horizontalBlockWithItem(FFBlocksRegistry.KETERLABEL);
        horizontalBlockWithItem(FFBlocksRegistry.MIRROR);
        horizontalBlockWithItem(FFBlocksRegistry.PAPER);
        horizontalBlockWithItem(FFBlocksRegistry.PAPERSTACK);
        horizontalBlockWithItem(FFBlocksRegistry.SAFELABEL);
        horizontalBlockWithItem(FFBlocksRegistry.SCALE);
        horizontalBlockWithItem(FFBlocksRegistry.SCP_330);
        horizontalBlockWithItem(FFBlocksRegistry.TESTTUBES);
        horizontalBlockWithItem(FFBlocksRegistry.TRUSSBEAM_FENCE);
        horizontalBlockWithItem(FFBlocksRegistry.WALLLIGHT);
        horizontalBlockWithItem(FFBlocksRegistry.WIRES);
        horizontalBlockWithItem(FFBlocksRegistry.WIRES_LEFT);
        horizontalBlockWithItem(FFBlocksRegistry.WIRES_RIGHT);
        horizontalBlockWithItem(FFBlocksRegistry.WIRES_THREEWAY);
        horizontalBlockWithItem(FFBlocksRegistry.WIRES_THREEWAY2);
        horizontalBlockWithItem(FFBlocksRegistry.MICROSCOPE);

        blockWithBlockState(FFBlocksRegistry.CATWALKBLOCK);
        blockWithBlockState(FFBlocksRegistry.CRATE);
        blockWithBlockState(FFBlocksRegistry.SCP106CORROSIONLAYER);
        blockWithBlockState(FFBlocksRegistry.SCP173CRAP);
        blockWithBlockState(FFBlocksRegistry.TRASHBIN);
        blockWithBlockState(FFBlocksRegistry.TRUSSBEAM);

        doorBlock(FFBlocksRegistry.METALDOOR, true, new ResourceLocation(SCPFf.MOD_ID, "block/metaldoor_bottom"), new ResourceLocation(SCPFf.MOD_ID, "block/metaldoor_top"));
        doorBlock(FFBlocksRegistry.OFFICEDOOR, true, new ResourceLocation(SCPFf.MOD_ID, "block/officedoor_bottom"), new ResourceLocation(SCPFf.MOD_ID, "block/officedoor_top"));

        trapDoorBlock(FFBlocksRegistry.VENT_COVER, true, true, new ResourceLocation(SCPFf.MOD_ID, "block/vent_cover"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void horizontalBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        Block block = blockRegistryObject.get();
        ModelFile.ExistingModelFile model = new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getDescriptionId().replace("block.scpff.", "")), models().existingFileHelper);
        horizontalBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void blockWithBlockState(RegistryObject<Block> block) {
        ModelFile.ExistingModelFile model = new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.get().getDescriptionId().replace("block.scpff.", "")), models().existingFileHelper);
        simpleBlock(block.get(), model);
        simpleBlockItem(block.get(), model);
    }

    private void sidedBlock(RegistryObject<Block> block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top) {
        simpleBlockWithItem(block.get(), models().cubeBottomTop(block.getId().getPath(), side, bottom, top));
    }

    private void stairBlock(RegistryObject<Block> block, RegistryObject<Block> ogBlock) {
        stairsBlock((StairBlock)block.get(), new ResourceLocation(SCPFf.MOD_ID, "block/" + ogBlock.getId().getPath()));
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void stairBlock(RegistryObject<Block> block, ResourceLocation texture) {
        stairsBlock((StairBlock)block.get(), texture);
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void slabBlock(RegistryObject<Block> block, RegistryObject<Block> ogBlock) {
        slabBlock((SlabBlock)block.get(), new ResourceLocation(SCPFf.MOD_ID, "block/" + ogBlock.getId().getPath()), new ResourceLocation(SCPFf.MOD_ID, "block/" + ogBlock.getId().getPath()));
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void slabBlock(RegistryObject<Block> block, ResourceLocation texture) {
        slabBlock((SlabBlock)block.get(), texture, texture);
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void doorBlock(RegistryObject<Block> block, boolean cutout, ResourceLocation bottom, ResourceLocation top) {
        if (cutout) {
            doorBlockWithRenderType((DoorBlock)block.get(), bottom, top, new ResourceLocation("cutout"));
        } else {
            doorBlock((DoorBlock)block.get(), bottom, top);
        }
    }

    private void trapDoorBlock(RegistryObject<Block> block, boolean orientable, boolean cutout, ResourceLocation texture) {
        if (cutout) {
            trapdoorBlockWithRenderType((TrapDoorBlock)block.get(), texture, orientable, "cutout");
        } else {
            trapdoorBlock((TrapDoorBlock)block.get(), texture, orientable);
        }
    }
}
