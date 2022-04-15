package samebutdifferent.verdure.worldgen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.SimpleBlockFeature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import samebutdifferent.verdure.block.TallHangingMossBlock;

public class HangingMossFeature extends SimpleBlockFeature {
    public HangingMossFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> context) {
        SimpleBlockConfiguration config = context.config();
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        BlockState blockstate = config.toPlace().getState(context.random(), pos);
        if (blockstate.canSurvive(level, pos)) {
            if (blockstate.getBlock() instanceof TallHangingMossBlock) {
                if (!level.isEmptyBlock(pos.below())) {
                    return false;
                }

                TallHangingMossBlock.placeAt(level, blockstate, pos, 2);
            } else {
                level.setBlock(pos, blockstate, 2);
            }

            return true;
        } else {
            return false;
        }
    }
}
