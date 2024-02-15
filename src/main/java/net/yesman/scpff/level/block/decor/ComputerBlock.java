package net.yesman.scpff.level.block.decor;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ComputerBlock extends HorizontalDecorationBlock {
    protected static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public ComputerBlock(Properties property, VoxelShape shape, VoxelShape northShape, VoxelShape eastShape, VoxelShape westShape) {
        super(property, shape, northShape, eastShape, westShape);
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, false));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pLevel.setBlock(pPos, pState.cycle(POWERED), 2);
        pLevel.playSound(pPlayer, pPos, pState.getValue(POWERED) ? SoundEvents.STONE_BUTTON_CLICK_OFF : SoundEvents.STONE_BUTTON_CLICK_ON, SoundSource.BLOCKS);
        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
        super.createBlockStateDefinition(builder);
    }
}
