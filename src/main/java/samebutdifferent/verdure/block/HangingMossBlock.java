package samebutdifferent.verdure.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingMossBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 10.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public HangingMossBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.above();
        BlockState blockstate = pLevel.getBlockState(blockpos);
        return blockstate.isFaceSturdy(pLevel, blockpos, Direction.DOWN);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if (pDirection == Direction.UP && !this.canSurvive(pState, pLevel, pCurrentPos)) {
            return Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
        }
    }

    @Override
    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }
}
