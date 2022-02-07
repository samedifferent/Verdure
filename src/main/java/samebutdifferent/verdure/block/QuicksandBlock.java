package samebutdifferent.verdure.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class QuicksandBlock extends Block {
    private static final VoxelShape FALLING_COLLISION_SHAPE = Shapes.box(0.0D, 0.0D, 0.0D, 1.0D, 0.9F, 1.0D);

    public QuicksandBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
        return pAdjacentBlockState.is(this) || super.skipRendering(pState, pAdjacentBlockState, pDirection);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return Shapes.empty();
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity instanceof LivingEntity && pEntity.getFeetBlockState().is(this)) {
            pEntity.makeStuckInBlock(pState, new Vec3(0.5F, 0.1D, 0.5F));
        }
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        if (pContext instanceof EntityCollisionContext) {
            EntityCollisionContext entityCollisionContext = (EntityCollisionContext)pContext;
            Entity entity = entityCollisionContext.getEntity();
            if (entity != null) {
                if (entity.fallDistance > 2.5F) {
                    return FALLING_COLLISION_SHAPE;
                }

                boolean isBlockFalling = entity instanceof FallingBlockEntity;
                if (isBlockFalling || pContext.isAbove(Shapes.block(), pPos, false) && !pContext.isDescending()) {
                    return super.getCollisionShape(pState, pLevel, pPos, pContext);
                }
            }
        }

        return Shapes.empty();
    }

    @Override
    public VoxelShape getVisualShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.empty();
    }

    @Override
    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return true;
    }
}
