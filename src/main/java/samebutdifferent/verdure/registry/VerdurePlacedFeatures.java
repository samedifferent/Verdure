package samebutdifferent.verdure.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import samebutdifferent.verdure.Verdure;

import java.util.List;

public class VerdurePlacedFeatures {
private static final BlockPredicate ROCK_PREDICATE = BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.PODZOL, Blocks.COARSE_DIRT, VerdureBlocks.SMOOTH_DIRT.get(), Blocks.SAND), new BlockPos(0, -1, 0));

    public static final Holder<PlacedFeature> BOULDER_STONE = register("boulder_stone", VerdureConfiguredFeatures.BOULDER_STONE, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.BOULDER_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_DIORITE = register("boulder_diorite", VerdureConfiguredFeatures.BOULDER_DIORITE, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.BOULDER_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_GRANITE = register("boulder_granite", VerdureConfiguredFeatures.BOULDER_GRANITE, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.BOULDER_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_ANDESITE = register("boulder_andesite", VerdureConfiguredFeatures.BOULDER_ANDESITE, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.BOULDER_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_SLATE = register("boulder_slate", VerdureConfiguredFeatures.BOULDER_SLATE, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.BOULDER_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> SMOOTH_DIRT_PATCH = register("smooth_dirt_patch", VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.SMOOTH_DIRT_PATCH_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> SMOOTH_DIRT_PATCH_SWAMP = register("smooth_dirt_patch_swamp", VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH_SWAMP, List.of(RarityFilter.onAverageOnceEvery(Math.round(VerdureConfig.SMOOTH_DIRT_PATCH_RARITY.get() / 2.0F)), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PATCH_CLOVER = register("patch_clover", VerdureConfiguredFeatures.PATCH_CLOVER, worldSurfaceSquaredWithRarityFilter(VerdureConfig.CLOVER_PATCH_RARITY.get()));
    public static final Holder<PlacedFeature> PEBBLES = register("pebbles", VerdureConfiguredFeatures.PEBBLES, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.PEBBLES_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(ROCK_PREDICATE), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> ROCK = register("rock", VerdureConfiguredFeatures.ROCK, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.ROCK_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(ROCK_PREDICATE), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PATCH_DAISIES = register("patch_daisies", VerdureConfiguredFeatures.PATCH_DAISIES, worldSurfaceSquaredWithRarityFilter(VerdureConfig.DAISIES_PATCH_RARITY.get()));
    public static final Holder<PlacedFeature> PATCH_DAISIES_BLUE = register("patch_daisies_blue", VerdureConfiguredFeatures.PATCH_DAISIES_BLUE, worldSurfaceSquaredWithRarityFilter(VerdureConfig.DAISIES_PATCH_RARITY.get()));
    public static final Holder<PlacedFeature> PATCH_DAISIES_PINK = register("patch_daisies_pink", VerdureConfiguredFeatures.PATCH_DAISIES_PINK, worldSurfaceSquaredWithRarityFilter(VerdureConfig.DAISIES_PATCH_RARITY.get()));
    public static final Holder<PlacedFeature> PATCH_WILDFLOWERS = register("patch_wildflowers", VerdureConfiguredFeatures.PATCH_WILDFLOWERS, worldSurfaceSquaredWithRarityFilter(VerdureConfig.DAISIES_PATCH_RARITY.get()));
    public static final Holder<PlacedFeature> FALLEN_LOG = register("fallen_log", VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(VerdureConfig.FALLEN_LOG_RARITY.get()));
    public static final Holder<PlacedFeature> FALLEN_LOG_SAVANNA = register("fallen_log_savanna", VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(Math.round(VerdureConfig.FALLEN_LOG_RARITY.get() * 1.5F)));
    public static final Holder<PlacedFeature> FALLEN_LOG_NETHER = register("fallen_log_nether", VerdureConfiguredFeatures.FALLEN_LOG, List.of(CountOnEveryLayerPlacement.of(VerdureConfig.FALLEN_LOG_NETHER_COUNT.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> MUSHROOM_SHELF = register("mushroom_shelf", VerdureConfiguredFeatures.MUSHROOM_SHELF, List.of(CountPlacement.of(VerdureConfig.MUSHROOM_SHELF_SURFACE_COUNT.get()), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> UNDERGROUND_MUSHROOM_SHELF = register("underground_mushroom_shelf", VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF, List.of(CountPlacement.of(UniformInt.of(VerdureConfig.MUSHROOM_SHELF_UNDERGROUND_COUNT_MIN.get(), VerdureConfig.MUSHROOM_SHELF_UNDERGROUND_COUNT_MAX.get())), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> OAK_DAISIES = register("oak_daisies", VerdureConfiguredFeatures.OAK_DAISIES, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.DAISY_TREE_RARITY.get()), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BIRCH_DAISIES = register("birch_daisies", VerdureConfiguredFeatures.BIRCH_DAISIES, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.DAISY_TREE_RARITY.get()), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.BIRCH_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> OAK_HOLLOW = register("oak_hollow", VerdureConfiguredFeatures.OAK_HOLLOW, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.OAK_HOLLOW_RARITY.get()), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> FANCY_OAK_HOLLOW = register("fancy_oak_hollow", VerdureConfiguredFeatures.FANCY_OAK_HOLLOW, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.OAK_HOLLOW_RARITY.get()), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> HANGING_MOSS = register("hanging_moss", VerdureConfiguredFeatures.HANGING_MOSS, List.of(CountPlacement.of(VerdureConfig.HANGING_MOSS_COUNT.get()), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> HUMUS_PATCH = register("humus_patch", VerdureConfiguredFeatures.HUMUS_PATCH, List.of(RarityFilter.onAverageOnceEvery(VerdureConfig.HUMUS_PATCH_RARITY.get()), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> OAK_BRANCHES = register("oak_branches", VerdureConfiguredFeatures.OAK_BRANCHES, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
    public static final Holder<PlacedFeature> BIRCH_BRANCHES = register("birch_branches", VerdureConfiguredFeatures.BIRCH_BRANCHES, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING)));
    public static final Holder<PlacedFeature> TREES_BIRCH_AND_OAK = register("trees_birch_and_oak", VerdureConfiguredFeatures.TREES_BIRCH_AND_OAK, VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));

    private static Holder<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return PlacementUtils.register(new ResourceLocation(Verdure.MOD_ID, name).toString(), feature, modifiers);
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }
}
