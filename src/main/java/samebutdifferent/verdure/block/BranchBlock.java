package samebutdifferent.verdure.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

import javax.annotation.Nullable;
import java.util.Random;

public class BranchBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    private final Block log;
    private final Block fallenLeaves;
    protected static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
    protected static final VoxelShape Z_AXIS_AABB = Block.box(7.0D, 0.0D, 0.0D, 9.0D, 16.0D, 16.0D);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LEAVES = BooleanProperty.create("leaves");

    public BranchBlock(Block log, Block fallenLeaves, Properties properties) {
        super(properties);
        this.log = log;
        this.fallenLeaves = fallenLeaves;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false).setValue(LEAVES, false));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(FACING).getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    private boolean canAttachTo(BlockGetter pBlockReader, BlockPos pPos) {
        return pBlockReader.getBlockState(pPos).is(log);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        return this.canAttachTo(pLevel, pPos.relative(direction.getOpposite()));
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
        pBuilder.add(FACING, WATERLOGGED, LEAVES);
    }

    @Override
    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return !pState.getValue(LEAVES);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        if (pRandom.nextInt(5) == 0) {
            pLevel.setBlock(pPos, pState.setValue(LEAVES, true), 2);
        }
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction.equals(ToolActions.SHEARS_HARVEST) && state.getValue(LEAVES) && context.getItemInHand().canPerformAction(ToolActions.SHEARS_HARVEST)) {
            return state.setValue(LEAVES, false);
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        boolean canShear = false;
        if (pState.getValue(LEAVES)) {
            if (stack.canPerformAction(ToolActions.SHEARS_HARVEST)) {
                pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.SHEEP_SHEAR, SoundSource.NEUTRAL, 1.0F, 1.0F);
                popResource(pLevel, pPos, new ItemStack(fallenLeaves));
                stack.hurtAndBreak(1, pPlayer, (player) -> player.broadcastBreakEvent(pHand));
                canShear = true;
                pLevel.gameEvent(pPlayer, GameEvent.SHEAR, pPos);
            }

            if (!pLevel.isClientSide() && canShear) {
                pPlayer.awardStat(Stats.ITEM_USED.get(stack.getItem()));
            }
        }

        if (canShear) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(LEAVES, false));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }
}
