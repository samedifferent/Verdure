package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class FallenLeavesDecorator extends TreeDecorator {
    public static final Codec<FallenLeavesDecorator> CODEC = BlockStateProvider.CODEC.fieldOf("fallen_leaves").xmap(FallenLeavesDecorator::new, (decorator) -> decorator.provider).codec();
    private final BlockStateProvider provider;

    public FallenLeavesDecorator(BlockStateProvider provider) {
        this.provider = provider;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.FALLEN_LEAVES.get();
    }

    @Override
    public void place(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, List<BlockPos> pLogPositions, List<BlockPos> pLeafPositions) {
        if (!pLeafPositions.isEmpty()) {
            List<BlockPos> lowestLeafPositions = pLeafPositions.stream().filter(blockPos -> blockPos.getY() == pLeafPositions.get(0).getY()).toList();
            for (BlockPos pos : lowestLeafPositions) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
                mutable.set(pos.below());
                while (pLevel.isStateAtPosition(mutable.below(), blockState -> !blockState.getMaterial().isSolid())) {
                    mutable.move(Direction.DOWN);
                }
                if (pLevel.isStateAtPosition(mutable, blockState -> blockState.getMaterial().isReplaceable())) {
                    if (pRandom.nextBoolean()) {
                        pBlockSetter.accept(mutable, provider.getState(pRandom, mutable));
                    }
                }
            }
        }
    }
}
