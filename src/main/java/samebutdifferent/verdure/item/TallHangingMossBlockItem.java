package samebutdifferent.verdure.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import samebutdifferent.verdure.block.TallHangingMossBlock;
import samebutdifferent.verdure.registry.VerdureBlocks;

public class TallHangingMossBlockItem extends BlockItem {
    public TallHangingMossBlockItem(Block pBlock, Properties pProperties) {
        super(pBlock, pProperties);
    }

    @Override
    protected boolean placeBlock(BlockPlaceContext pContext, BlockState pState) {
        Level level = pContext.getLevel();
        BlockPos belowPos = pContext.getClickedPos().below();
        BlockState belowState = level.isWaterAt(belowPos) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
        level.setBlock(belowPos, belowState, 27);
        return super.placeBlock(pContext, pState);
    }
}
