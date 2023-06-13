package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, SCPFf.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
