package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.block.FFBlocksRegistry;

public class FFBlockStateProvider extends BlockStateProvider {
    public FFBlockStateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, SCPFf.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        horizontalBlockWithItem(FFBlocksRegistry.CONTAINMENT_CASE);
        horizontalBlockWithItem(FFBlocksRegistry.CONTAINMENT_CASE_BOTTOM);
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
}
