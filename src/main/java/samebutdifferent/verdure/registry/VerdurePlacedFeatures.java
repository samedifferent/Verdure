package samebutdifferent.verdure.registry;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;
import samebutdifferent.verdure.Verdure;

public class VerdurePlacedFeatures {

    public static final PlacedFeature BOULDER_STONE = VerdureConfiguredFeatures.BOULDER_STONE.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_DIORITE = VerdureConfiguredFeatures.BOULDER_DIORITE.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_GRANITE = VerdureConfiguredFeatures.BOULDER_GRANITE.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_ANDESITE = VerdureConfiguredFeatures.BOULDER_ANDESITE.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature BOULDER_SLATE = VerdureConfiguredFeatures.BOULDER_SLATE.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature SMOOTH_DIRT_PATCH = VerdureConfiguredFeatures.SMOOTH_DIRT_PATCH.placed(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
    public static final PlacedFeature PATCH_CLOVER_PLAIN = VerdureConfiguredFeatures.PATCH_CLOVER.placed(NoiseThresholdCountPlacement.of(-0.8D, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final PlacedFeature PATCH_CLOVER_FOREST = VerdureConfiguredFeatures.PATCH_CLOVER.placed(VegetationPlacements.worldSurfaceSquaredWithCount(2));
    public static final PlacedFeature PATCH_CLOVER_SAVANNA = VerdureConfiguredFeatures.PATCH_CLOVER.placed(VegetationPlacements.worldSurfaceSquaredWithCount(20));
    public static final PlacedFeature PATCH_CLOVER_TAIGA = VerdureConfiguredFeatures.PATCH_CLOVER.placed(VegetationPlacements.worldSurfaceSquaredWithCount(7));
    public static final PlacedFeature PATCH_CLOVER_JUNGLE = VerdureConfiguredFeatures.PATCH_CLOVER.placed(VegetationPlacements.worldSurfaceSquaredWithCount(25));

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
        registerPlacedFeature("patch_clover_plain", PATCH_CLOVER_PLAIN);
        registerPlacedFeature("patch_clover_forest", PATCH_CLOVER_FOREST);
        registerPlacedFeature("patch_clover_savanna", PATCH_CLOVER_SAVANNA);
        registerPlacedFeature("patch_clover_taiga", PATCH_CLOVER_TAIGA);
        registerPlacedFeature("patch_clover_jungle", PATCH_CLOVER_JUNGLE);
    }
}
