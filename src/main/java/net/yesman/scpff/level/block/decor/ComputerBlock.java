package net.yesman.scpff.level.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ComputerBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ComputerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Shapes.or(box(2.5, 0, 0, 13.5, 4, 11), box(2.5, 0, 11, 13.5, 1, 16), box(16.5, -0.25, 12, 19.5, 0.75, 16), box(4.5, 3.5, 2, 11.5, 4.5, 9), box(3.5, 4.5, 1.5, 12.5, 5.5, 8.5), box(3, 5.5, 0.5, 13, 13.5, 8.5),
                    box(2.5, 5, 8.5, 13.5, 14, 9.5));
            case NORTH -> Shapes.or(box(2.5, 0, 5, 13.5, 4, 16), box(2.5, 0, 0, 13.5, 1, 5), box(-3.5, -0.25, 0, -0.5, 0.75, 4), box(4.5, 3.5, 7, 11.5, 4.5, 14), box(3.5, 4.5, 7.5, 12.5, 5.5, 14.5), box(3, 5.5, 7.5, 13, 13.5, 15.5),
                    box(2.5, 5, 6.5, 13.5, 14, 7.5));
            case EAST -> Shapes.or(box(0, 0, 2.5, 11, 4, 13.5), box(11, 0, 2.5, 16, 1, 13.5), box(12, -0.25, -3.5, 16, 0.75, -0.5), box(2, 3.5, 4.5, 9, 4.5, 11.5), box(1.5, 4.5, 3.5, 8.5, 5.5, 12.5), box(0.5, 5.5, 3, 8.5, 13.5, 13),
                    box(8.5, 5, 2.5, 9.5, 14, 13.5));
            case WEST -> Shapes.or(box(5, 0, 2.5, 16, 4, 13.5), box(0, 0, 2.5, 5, 1, 13.5), box(0, -0.25, 16.5, 4, 0.75, 19.5), box(7, 3.5, 4.5, 14, 4.5, 11.5), box(7.5, 4.5, 3.5, 14.5, 5.5, 12.5), box(7.5, 5.5, 3, 15.5, 13.5, 13),
                    box(6.5, 5, 2.5, 7.5, 14, 13.5));
        };
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
