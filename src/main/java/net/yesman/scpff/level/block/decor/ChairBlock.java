package net.yesman.scpff.level.block.decor;

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
import net.yesman.scpff.level.entity.ChairEntity;

public class ChairBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ChairBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ChairEntity chairEntity = new ChairEntity(pLevel, pPos, pState.getValue(FACING));
        pLevel.addFreshEntity(chairEntity);
        if (!chairEntity.hasPassenger(pPlayer)) {
            pPlayer.startRiding(chairEntity);
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Shapes.or(Block.box(3, 11, 3, 13, 13, 13), Block.box(7, 4, 7, 9, 11, 9), Block.box(2, 0, 7, 14, 4, 9), Block.box(7, 0, 2, 9, 4, 14), Block.box(3, 16, 1, 13, 23, 3));
            case NORTH -> Shapes.or(Block.box(3, 11, 3, 13, 13, 13), Block.box(7, 4, 7, 9, 11, 9), Block.box(2, 0, 7, 14, 4, 9), Block.box(7, 0, 2, 9, 4, 14), Block.box(3, 16, 13, 13, 23, 15));
            case EAST -> Shapes.or(Block.box(3, 11, 3, 13, 13, 13), Block.box(7, 4, 7, 9, 11, 9), Block.box(7, 0, 2, 9, 4, 14), Block.box(2, 0, 7, 14, 4, 9), Block.box(1, 16, 3, 3, 23, 13));
            case WEST -> Shapes.or(Block.box(3, 11, 3, 13, 13, 13), Block.box(7, 4, 7, 9, 11, 9), Block.box(7, 0, 2, 9, 4, 14), Block.box(2, 0, 7, 14, 4, 9), Block.box(13, 16, 3, 15, 23, 13));
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
