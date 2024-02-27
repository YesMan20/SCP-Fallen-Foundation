package net.yesman.scpff.level.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yesman.scpff.level.block.FFBlockShapes;
import net.yesman.scpff.level.block.entity.ContainmentBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class ContainmentCase extends HorizontalDecorationBlock implements EntityBlock {

    public ContainmentCase(Properties property) {
        super(property, FFBlockShapes.BLOCK, FFBlockShapes.BLOCK, FFBlockShapes.BLOCK, FFBlockShapes.BLOCK);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Stream.of(
                    Block.box(6, 0, 6, 10, 3, 10),
                    Block.box(2, 0, 12, 14, 2, 16),
                    Block.box(-3, -1, 11, 2, 2, 13),
                    Block.box(-3, 0, 9, 2, 3, 11),
                    Block.box(-3, 1, 7, 2, 4, 9),
                    Block.box(2, 2, 4, 14, 5, 8),
                    Block.box(2, 3, 1, 14, 6, 4),
                    Block.box(2, 1, 8, 14, 4, 12)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
            case NORTH ->
                    Stream.of(
                            Block.box(6, 0, 6, 10, 3, 10),
                            Block.box(2, 0, 0, 14, 2, 4),
                            Block.box(14, -1, 3, 19, 2, 5),
                            Block.box(14, 0, 5, 19, 3, 7),
                            Block.box(14, 1, 7, 19, 4, 9),
                            Block.box(2, 2, 8, 14, 5, 12),
                            Block.box(2, 3, 12, 14, 6, 15),
                            Block.box(2, 1, 4, 14, 4, 8)
                    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
            case EAST ->  Stream.of(
                    Block.box(6, 0, 6, 10, 3, 10),
                    Block.box(12, 0, 2, 16, 2, 14),
                    Block.box(11, -1, 14, 13, 2, 19),
                    Block.box(9, 0, 14, 11, 3, 19),
                    Block.box(7, 1, 14, 9, 4, 19),
                    Block.box(4, 2, 2, 8, 5, 14),
                    Block.box(1, 3, 2, 4, 6, 14),
                    Block.box(8, 1, 2, 12, 4, 14)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
            case WEST -> Stream.of(
                    Block.box(6, 0, 6, 10, 3, 10),
                    Block.box(0, 0, 2, 4, 2, 14),
                    Block.box(3, -1, -3, 5, 2, 2),
                    Block.box(5, 0, -3, 7, 3, 2),
                    Block.box(7, 1, -3, 9, 4, 2),
                    Block.box(8, 2, 2, 12, 5, 14),
                    Block.box(12, 3, 2, 15, 6, 14),
                    Block.box(4, 1, 2, 8, 4, 14)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
        };
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ContainmentBlockEntity entity = (ContainmentBlockEntity) pLevel.getBlockEntity(pPos);
        if (entity == null || pLevel.isClientSide || pHand.equals(InteractionHand.OFF_HAND) || pPlayer.getItemInHand(pHand).getItem() instanceof BlockItem || pPlayer.getItemInHand(pHand).getItem() instanceof ArmorItem) return InteractionResult.FAIL;
        entity.updateItem(pPlayer, pPlayer.getItemInHand(InteractionHand.MAIN_HAND));
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ContainmentBlockEntity(pPos, pState);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return true;
    }

    @Override
    public float getShadeBrightness(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return 1.0F;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        ContainmentBlockEntity blockEntity = (ContainmentBlockEntity) pLevel.getBlockEntity(pPos);
        if (blockEntity != null && !blockEntity.currentItem.isEmpty()) {
            ItemEntity itemEntity = new ItemEntity(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), blockEntity.currentItem, 0.2F * pLevel.getRandom().nextFloat(), 0.2F, 0.2F * pLevel.getRandom().nextFloat());
            pLevel.addFreshEntity(itemEntity);
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }
}

