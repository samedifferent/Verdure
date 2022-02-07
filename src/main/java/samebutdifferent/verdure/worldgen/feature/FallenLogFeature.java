package samebutdifferent.verdure.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Material;

import java.util.Random;

public class FallenLogFeature extends Feature<NoneFeatureConfiguration> {
    public FallenLogFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        Random random = context.random();
        BlockState log = this.getBiomeLog(level, origin);
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        BlockPos.MutableBlockPos mutable = origin.mutable();

        // check for available space
        for (int i = 0; i < 4; i++) {
            if ((level.getBlockState(mutable).getMaterial().isReplaceable() || level.getBlockState(mutable).getMaterial().equals(Material.DECORATION)) && level.getBlockState(mutable.below()).is(BlockTags.DIRT)) {
                mutable.move(direction);
            } else {
                return false;
            }
        }

        mutable.set(origin);

        // place logs
        for (int i = 0; i < 4; i++) {
            level.setBlock(mutable.move(direction), log.setValue(RotatedPillarBlock.AXIS, direction.getAxis()), 3);
        }

        return true;
    }

    private BlockState getBiomeLog(WorldGenLevel level, BlockPos pos) {
        Biome biome = level.getBiome(pos);
        if (biome.getRegistryName().getPath().equals("birch_forest")) {
            return Blocks.BIRCH_LOG.defaultBlockState();
        } else {
            switch (biome.getBiomeCategory()) {
                case JUNGLE -> {
                    return Blocks.JUNGLE_LOG.defaultBlockState();
                }
                case TAIGA -> {
                    return Blocks.SPRUCE_LOG.defaultBlockState();
                }
                case SAVANNA -> {
                    return Blocks.ACACIA_LOG.defaultBlockState();
                }
                default -> {
                    return Blocks.OAK_LOG.defaultBlockState();
                }
            }
        }
    }
}
