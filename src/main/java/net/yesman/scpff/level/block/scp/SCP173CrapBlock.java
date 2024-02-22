package net.yesman.scpff.level.block.scp;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.yesman.scpff.level.block.decor.DecorationBlock;

import javax.annotation.Nullable;

public class SCP173CrapBlock extends DecorationBlock implements SimpleWaterloggedBlock {
    public final boolean spawnParticles;
    public static final BooleanProperty WATERLOGGED;

    public SCP173CrapBlock(boolean pSpawnParticles, BlockBehaviour.Properties pProperties) {
        super(pProperties, Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0));
        this.spawnParticles = pSpawnParticles;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()))).setValue(WATERLOGGED, false)));
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        RandomSource randomsource = pLevel.random;
        int l;
        if (randomsource.nextFloat() < 0.20F) {
            for(l = 0; l < randomsource.nextInt(2) + 2; ++l) {
                dowse((Entity)null, pLevel, pPos, pState);
            }
        }

    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor levelaccessor = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        boolean flag = levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER;
        return (BlockState)((BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(WATERLOGGED, flag))));
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if ((Boolean)pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public static void dowse(@Nullable Entity pEntity, LevelAccessor pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.isClientSide()) {
            for(int i = 0; i < 3; ++i) {
                makeParticles((Level)pLevel, pPos);
            }
        }

        pLevel.gameEvent(pEntity, GameEvent.BLOCK_CHANGE, pPos);
    }

    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState) {
        if (!(Boolean)pState.getValue(BlockStateProperties.WATERLOGGED) && pFluidState.getType() == Fluids.WATER) {
            dowse((Entity)null, pLevel, pPos, pState);

            pLevel.setBlock(pPos, (BlockState)((BlockState)pState.setValue(WATERLOGGED, true)), 3);
            pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
            return true;
        } else {
            return false;
        }
    }

    public FluidState getFluidState(BlockState pState) {
        return (Boolean)pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(new Property[]{WATERLOGGED});
    }


    public static void makeParticles(Level pLevel, BlockPos pPos) {
        RandomSource randomsource = pLevel.getRandom();
        SimpleParticleType simpleparticletype = ParticleTypes.CAMPFIRE_COSY_SMOKE;
        pLevel.addAlwaysVisibleParticle(simpleparticletype, true, (double)pPos.getX() + 0.5 + randomsource.nextDouble() / 3.0 * (double)(randomsource.nextBoolean() ? 1 : -1), (double)pPos.getY() + randomsource.nextDouble() + randomsource.nextDouble(), (double)pPos.getZ() + 0.5 + randomsource.nextDouble() / 3.0 * (double)(randomsource.nextBoolean() ? 1 : -1), 0.0, 0.03, 0.0);
    }

    static {
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
    }
}
