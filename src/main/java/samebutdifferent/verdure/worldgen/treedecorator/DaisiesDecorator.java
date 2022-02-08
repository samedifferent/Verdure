package samebutdifferent.verdure.worldgen.treedecorator;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureTreeDecoratorTypes;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class DaisiesDecorator extends TreeDecorator {
    public static final Codec<DaisiesDecorator> CODEC;
    public static final DaisiesDecorator INSTANCE = new DaisiesDecorator();

    @Override
    protected TreeDecoratorType<?> type() {
        return VerdureTreeDecoratorTypes.DAISIES.get();
    }

    @Override
    public void place(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, Random pRandom, List<BlockPos> pLogPositions, List<BlockPos> pLeafPositions) {
        pLeafPositions.forEach((pos -> {
            for (Direction direction : Direction.values()) {
                if (Feature.isAir(pLevel, pos.relative(direction))) {
                    pBlockSetter.accept(pos.relative(direction), VerdureBlocks.DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(direction.getOpposite()), true));
                }
            }
        }));
    }

    static {
        CODEC = Codec.unit(() -> {
            return INSTANCE;
        });
    }
}
