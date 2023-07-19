package net.yesman.scpff.level.block.decor;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WireBlock extends HorizontalDecorationBlock {
    public WireBlock(VoxelShape shape, VoxelShape northShape, VoxelShape eastShape, VoxelShape westShape) {
        super(BlockBehaviour.Properties.of(Material.WOOL).instabreak().noCollission().sound(SoundType.WOOL), shape, northShape, eastShape, westShape);
    }
}
