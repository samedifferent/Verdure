package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class BranchDecorator extends TreeDecorator {
    public static final Codec<BranchDecorator> CODEC = BlockStateProvider.CODEC.fieldOf("branch").xmap(BranchDecorator::new, (decorator) -> decorator.provider).codec();
    private final BlockStateProvider provider;

    public BranchDecorator(BlockStateProvider provider) {
        this.provider = provider;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.BRANCH.get();
    }

    @Override
    public void place(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, List<BlockPos> pLogPositions, List<BlockPos> pLeafPositions) {
        if (!pLeafPositions.isEmpty()) {
            int lowestLeafY = pLeafPositions.get(0).getY();
            List<BlockPos> exposedLogs = pLogPositions.stream().filter(blockPos -> blockPos.getY() < lowestLeafY).toList();
            Direction zRand = pRandom.nextBoolean() ? Direction.NORTH : Direction.SOUTH;
            Direction xRand = pRandom.nextBoolean() ? Direction.EAST : Direction.WEST;
            BlockPos posFirst = exposedLogs.get(exposedLogs.size() - 1);
            BlockPos posSecond = exposedLogs.get(exposedLogs.size() - 2);
            if (exposedLogs.size() < 4) {
                Direction direction = pRandom.nextBoolean() ? xRand : zRand;
                if (Feature.isAir(pLevel, posFirst.relative(direction))) {
                    pBlockSetter.accept(posFirst.relative(direction), this.provider.getState(pRandom, posFirst).setValue(HorizontalDirectionalBlock.FACING, direction));
                }
            } else {
                if (Feature.isAir(pLevel, posFirst.relative(xRand))) {
                    pBlockSetter.accept(posFirst.relative(xRand), this.provider.getState(pRandom, posFirst).setValue(HorizontalDirectionalBlock.FACING, xRand));
                }
                if (Feature.isAir(pLevel, posSecond.relative(zRand))) {
                    pBlockSetter.accept(posSecond.relative(zRand), this.provider.getState(pRandom, posSecond).setValue(HorizontalDirectionalBlock.FACING, zRand));
                }
            }
        }
    }
}
