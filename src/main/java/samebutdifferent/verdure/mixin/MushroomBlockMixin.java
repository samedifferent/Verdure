package samebutdifferent.verdure.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.MushroomBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import samebutdifferent.verdure.registry.VerdureConfig;

@Mixin(MushroomBlock.class)
public class MushroomBlockMixin extends BushBlock {
    public MushroomBlockMixin(Properties properties) {
        super(properties);
    }

    @Redirect(method = "canSurvive", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelReader;getRawBrightness(Lnet/minecraft/core/BlockPos;I)I"))
    private int onGetRawBrightness(LevelReader pLevel, BlockPos pBlockPos, int pAmount) {
        if (VerdureConfig.REMOVE_MUSHROOM_LIGHT_LEVEL.get()) {
            return 12;
        } else {
            return pLevel.getLightEngine().getRawBrightness(pBlockPos, pAmount);
        }
    }

}
