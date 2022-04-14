package samebutdifferent.verdure.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
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

    public static final Holder<PlacedFeature> BOULDER_STONE = register("boulder_stone", VerdureConfiguredFeatures.BOULDER_STONE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_DIORITE = register("boulder_diorite", VerdureConfiguredFeatures.BOULDER_DIORITE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_GRANITE = register("boulder_granite", VerdureConfiguredFeatures.BOULDER_GRANITE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_ANDESITE = register("boulder_andesite", VerdureConfiguredFeatures.BOULDER_ANDESITE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BOULDER_SLATE = register("boulder_slate", VerdureConfiguredFeatures.BOULDER_SLATE, List.of(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> SMOOTH_DIRT_PATCH = register("smooth_dirt_patch", VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH, List.of(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> SMOOTH_DIRT_PATCH_SWAMP = register("smooth_dirt_patch_swamp", VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH_SWAMP, List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PATCH_CLOVER = register("patch_clover", VerdureConfiguredFeatures.PATCH_CLOVER, worldSurfaceSquaredWithRarityFilter(5));
    public static final Holder<PlacedFeature> PATCH_PEBBLES = register("patch_pebbles", VerdureConfiguredFeatures.PATCH_PEBBLES, List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(ROCK_PREDICATE), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PATCH_ROCK = register("patch_rock", VerdureConfiguredFeatures.PATCH_ROCK, List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(ROCK_PREDICATE), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PATCH_DAISIES = register("patch_daisies", VerdureConfiguredFeatures.PATCH_DAISIES, worldSurfaceSquaredWithRarityFilter(6));
    public static final Holder<PlacedFeature> PATCH_WILDFLOWERS = register("patch_wildflowers", VerdureConfiguredFeatures.PATCH_WILDFLOWERS, worldSurfaceSquaredWithRarityFilter(6));
    public static final Holder<PlacedFeature> FALLEN_LOG = register("fallen_log", VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(7));
    public static final Holder<PlacedFeature> FALLEN_LOG_SAVANNA = register("fallen_log_savanna", VerdureConfiguredFeatures.FALLEN_LOG, worldSurfaceSquaredWithRarityFilter(13));
    public static final Holder<PlacedFeature> FALLEN_LOG_NETHER = register("fallen_log_nether", VerdureConfiguredFeatures.FALLEN_LOG, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> MUSHROOM_SHELF = register("mushroom_shelf", VerdureConfiguredFeatures.MUSHROOM_SHELF, List.of(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> UNDERGROUND_MUSHROOM_SHELF = register("underground_mushroom_shelf", VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF, List.of(CountPlacement.of(UniformInt.of(104, 157)), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> OAK_DAISIES = register("oak_daisies", VerdureConfiguredFeatures.OAK_DAISIES, List.of(PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BIRCH_DAISIES = register("birch_daisies", VerdureConfiguredFeatures.BIRCH_DAISIES, List.of(PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.BIRCH_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> OAK_HOLLOW = register("oak_hollow", VerdureConfiguredFeatures.OAK_HOLLOW, List.of(PlacementUtils.countExtra(0, 0.15F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome()));

    private static Holder<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> modifiers) {
        return PlacementUtils.register(new ResourceLocation(Verdure.MOD_ID, name).toString(), feature, modifiers);
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }
}
