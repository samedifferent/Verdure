package samebutdifferent.verdure.mixin;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.DarkOakTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import samebutdifferent.verdure.registry.VerdureConfig;
import samebutdifferent.verdure.registry.VerdureConfiguredFeatures;

import java.util.Random;

@Mixin(DarkOakTreeGrower.class)
public class DarkOakTreeGrowerMixin extends AbstractMegaTreeGrower {

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random random, boolean largeHive) {
        return null;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(Random random) {
        if (VerdureConfig.GENERATE_DARK_OAK_HUMUS.get()) {
            return VerdureConfiguredFeatures.DARK_OAK_NO_LEAVES.getHolder().get();
        } else {
            return TreeFeatures.DARK_OAK;
        }
    }
}
