package net.yesman.scpff.level.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.yesman.scpff.level.block.BlockShapes;
import net.yesman.scpff.level.block.decor.HorizontalDecorationBlock;
import net.yesman.scpff.level.block.entity.ContainmentBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ContainmentCase extends HorizontalDecorationBlock implements EntityBlock {

    public ContainmentCase(Properties property) {
        super(property, BlockShapes.BLOCK, BlockShapes.BLOCK, BlockShapes.BLOCK, BlockShapes.BLOCK);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ContainmentBlockEntity entity = (ContainmentBlockEntity) pLevel.getBlockEntity(pPos);
        if (entity == null || pLevel.isClientSide || pHand.equals(InteractionHand.OFF_HAND) || pPlayer.getItemInHand(pHand).getItem() instanceof BlockItem) return InteractionResult.FAIL;
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

