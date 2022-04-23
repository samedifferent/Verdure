package samebutdifferent.verdure.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WallRootsBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    protected static final VoxelShape EAST_AABB = Block.box(0.0D, 0.0D, 0.0D, 3.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB = Block.box(13.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 3.0D);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0D, 0.0D, 13.0D, 16.0D, 16.0D, 16.0D);

    public WallRootsBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch(pState.getValue(FACING)) {
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case WEST:
                return WEST_AABB;
            case EAST:
            default:
                return EAST_AABB;
        }
    }

    public static boolean canAttachTo(BlockGetter pBlockReader, BlockPos pPos, Direction pDirection) {
        return pBlockReader.getBlockState(pPos).isFaceSturdy(pBlockReader, pPos, pDirection);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        return canAttachTo(pLevel, pPos.relative(direction.getOpposite()), direction);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pFacing.getOpposite() == pState.getValue(FACING) && !pState.canSurvive(pLevel, pCurrentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            if (pState.getValue(WATERLOGGED)) {
                pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
            }

            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        if (!pContext.replacingClickedOnBlock()) {
            BlockState state = pContext.getLevel().getBlockState(pContext.getClickedPos().relative(pContext.getClickedFace().getOpposite()));
            if (state.is(this) && state.getValue(FACING) == pContext.getClickedFace()) {
                return null;
            }
        }

        BlockState defaultBlockState = this.defaultBlockState();
        LevelReader level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        FluidState fluidState = pContext.getLevel().getFluidState(pContext.getClickedPos());

        for(Direction direction : pContext.getNearestLookingDirections()) {
            if (direction.getAxis().isHorizontal()) {
                defaultBlockState = defaultBlockState.setValue(FACING, direction.getOpposite());
                if (defaultBlockState.canSurvive(level, pos)) {
                    return defaultBlockState.setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
                }
            }
        }

        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }
}
