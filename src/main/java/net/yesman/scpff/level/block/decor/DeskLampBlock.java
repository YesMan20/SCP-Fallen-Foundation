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

import java.util.Properties;

public class DeskLampBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public DeskLampBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(6.5, 12.9169, 10.27096, 9.5, 15.9169, 12.27096), box(6.5, 13.9169, 12.27096, 9.5, 15.9169, 19.27096));
            case NORTH -> Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(6.5, 12.9169, 3.72904, 9.5, 15.9169, 5.72904), box(6.5, 13.9169, -3.27096, 9.5, 15.9169, 3.72904));
            case EAST -> Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(10.27096, 12.9169, 6.5, 12.27096, 15.9169, 9.5), box(12.27096, 13.9169, 6.5, 19.27096, 15.9169, 9.5));
            case WEST -> Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(3.72904, 12.9169, 6.5, 5.72904, 15.9169, 9.5), box(-3.27096, 13.9169, 6.5, 3.72904, 15.9169, 9.5));
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
