package samebutdifferent.verdure.registry;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import samebutdifferent.verdure.Verdure;

public class VerdureConfiguredFeatures {



    public static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> registerConfiguredFeature(String pKey, ConfiguredFeature<FC, ?> pConfiguredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Verdure.MOD_ID, pKey), pConfiguredFeature);
    }

    public static void register() {

    }
}
