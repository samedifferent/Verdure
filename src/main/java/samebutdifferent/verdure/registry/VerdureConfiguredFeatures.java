package samebutdifferent.verdure.registry;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.BranchDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.DaisiesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.HollowLogDecorator;

import java.util.List;
import java.util.OptionalInt;

public class VerdureConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Verdure.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_STONE = CONFIGURED_FEATURES.register("boulder_stone", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.STONE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_DIORITE = CONFIGURED_FEATURES.register("boulder_diorite", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_GRANITE = CONFIGURED_FEATURES.register("boulder_granite", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_ANDESITE = CONFIGURED_FEATURES.register("boulder_andesite", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_SLATE = CONFIGURED_FEATURES.register("boulder_slate", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(VerdureBlocks.SLATE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOOTH_DIRT_PATCH = CONFIGURED_FEATURES.register("smooth_dirt_patch", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(), new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(4, 6), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOOTH_DIRT_PATCH_SWAMP = CONFIGURED_FEATURES.register("smooth_dirt_patch_swamp", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(), new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_CLOVER = CONFIGURED_FEATURES.register("patch_clover", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.CLOVER.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEBBLES = CONFIGURED_FEATURES.register("pebbles", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PEBBLES.get()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ROCK = CONFIGURED_FEATURES.register("rock", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.ROCK.get()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DAISIES = CONFIGURED_FEATURES.register("patch_daisies", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DAISIES_BLUE = CONFIGURED_FEATURES.register("patch_daisies_blue", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.BLUE_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DAISIES_PINK = CONFIGURED_FEATURES.register("patch_daisies_pink", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PINK_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_WILDFLOWERS = CONFIGURED_FEATURES.register("patch_wildflowers", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.WILDFLOWERS.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FALLEN_LOG = CONFIGURED_FEATURES.register("fallen_log", () -> new ConfiguredFeature<>(VerdureFeatures.FALLEN_LOG.get(), FeatureConfiguration.NONE));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MUSHROOM_SHELF = CONFIGURED_FEATURES.register("mushroom_shelf", () -> new ConfiguredFeature<>(VerdureFeatures.MUSHROOM_SHELF.get(), FeatureConfiguration.NONE));
    public static final RegistryObject<ConfiguredFeature<?, ?>> UNDERGROUND_MUSHROOM_SHELF = CONFIGURED_FEATURES.register("underground_mushroom_shelf", () -> new ConfiguredFeature<>(VerdureFeatures.UNDERGROUND_MUSHROOM_SHELF.get(), FeatureConfiguration.NONE));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_DAISIES = CONFIGURED_FEATURES.register("oak_daisies", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines().decorators(List.of(new DaisiesDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_DAISIES = CONFIGURED_FEATURES.register("birch_daisies", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 2, 0, 2).ignoreVines().decorators(List.of(new DaisiesDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_HOLLOW = CONFIGURED_FEATURES.register("oak_hollow", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5, 1, 0, 2).ignoreVines().decorators(List.of(new HollowLogDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_OAK_HOLLOW = CONFIGURED_FEATURES.register("fancy_oak_hollow", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().decorators(List.of(new HollowLogDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HANGING_MOSS = CONFIGURED_FEATURES.register("hanging_moss", () -> new ConfiguredFeature<>(VerdureFeatures.HANGING_MOSS.get(), new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(VerdureBlocks.HANGING_MOSS.get().defaultBlockState(), 1).add(VerdureBlocks.TALL_HANGING_MOSS.get().defaultBlockState(), 1)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HUMUS_PATCH = CONFIGURED_FEATURES.register("humus_patch", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(), new DiskConfiguration(VerdureBlocks.HUMUS.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_BRANCHES = CONFIGURED_FEATURES.register("oak_branches", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines().decorators(List.of(new BranchDecorator(BlockStateProvider.simple(VerdureBlocks.OAK_BRANCH.get())))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_BRANCHES = CONFIGURED_FEATURES.register("birch_branches", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 2, 0, 2).ignoreVines().decorators(List.of(new BranchDecorator(BlockStateProvider.simple(VerdureBlocks.BIRCH_BRANCH.get())))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_BIRCH_AND_OAK = CONFIGURED_FEATURES.register("trees_birch_and_oak", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(VerdurePlacedFeatures.BIRCH_BRANCHES.getHolder().get(), 0.2F), new WeightedPlacedFeature(TreePlacements.FANCY_OAK_BEES_0002, 0.1F)), VerdurePlacedFeatures.OAK_BRANCHES.getHolder().get())));

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock, int baseTrunkHeight, int heightRandA, int heightRandB, int foliageRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock), new StraightTrunkPlacer(baseTrunkHeight, heightRandA, heightRandB), BlockStateProvider.simple(leavesBlock), new BlobFoliagePlacer(ConstantInt.of(foliageRadius), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
}
