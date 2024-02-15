package net.yesman.scpff.level.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import net.yesman.scpff.level.block.entity.LockerBlockEntity;

import javax.annotation.Nullable;

public class LockerBlock extends BaseEntityBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public LockerBlock(Properties pProperties) {
        super(pProperties);
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
        if (pFacing.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (pFacing == Direction.UP)) {
            return pFacingState.is(this) && pFacingState.getValue(HALF) != doubleblockhalf ? pState.setValue(FACING, pFacingState.getValue(FACING)) : Blocks.AIR.defaultBlockState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.LOWER && pFacing == Direction.DOWN && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext)) {
            boolean flag = level.hasNeighborSignal(blockpos) || level.hasNeighborSignal(blockpos.above());
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER).setValue(FACING, pContext.getHorizontalDirection().getOpposite())
                    ;
        } else {
            return null;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HALF, FACING);
    }

    public long getSeed(BlockState pState, BlockPos pPos) {
        return Mth.getSeed(pPos.getX(), pPos.below(pState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pPos.getZ());
    }

    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        return pState.getValue(HALF) == DoubleBlockHalf.LOWER ? blockstate.isFaceSturdy(pLevel, blockpos, Direction.UP) : blockstate.is(this);
    }


    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
        pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    private static final VoxelShape SHAPE =
            Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
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
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
        if (entity instanceof ServerPlayer player) {
            NetworkHooks.openScreen(player, blockstate.getMenuProvider(world, pos));
        }
        return InteractionResult.SUCCESS;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LockerBlockEntity(pos, state);
    }

    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof Container) {
                Containers.dropContents(pLevel, pPos, (Container)blockentity);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }

            super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
        }
    }

}
