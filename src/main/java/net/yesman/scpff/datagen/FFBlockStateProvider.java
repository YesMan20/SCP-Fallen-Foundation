package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
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
        blockWithItem(FFBlocksRegistry.VENTBLOCK);
        blockWithItem(FFBlocksRegistry.TILES);
        blockWithItem(FFBlocksRegistry.CAUTIONLINE);

        stairBlock(FFBlocksRegistry.CAUTIONLINE_STAIRS, FFBlocksRegistry.CAUTIONLINE);
        stairBlock(FFBlocksRegistry.HCFLOOR_STAIRS, FFBlocksRegistry.HCFLOOR);
        stairBlock(FFBlocksRegistry.HCWALL_STAIRS, FFBlocksRegistry.HCWALL);
        stairBlock(FFBlocksRegistry.TILE_STAIRS, FFBlocksRegistry.TILES);
        stairBlock(FFBlocksRegistry.GRAY_CONCRETE_STAIRS, "gray_concrete");
        stairBlock(FFBlocksRegistry.WHITE_CONCRETE_STAIRS, "white_concrete");

        slabBlock(FFBlocksRegistry.CAUTIONLINE_SLAB, FFBlocksRegistry.CAUTIONLINE);
        slabBlock(FFBlocksRegistry.HCFLOOR_SLAB, FFBlocksRegistry.HCFLOOR);
        slabBlock(FFBlocksRegistry.HCWALL_SLAB, FFBlocksRegistry.HCWALL);
        slabBlock(FFBlocksRegistry.TILE_SLAB, FFBlocksRegistry.TILES);
        slabBlock(FFBlocksRegistry.GRAY_CONCRETE_SLAB, "gray_concrete");
        slabBlock(FFBlocksRegistry.WHITE_CONCRETE_SLAB, "white_concrete");

        horizontalBlockWithItem(FFBlocksRegistry.CONTAINMENT_CASE);
        horizontalBlockWithItem(FFBlocksRegistry.CONTAINMENT_CASE_BOTTOM);
        horizontalBlockWithItem(FFBlocksRegistry.BEAKERS);
        horizontalBlockWithItem(FFBlocksRegistry.BULLETINBOARD);
        horizontalBlockWithItem(FFBlocksRegistry.CATWALKFENCE);
        horizontalBlockWithItem(FFBlocksRegistry.CATWALKFENCE2);
        horizontalBlockWithItem(FFBlocksRegistry.CATWALKSTAIRS);
        horizontalBlockWithItem(FFBlocksRegistry.CHAIR);
        horizontalBlockWithItem(FFBlocksRegistry.COMPUTER);
        horizontalBlockWithItem(FFBlocksRegistry.DESKLAMP);
        horizontalBlockWithItem(FFBlocksRegistry.FIREEXTINGUISHERCASE);
        horizontalBlockWithItem(FFBlocksRegistry.ELECTRICALBOX);
        horizontalBlockWithItem(FFBlocksRegistry.EUCLIDLABEL);
        horizontalBlockWithItem(FFBlocksRegistry.FILECABINET);
        horizontalBlockWithItem(FFBlocksRegistry.FLOODLIGHTS);
        horizontalBlockWithItem(FFBlocksRegistry.INTERCOMMICROPHONE);
        horizontalBlockWithItem(FFBlocksRegistry.INTERCOMSPEAKER);
        horizontalBlockWithItem(FFBlocksRegistry.KETERLABEL);
    }

    private void horizontalBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        Block block = blockRegistryObject.get();
        ModelFile.ExistingModelFile model = new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getDescriptionId().replace("block.scpff.", "")), models().existingFileHelper);
        horizontalBlock(block, model);
        simpleBlockItem(block, model);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void stairBlock(RegistryObject<Block> block, RegistryObject<Block> ogBlock) {
        stairsBlock((StairBlock)block.get(), new ResourceLocation(SCPFf.MOD_ID, "block/" + ogBlock.getId().getPath()));
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void stairBlock(RegistryObject<Block> block, String texture) {
        stairsBlock((StairBlock)block.get(), new ResourceLocation("block/" + texture));
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void slabBlock(RegistryObject<Block> block, RegistryObject<Block> ogBlock) {
        slabBlock((SlabBlock)block.get(), new ResourceLocation(SCPFf.MOD_ID, "block/" + ogBlock.getId().getPath()), new ResourceLocation(SCPFf.MOD_ID, "block/" + ogBlock.getId().getPath()));
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void slabBlock(RegistryObject<Block> block, String texture) {
        slabBlock((SlabBlock)block.get(), new ResourceLocation("block/" + texture), new ResourceLocation("block/" + texture));
        simpleBlockItem(block.get(), new ModelFile.ExistingModelFile(new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()), models().existingFileHelper));
    }

    private void sidedBlock(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeBottomTop(block.getId().getPath(), new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath() + "_side"), new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath() + "_down"), new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath())));
    }
}
