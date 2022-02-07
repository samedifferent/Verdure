package samebutdifferent.verdure.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.BaseDiskFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;

public class SmoothDirtPatchFeature extends BaseDiskFeature {
    public SmoothDirtPatchFeature(Codec<DiskConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<DiskConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();

        BlockPos blockpos;
        for(blockpos = context.origin(); worldgenlevel.isEmptyBlock(blockpos) && blockpos.getY() > worldgenlevel.getMinBuildHeight() + 2; blockpos = blockpos.below()) {
        }

        return worldgenlevel.getBlockState(blockpos).is(Blocks.GRASS_BLOCK) && super.place(new FeaturePlaceContext<>(context.topFeature(), worldgenlevel, context.chunkGenerator(), context.random(), blockpos, context.config()));
    }
}
