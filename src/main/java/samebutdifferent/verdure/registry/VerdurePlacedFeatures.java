package samebutdifferent.verdure.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class VerdurePlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Verdure.MOD_ID);

    // MISC OVERWORLD PLACEMENTS
    public static final RegistryObject<PlacedFeature> BOULDER_STONE = PLACED_FEATURES.register("boulder_stone", () -> new PlacedFeature(VerdureConfiguredFeatures.BOULDER_STONE.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> BOULDER_DIORITE = PLACED_FEATURES.register("boulder_diorite", () -> new PlacedFeature(VerdureConfiguredFeatures.BOULDER_DIORITE.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> BOULDER_GRANITE = PLACED_FEATURES.register("boulder_granite", () -> new PlacedFeature(VerdureConfiguredFeatures.BOULDER_GRANITE.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> BOULDER_ANDESITE = PLACED_FEATURES.register("boulder_andesite", () -> new PlacedFeature(VerdureConfiguredFeatures.BOULDER_ANDESITE.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> BOULDER_SLATE = PLACED_FEATURES.register("boulder_slate", () -> new PlacedFeature(VerdureConfiguredFeatures.BOULDER_SLATE.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> SMOOTH_DIRT_PATCH = PLACED_FEATURES.register("smooth_dirt_patch", () -> new PlacedFeature(VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> SMOOTH_DIRT_PATCH_SWAMP = PLACED_FEATURES.register("smooth_dirt_patch_swamp", () -> new PlacedFeature(VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH_SWAMP.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> HUMUS_PATCH = PLACED_FEATURES.register("humus_patch", () -> new PlacedFeature(VerdureConfiguredFeatures.HUMUS_PATCH.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    // VEGETATION PLACEMENTS
    public static final RegistryObject<PlacedFeature> PATCH_CLOVER = PLACED_FEATURES.register("patch_clover", () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_CLOVER.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(5)));
    public static final RegistryObject<PlacedFeature> PEBBLES = PLACED_FEATURES.register("pebbles", () -> new PlacedFeature(VerdureConfiguredFeatures.PEBBLES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.PODZOL, Blocks.COARSE_DIRT, VerdureBlocks.SMOOTH_DIRT.get(), Blocks.SAND), new BlockPos(0, -1, 0))), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> ROCK = PLACED_FEATURES.register("rock", () -> new PlacedFeature(VerdureConfiguredFeatures.ROCK.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.PODZOL, Blocks.COARSE_DIRT, VerdureBlocks.SMOOTH_DIRT.get(), Blocks.SAND), new BlockPos(0, -1, 0))), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> PATCH_DAISIES = PLACED_FEATURES.register("patch_daisies", () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_DAISIES.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(14)));
    public static final RegistryObject<PlacedFeature> PATCH_DAISIES_BLUE = PLACED_FEATURES.register("patch_daisies_blue", () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_DAISIES_BLUE.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(14)));
    public static final RegistryObject<PlacedFeature> PATCH_DAISIES_PINK = PLACED_FEATURES.register("patch_daisies_pink", () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_DAISIES_PINK.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(14)));
    public static final RegistryObject<PlacedFeature> PATCH_WILDFLOWERS = PLACED_FEATURES.register("patch_wildflowers", () -> new PlacedFeature(VerdureConfiguredFeatures.PATCH_WILDFLOWERS.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(14)));
    public static final RegistryObject<PlacedFeature> FALLEN_LOG = PLACED_FEATURES.register("fallen_log", () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(7)));
    public static final RegistryObject<PlacedFeature> FALLEN_LOG_SAVANNA = PLACED_FEATURES.register("fallen_log_savanna", () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG.getHolder().orElseThrow(), worldSurfaceSquaredWithRarityFilter(11)));
    public static final RegistryObject<PlacedFeature> MUSHROOM_SHELF = PLACED_FEATURES.register("mushroom_shelf", () -> new PlacedFeature(VerdureConfiguredFeatures.MUSHROOM_SHELF.getHolder().orElseThrow(), List.of(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> TREES_BIRCH_AND_OAK = PLACED_FEATURES.register("trees_birch_and_oak", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_BIRCH_AND_OAK.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> DARK_FOREST_VEGETATION = PLACED_FEATURES.register("dark_forest_vegetation", () -> new PlacedFeature(VerdureConfiguredFeatures.DARK_FOREST_VEGETATION.getHolder().orElseThrow(), List.of(CountPlacement.of(16), InSquarePlacement.spread(), VegetationPlacements.TREE_THRESHOLD, PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> TREES_TAIGA = PLACED_FEATURES.register("trees_taiga", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_TAIGA.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> TREES_WINDSWEPT_SAVANNA = PLACED_FEATURES.register("trees_windswept_savanna", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_SAVANNA.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> TREES_SAVANNA = PLACED_FEATURES.register("trees_savanna", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_SAVANNA.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(1, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> BIRCH_TALL = PLACED_FEATURES.register("birch_tall", () -> new PlacedFeature(VerdureConfiguredFeatures.BIRCH_TALL.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> TREES_BIRCH = PLACED_FEATURES.register("trees_birch", () -> new PlacedFeature(VerdureConfiguredFeatures.BIRCH.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.BIRCH_SAPLING)));
    public static final RegistryObject<PlacedFeature> TREES_JUNGLE = PLACED_FEATURES.register("trees_jungle", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_JUNGLE.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(50, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> TREES_SPARSE_JUNGLE = PLACED_FEATURES.register("trees_sparse_jungle", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_SPARSE_JUNGLE.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(2, 0.1F, 1))));
    public static final RegistryObject<PlacedFeature> TREES_FLOWER_FOREST = PLACED_FEATURES.register("trees_flower_forest", () -> new PlacedFeature(VerdureConfiguredFeatures.TREES_FLOWER_FOREST.getHolder().orElseThrow(), treePlacement(PlacementUtils.countExtra(6, 0.1F, 1))));

    // CAVE PLACEMENTS
    public static final RegistryObject<PlacedFeature> UNDERGROUND_MUSHROOM_SHELF = PLACED_FEATURES.register("underground_mushroom_shelf", () -> new PlacedFeature(VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF.getHolder().orElseThrow(), List.of(CountPlacement.of(UniformInt.of(104, 157)), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> HANGING_MOSS = PLACED_FEATURES.register("hanging_moss", () -> new PlacedFeature(VerdureConfiguredFeatures.HANGING_MOSS.getHolder().orElseThrow(), List.of(CountPlacement.of(128), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome())));

    // TREE PLACEMENTS
    public static final RegistryObject<PlacedFeature> OAK_DAISIES = PLACED_FEATURES.register("oak_daisies", () -> new PlacedFeature(VerdureConfiguredFeatures.OAK_DAISIES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> BIRCH_DAISIES = PLACED_FEATURES.register("birch_daisies", () -> new PlacedFeature(VerdureConfiguredFeatures.BIRCH_DAISIES.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(13), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.BIRCH_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> OAK_HOLLOW = PLACED_FEATURES.register("oak_hollow", () -> new PlacedFeature(VerdureConfiguredFeatures.OAK_HOLLOW.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> FANCY_OAK_HOLLOW = PLACED_FEATURES.register("fancy_oak_hollow", () -> new PlacedFeature(VerdureConfiguredFeatures.FANCY_OAK_HOLLOW.getHolder().orElseThrow(), List.of(RarityFilter.onAverageOnceEvery(10), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> OAK_CHECKED = PLACED_FEATURES.register("oak_checked", () -> new PlacedFeature(VerdureConfiguredFeatures.OAK.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
    public static final RegistryObject<PlacedFeature> BIRCH_CHECKED = PLACED_FEATURES.register("birch_checked", () -> new PlacedFeature(VerdureConfiguredFeatures.BIRCH.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
    public static final RegistryObject<PlacedFeature> SUPER_BIRCH_CHECKED = PLACED_FEATURES.register("super_birch_checked", () -> new PlacedFeature(VerdureConfiguredFeatures.SUPER_BIRCH.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING))));
    public static final RegistryObject<PlacedFeature> DARK_OAK_CHECKED = PLACED_FEATURES.register("dark_oak_checked", () -> new PlacedFeature(VerdureConfiguredFeatures.DARK_OAK.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.DARK_OAK_SAPLING))));
    public static final RegistryObject<PlacedFeature> SPRUCE_CHECKED = PLACED_FEATURES.register("spruce_checked",  () -> new PlacedFeature(VerdureConfiguredFeatures.SPRUCE.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING))));
    public static final RegistryObject<PlacedFeature> PINE_CHECKED = PLACED_FEATURES.register("pine_checked",  () -> new PlacedFeature(VerdureConfiguredFeatures.PINE.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING))));
    public static final RegistryObject<PlacedFeature> ACACIA_CHECKED = PLACED_FEATURES.register("acacia_checked",  () -> new PlacedFeature(VerdureConfiguredFeatures.ACACIA.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.ACACIA_SAPLING))));
    public static final RegistryObject<PlacedFeature> JUNGLE_TREE_CHECKED = PLACED_FEATURES.register("jungle_tree_checked",  () -> new PlacedFeature(VerdureConfiguredFeatures.JUNGLE_TREE.getHolder().orElseThrow(), List.of(PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING))));

    // NETHER PLACEMENTS
    public static final RegistryObject<PlacedFeature> FALLEN_LOG_NETHER = PLACED_FEATURES.register("fallen_log_nether", () -> new PlacedFeature(VerdureConfiguredFeatures.FALLEN_LOG.getHolder().orElseThrow(), List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome())));

    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }
}
