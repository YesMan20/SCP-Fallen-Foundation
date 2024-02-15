package net.yesman.scpff.level.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

// Like the DecorationBlock class but can be rotated
public class HorizontalDecorationBlock extends DecorationBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected VoxelShape NORTH_SHAPE;
    protected VoxelShape EAST_SHAPE;
    protected VoxelShape WEST_SHAPE;

    public HorizontalDecorationBlock(Properties property, VoxelShape shape, VoxelShape northShape, VoxelShape eastShape, VoxelShape westShape) {
        super(property, shape);
        this.NORTH_SHAPE = northShape;
        this.EAST_SHAPE = eastShape;
        this.WEST_SHAPE = westShape;
    }


    public HorizontalDecorationBlock(Properties property, VoxelShape shape) {
        super(property, shape);
        this.NORTH_SHAPE = shape;
        this.EAST_SHAPE = shape;
        this.WEST_SHAPE = shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> SHAPE;
            case NORTH -> NORTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case WEST -> WEST_SHAPE;
        };
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
