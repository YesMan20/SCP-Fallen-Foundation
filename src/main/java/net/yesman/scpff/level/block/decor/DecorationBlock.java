package net.yesman.scpff.level.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DecorationBlock extends Block {
    protected VoxelShape SHAPE;

    // The purpose of this class is to make implementing decoration blocks way easier instead of having to create a new class everytime
    public DecorationBlock(Properties property, VoxelShape shape) {
        super(property);
        this.SHAPE = shape;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
