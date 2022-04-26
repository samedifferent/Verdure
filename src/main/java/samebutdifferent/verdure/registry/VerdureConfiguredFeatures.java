package samebutdifferent.verdure.registry;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
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
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.BranchDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.DaisiesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.FallenLeavesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.HollowLogDecorator;

import java.util.List;
import java.util.OptionalInt;

public class VerdureConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Verdure.MOD_ID);

    // MISC OVERWORLD FEATURES
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_STONE = CONFIGURED_FEATURES.register("boulder_stone", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.STONE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_DIORITE = CONFIGURED_FEATURES.register("boulder_diorite", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_GRANITE = CONFIGURED_FEATURES.register("boulder_granite", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_ANDESITE = CONFIGURED_FEATURES.register("boulder_andesite", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BOULDER_SLATE = CONFIGURED_FEATURES.register("boulder_slate", () -> new ConfiguredFeature<>(Feature.FOREST_ROCK, new BlockStateConfiguration(VerdureBlocks.SLATE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOOTH_DIRT_PATCH = CONFIGURED_FEATURES.register("smooth_dirt_patch", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(), new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(4, 6), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOOTH_DIRT_PATCH_SWAMP = CONFIGURED_FEATURES.register("smooth_dirt_patch_swamp", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(), new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HUMUS_PATCH = CONFIGURED_FEATURES.register("humus_patch", () -> new ConfiguredFeature<>(VerdureFeatures.DITHERED_DISK.get(), new DiskConfiguration(VerdureBlocks.HUMUS.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState()))));

    // VEGETATION FEATURES
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_CLOVER = CONFIGURED_FEATURES.register("patch_clover", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(64, 5, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.CLOVER.get()))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEBBLES = CONFIGURED_FEATURES.register("pebbles", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PEBBLES.get()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ROCK = CONFIGURED_FEATURES.register("rock", () -> new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.ROCK.get()))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DAISIES = CONFIGURED_FEATURES.register("patch_daisies", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DAISIES_BLUE = CONFIGURED_FEATURES.register("patch_daisies_blue", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.BLUE_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_DAISIES_PINK = CONFIGURED_FEATURES.register("patch_daisies_pink", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PINK_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PATCH_WILDFLOWERS = CONFIGURED_FEATURES.register("patch_wildflowers", () -> new ConfiguredFeature<>(Feature.RANDOM_PATCH, new RandomPatchConfiguration(48, 2, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.WILDFLOWERS.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true)))))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FALLEN_LOG = CONFIGURED_FEATURES.register("fallen_log", () -> new ConfiguredFeature<>(VerdureFeatures.FALLEN_LOG.get(), FeatureConfiguration.NONE));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MUSHROOM_SHELF = CONFIGURED_FEATURES.register("mushroom_shelf", () -> new ConfiguredFeature<>(VerdureFeatures.MUSHROOM_SHELF.get(), FeatureConfiguration.NONE));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_BIRCH_AND_OAK = CONFIGURED_FEATURES.register("trees_birch_and_oak", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(VerdurePlacedFeatures.BIRCH_CHECKED.getHolder().get(), 0.2F), new WeightedPlacedFeature(TreePlacements.FANCY_OAK_BEES_0002, 0.1F)), VerdurePlacedFeatures.OAK_CHECKED.getHolder().get())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DARK_FOREST_VEGETATION = CONFIGURED_FEATURES.register("dark_forest_vegetation", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(TreeFeatures.HUGE_BROWN_MUSHROOM), 0.025F), new WeightedPlacedFeature(PlacementUtils.inlinePlaced(TreeFeatures.HUGE_RED_MUSHROOM), 0.05F), new WeightedPlacedFeature(VerdurePlacedFeatures.DARK_OAK_CHECKED.getHolder().get(), 0.6666667F), new WeightedPlacedFeature(TreePlacements.BIRCH_CHECKED, 0.2F), new WeightedPlacedFeature(TreePlacements.FANCY_OAK_CHECKED, 0.1F)), TreePlacements.OAK_CHECKED)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TREES_TAIGA = CONFIGURED_FEATURES.register("trees_taiga", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(VerdurePlacedFeatures.PINE_CHECKED.getHolder().get(), 0.33333334F)), VerdurePlacedFeatures.SPRUCE_CHECKED.getHolder().get())));

    // CAVE FEATURES
    public static final RegistryObject<ConfiguredFeature<?, ?>> UNDERGROUND_MUSHROOM_SHELF = CONFIGURED_FEATURES.register("underground_mushroom_shelf", () -> new ConfiguredFeature<>(VerdureFeatures.UNDERGROUND_MUSHROOM_SHELF.get(), FeatureConfiguration.NONE));
    public static final RegistryObject<ConfiguredFeature<?, ?>> HANGING_MOSS = CONFIGURED_FEATURES.register("hanging_moss", () -> new ConfiguredFeature<>(VerdureFeatures.HANGING_MOSS.get(), new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(VerdureBlocks.HANGING_MOSS.get().defaultBlockState(), 1).add(VerdureBlocks.TALL_HANGING_MOSS.get().defaultBlockState(), 1)))));

    // TREE FEATURES
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_DAISIES = CONFIGURED_FEATURES.register("oak_daisies", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines().decorators(List.of(new DaisiesDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_DAISIES = CONFIGURED_FEATURES.register("birch_daisies", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 2, 0, 2).ignoreVines().decorators(List.of(new DaisiesDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_HOLLOW = CONFIGURED_FEATURES.register("oak_hollow", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 5, 1, 0, 2).ignoreVines().decorators(List.of(new HollowLogDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> FANCY_OAK_HOLLOW = CONFIGURED_FEATURES.register("fancy_oak_hollow", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().decorators(List.of(new HollowLogDecorator())).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK = CONFIGURED_FEATURES.register("oak", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.OAK_LOG, Blocks.OAK_LEAVES, 4, 2, 0, 2).ignoreVines().decorators(List.of(new BranchDecorator(VerdureBlocks.OAK_BRANCH.get().defaultBlockState()), new FallenLeavesDecorator(VerdureBlocks.FALLEN_OAK_LEAVES.get().defaultBlockState()))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH = CONFIGURED_FEATURES.register("birch", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 2, 0, 2).ignoreVines().decorators(List.of(new BranchDecorator(VerdureBlocks.BIRCH_BRANCH.get().defaultBlockState()), new FallenLeavesDecorator(VerdureBlocks.FALLEN_BIRCH_LEAVES.get().defaultBlockState()))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DARK_OAK = CONFIGURED_FEATURES.register("dark_oak", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.DARK_OAK_LOG), new DarkOakTrunkPlacer(6, 2, 1), BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().decorators(List.of(new AlterGroundDecorator(BlockStateProvider.simple(VerdureBlocks.HUMUS.get())))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SPRUCE = CONFIGURED_FEATURES.register("spruce", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(new FallenLeavesDecorator(VerdureBlocks.FALLEN_SPRUCE_LEAVES.get().defaultBlockState()))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PINE = CONFIGURED_FEATURES.register("pine", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG), new StraightTrunkPlacer(6, 4, 0), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES), new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(new FallenLeavesDecorator(VerdureBlocks.FALLEN_SPRUCE_LEAVES.get().defaultBlockState()))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ACACIA = CONFIGURED_FEATURES.register("acacia", () -> new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.ACACIA_LOG), new ForkingTrunkPlacer(5, 2, 2), BlockStateProvider.simple(Blocks.ACACIA_LEAVES), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().decorators(List.of(new FallenLeavesDecorator(VerdureBlocks.FALLEN_ACACIA_LEAVES.get().defaultBlockState()))).build()));
    public static final RegistryObject<ConfiguredFeature<?, ?>> JUNGLE_TREE = CONFIGURED_FEATURES.register("jungle_tree", () -> new ConfiguredFeature<>(Feature.TREE, createStraightBlobTree(Blocks.JUNGLE_LOG, Blocks.JUNGLE_LEAVES, 4, 8, 0, 2).decorators(ImmutableList.of(new CocoaDecorator(0.2F), TrunkVineDecorator.INSTANCE, LeaveVineDecorator.INSTANCE)).ignoreVines().build()));

    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leavesBlock, int baseTrunkHeight, int heightRandA, int heightRandB, int foliageRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock), new StraightTrunkPlacer(baseTrunkHeight, heightRandA, heightRandB), BlockStateProvider.simple(leavesBlock), new BlobFoliagePlacer(ConstantInt.of(foliageRadius), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
}
