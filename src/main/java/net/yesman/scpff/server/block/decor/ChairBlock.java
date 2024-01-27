package net.yesman.scpff.server.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yesman.scpff.server.entity.scp.ChairEntity;

public class ChairBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ChairBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ChairEntity chairEntity = new ChairEntity(pLevel, pPos, pState.getValue(FACING));
        pLevel.addFreshEntity(chairEntity);
        pPlayer.startRiding(chairEntity);
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Shapes.or(box(7, 0, 0, 9, 4, 16), box(0, 0, 7, 16, 4, 9), box(7, 4, 7, 9, 11, 9), box(2, 11, 3, 14, 13, 14), box(2, 12, 1, 14, 27, 3), box(0, 12, 2, 2, 18, 12), box(14, 12, 2, 16, 18, 12));
            case NORTH -> Shapes.or(box(7, 0, 0, 9, 4, 16), box(0, 0, 7, 16, 4, 9), box(7, 4, 7, 9, 11, 9), box(2, 11, 2, 14, 13, 13), box(2, 12, 13, 14, 27, 15), box(14, 12, 4, 16, 18, 14), box(0, 12, 4, 2, 18, 14));
            case EAST -> Shapes.or(box(0, 0, 7, 16, 4, 9), box(7, 0, 0, 9, 4, 16), box(7, 4, 7, 9, 11, 9), box(3, 11, 2, 14, 13, 14), box(1, 12, 2, 3, 27, 14), box(2, 12, 14, 12, 18, 16), box(2, 12, 0, 12, 18, 2));
            case WEST -> Shapes.or(box(0, 0, 7, 16, 4, 9), box(7, 0, 0, 9, 4, 16), box(7, 4, 7, 9, 11, 9), box(2, 11, 2, 13, 13, 14), box(13, 12, 2, 15, 27, 14), box(4, 12, 0, 14, 18, 2), box(4, 12, 14, 14, 18, 16));
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
