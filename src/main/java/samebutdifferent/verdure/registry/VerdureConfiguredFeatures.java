package samebutdifferent.verdure.registry;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import samebutdifferent.verdure.Verdure;

import java.util.List;

public class VerdureConfiguredFeatures {

    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_STONE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.STONE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_DIORITE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_GRANITE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_ANDESITE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_SLATE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(VerdureBlocks.SLATE.get().defaultBlockState()));
    public static final ConfiguredFeature<DiskConfiguration, ?> SMOOTH_DIRT_PATCH = VerdureFeatures.SMOOTH_DIRT_PATCH.get().configured(new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(2, 3), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState())));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_CLOVER = Feature.RANDOM_PATCH.configured(FeatureUtils.simpleRandomPatchConfiguration(32, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.CLOVER.get()))).onlyWhenEmpty()));

    public static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> registerConfiguredFeature(String pKey, ConfiguredFeature<FC, ?> pConfiguredFeature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Verdure.MOD_ID, pKey), pConfiguredFeature);
    }

    public static void register() {
        registerConfiguredFeature("boulder_stone", BOULDER_STONE);
        registerConfiguredFeature("boulder_diorite", BOULDER_DIORITE);
        registerConfiguredFeature("boulder_granite", BOULDER_GRANITE);
        registerConfiguredFeature("boulder_andesite", BOULDER_ANDESITE);
        registerConfiguredFeature("boulder_slate", BOULDER_SLATE);
        registerConfiguredFeature("smooth_dirt_patch", SMOOTH_DIRT_PATCH);
        registerConfiguredFeature("patch_clover", PATCH_CLOVER);
    }
}
