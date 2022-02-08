package samebutdifferent.verdure.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.placement.*;
import samebutdifferent.verdure.Verdure;

import java.util.List;

public class VerdurePlacedFeatures {

    public static final PlacedFeature BOULDER_STONE = VerdureConfiguredFeatures.BOULDER_STONE.placed(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_DIORITE = VerdureConfiguredFeatures.BOULDER_DIORITE.placed(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_GRANITE = VerdureConfiguredFeatures.BOULDER_GRANITE.placed(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_ANDESITE = VerdureConfiguredFeatures.BOULDER_ANDESITE.placed(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_SLATE = VerdureConfiguredFeatures.BOULDER_SLATE.placed(CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature SMOOTH_DIRT_PATCH = VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH.placed(RarityFilter.onAverageOnceEvery(7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature SMOOTH_DIRT_PATCH_SWAMP = VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH_SWAMP.placed(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature PATCH_CLOVER = VerdureConfiguredFeatures.PATCH_CLOVER.placed(worldSurfaceSquaredWithRarityFilter(1));
    public static final PlacedFeature PATCH_PEBBLES = VerdureConfiguredFeatures.PATCH_PEBBLES.placed(worldSurfaceSquaredWithRarityFilter(2));
    public static final PlacedFeature PATCH_ROCK = VerdureConfiguredFeatures.PATCH_ROCK.placed(worldSurfaceSquaredWithRarityFilter(2));
    public static final PlacedFeature PATCH_DAISIES = VerdureConfiguredFeatures.PATCH_DAISIES.placed(worldSurfaceSquaredWithRarityFilter(2));
    public static final PlacedFeature PATCH_WILDFLOWERS = VerdureConfiguredFeatures.PATCH_WILDFLOWERS.placed(worldSurfaceSquaredWithRarityFilter(2));
    public static final PlacedFeature FALLEN_LOG = VerdureConfiguredFeatures.FALLEN_LOG.placed(worldSurfaceSquaredWithRarityFilter(7));
    public static final PlacedFeature FALLEN_LOG_SAVANNA = VerdureConfiguredFeatures.FALLEN_LOG.placed(worldSurfaceSquaredWithRarityFilter(13));
    public static final PlacedFeature FALLEN_LOG_NETHER = VerdureConfiguredFeatures.FALLEN_LOG.placed(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome());
    public static final PlacedFeature MUSHROOM_SHELF = VerdureConfiguredFeatures.MUSHROOM_SHELF.placed(CountPlacement.of(256), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(100)), BiomeFilter.biome());
    public static final PlacedFeature UNDERGROUND_MUSHROOM_SHELF = VerdureConfiguredFeatures.UNDERGROUND_MUSHROOM_SHELF.placed(CountPlacement.of(UniformInt.of(104, 157)), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, InSquarePlacement.spread(), SurfaceRelativeThresholdFilter.of(Heightmap.Types.OCEAN_FLOOR_WG, Integer.MIN_VALUE, -13), BiomeFilter.biome());
    public static final PlacedFeature OAK_DAISIES = VerdureConfiguredFeatures.OAK_DAISIES.placed(PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());
    public static final PlacedFeature BIRCH_DAISIES = VerdureConfiguredFeatures.BIRCH_DAISIES.placed(PlacementUtils.countExtra(0, 0.05F, 1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.BIRCH_SAPLING.defaultBlockState(), BlockPos.ZERO)), BiomeFilter.biome());

    public static PlacedFeature registerPlacedFeature(String pKey, PlacedFeature pPlacedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Verdure.MOD_ID, pKey), pPlacedFeature);
    }

    public static void register() {
        registerPlacedFeature("boulder_stone", BOULDER_STONE);
        registerPlacedFeature("boulder_diorite", BOULDER_DIORITE);
        registerPlacedFeature("boulder_granite", BOULDER_GRANITE);
        registerPlacedFeature("boulder_andesite", BOULDER_ANDESITE);
        registerPlacedFeature("boulder_slate", BOULDER_SLATE);
        registerPlacedFeature("smooth_dirt_patch", SMOOTH_DIRT_PATCH);
        registerPlacedFeature("smooth_dirt_patch_swamp", SMOOTH_DIRT_PATCH_SWAMP);
        registerPlacedFeature("patch_clover", PATCH_CLOVER);
        registerPlacedFeature("patch_pebbles", PATCH_PEBBLES);
        registerPlacedFeature("patch_rock", PATCH_ROCK);
        registerPlacedFeature("patch_daisies", PATCH_DAISIES);
        registerPlacedFeature("patch_wildflowers", PATCH_WILDFLOWERS);
        registerPlacedFeature("fallen_log", FALLEN_LOG);
        registerPlacedFeature("fallen_log_savanna", FALLEN_LOG_SAVANNA);
        registerPlacedFeature("fallen_log_nether", FALLEN_LOG_NETHER);
        registerPlacedFeature("mushroom_shelf", MUSHROOM_SHELF);
        registerPlacedFeature("underground_mushroom_shelf", UNDERGROUND_MUSHROOM_SHELF);
        registerPlacedFeature("oak_daisies", OAK_DAISIES);
        registerPlacedFeature("birch_daisies", BIRCH_DAISIES);
    }

    public static List<PlacementModifier> worldSurfaceSquaredWithRarityFilter(int chance) {
        return List.of(RarityFilter.onAverageOnceEvery(chance), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    }
}
