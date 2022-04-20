package samebutdifferent.verdure.registry;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.DaisiesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.HollowLogDecorator;

import java.util.List;
import java.util.OptionalInt;

public class VerdureConfiguredFeatures {

    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> BOULDER_STONE = register("boulder_stone", Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.STONE.defaultBlockState()));
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> BOULDER_DIORITE = register("boulder_diorite", Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState()));
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> BOULDER_GRANITE = register("boulder_granite", Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState()));
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> BOULDER_ANDESITE = register("boulder_andesite", Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState()));
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> BOULDER_SLATE = register("boulder_slate", Feature.FOREST_ROCK, new BlockStateConfiguration(VerdureBlocks.SLATE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> SMOOTH_DIRT_PATCH = register("smooth_dirt_patch", VerdureFeatures.SMOOTH_DIRT_PATCH.get(), new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(2, 6), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState())));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> SMOOTH_DIRT_PATCH_SWAMP = register("smooth_dirt_patch_swamp", VerdureFeatures.SMOOTH_DIRT_PATCH.get(), new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_CLOVER = register("patch_clover", Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.CLOVER.get())))));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> PEBBLES = register("pebbles", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PEBBLES.get())));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> ROCK = register("rock", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.ROCK.get())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DAISIES = register("patch_daisies", Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DAISIES_BLUE = register("patch_daisies_blue", Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.BLUE_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DAISIES_PINK = register("patch_daisies_pink", Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PINK_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true))))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_WILDFLOWERS = register("patch_wildflowers", Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.WILDFLOWERS.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true))))));
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> FALLEN_LOG = register("fallen_log", VerdureFeatures.FALLEN_LOG.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MUSHROOM_SHELF = register("mushroom_shelf", VerdureFeatures.MUSHROOM_SHELF.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> UNDERGROUND_MUSHROOM_SHELF = register("underground_mushroom_shelf", VerdureFeatures.UNDERGROUND_MUSHROOM_SHELF.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> OAK_DAISIES = register("oak_daisies", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new DaisiesDecorator())).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BIRCH_DAISIES = register("birch_daisies", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new DaisiesDecorator())).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> OAK_HOLLOW = register("oak_hollow", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(5, 1, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new HollowLogDecorator())).build());
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> FANCY_OAK_HOLLOW = register("fancy_oak_hollow", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().decorators(List.of(new HollowLogDecorator())).build());
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> HANGING_MOSS = register("hanging_moss", VerdureFeatures.HANGING_MOSS.get(), new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(VerdureBlocks.HANGING_MOSS.get().defaultBlockState(), 1).add(VerdureBlocks.TALL_HANGING_MOSS.get().defaultBlockState(), 1))));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> HUMUS_PATCH = register("humus_patch", VerdureFeatures.SMOOTH_DIRT_PATCH.get(), new DiskConfiguration(VerdureBlocks.HUMUS.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState())));

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(String name, F feature, FC configuration) {
        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Verdure.MOD_ID, name).toString(), new ConfiguredFeature<>(feature, configuration));
    }

    public static void load() {
    }
}
