package samebutdifferent.verdure.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import samebutdifferent.verdure.block.MushroomShelfBlock;
import samebutdifferent.verdure.registry.VerdureBlocks;

public class MushroomShelfFeature extends Feature<NoneFeatureConfiguration> {
    public MushroomShelfFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        BlockState state = context.random().nextInt(2) == 0 ? VerdureBlocks.BROWN_MUSHROOM_SHELF.get().defaultBlockState() : VerdureBlocks.RED_MUSHROOM_SHELF.get().defaultBlockState();
        if (level.isEmptyBlock(pos)) {
            for (Direction direction : Direction.values()) {
                if (direction.getAxis().isHorizontal() && level.getBlockState(pos.relative(direction)).is(BlockTags.LOGS)) {
                    level.setBlock(pos, state.setValue(MushroomShelfBlock.FACING, direction.getOpposite()), 2);
                    return true;
                }
            }

        }
        return false;
    }
}
