package samebutdifferent.verdure.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class DriedMudBlock extends Block {
    public DriedMudBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockGetter blockgetter = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState blockstate = blockgetter.getBlockState(blockpos);
        return shouldSolidify(blockgetter, blockpos, blockstate) ? Blocks.BROWN_TERRACOTTA.defaultBlockState() : super.getStateForPlacement(pContext);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        return touchesLiquid(pLevel, pCurrentPos) ? Blocks.BROWN_TERRACOTTA.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    private static boolean shouldSolidify(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return canSolidify(pState) || touchesLiquid(pLevel, pPos);
    }

    private static boolean touchesLiquid(BlockGetter pLevel, BlockPos pPos) {
        boolean touchingLiquid = false;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pPos.mutable();

        for(Direction direction : Direction.values()) {
            BlockState blockstate = pLevel.getBlockState(blockpos$mutableblockpos);
            if (direction != Direction.DOWN || canSolidify(blockstate)) {
                blockpos$mutableblockpos.setWithOffset(pPos, direction);
                blockstate = pLevel.getBlockState(blockpos$mutableblockpos);
                if (canSolidify(blockstate) && !blockstate.isFaceSturdy(pLevel, pPos, direction.getOpposite())) {
                    touchingLiquid = true;
                    break;
                }
            }
        }

        return touchingLiquid;
    }

    private static boolean canSolidify(BlockState pState) {
        return pState.getFluidState().is(FluidTags.WATER);
    }

}
