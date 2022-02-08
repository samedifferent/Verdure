package samebutdifferent.verdure.registry;

import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.FeatureUtils;
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
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.DaisiesDecorator;

import java.util.List;

public class VerdureConfiguredFeatures {

    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_STONE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.STONE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_DIORITE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.DIORITE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_GRANITE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.GRANITE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_ANDESITE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState()));
    public static final ConfiguredFeature<BlockStateConfiguration, ?> BOULDER_SLATE = Feature.FOREST_ROCK.configured(new BlockStateConfiguration(VerdureBlocks.SLATE.get().defaultBlockState()));
    public static final ConfiguredFeature<DiskConfiguration, ?> SMOOTH_DIRT_PATCH = VerdureFeatures.SMOOTH_DIRT_PATCH.get().configured(new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(2, 6), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState())));
    public static final ConfiguredFeature<DiskConfiguration, ?> SMOOTH_DIRT_PATCH_SWAMP = VerdureFeatures.SMOOTH_DIRT_PATCH.get().configured(new DiskConfiguration(VerdureBlocks.SMOOTH_DIRT.get().defaultBlockState(), UniformInt.of(5, 8), 1, List.of(Blocks.DIRT.defaultBlockState(), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.PODZOL.defaultBlockState(), Blocks.COARSE_DIRT.defaultBlockState(), Blocks.MYCELIUM.defaultBlockState())));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_CLOVER = Feature.RANDOM_PATCH.configured(FeatureUtils.simpleRandomPatchConfiguration(32, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.CLOVER.get()))).onlyWhenEmpty()));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_PEBBLES = Feature.RANDOM_PATCH.configured(FeatureUtils.simpleRandomPatchConfiguration(5, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.PEBBLES.get()))).onlyWhenEmpty()));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_ROCK = Feature.RANDOM_PATCH.configured(FeatureUtils.simpleRandomPatchConfiguration(5, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(BlockStateProvider.simple(VerdureBlocks.ROCK.get()))).onlyWhenEmpty()));
    public static final ConfiguredFeature<RandomPatchConfiguration, ?> PATCH_DAISIES = Feature.RANDOM_PATCH.configured(FeatureUtils.simpleRandomPatchConfiguration(10, Feature.SIMPLE_BLOCK.configured(new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(VerdureBlocks.DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true), 1).add(VerdureBlocks.BLUE_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true), 1).add(VerdureBlocks.PINK_DAISIES.get().defaultBlockState().setValue(MultifaceBlock.getFaceProperty(Direction.DOWN), true), 1).build()))).onlyWhenEmpty()));
    public static final ConfiguredFeature<NoneFeatureConfiguration, ?> FALLEN_LOG = VerdureFeatures.FALLEN_LOG.get().configured(FeatureConfiguration.NONE);
    public static final ConfiguredFeature<NoneFeatureConfiguration, ?> MUSHROOM_SHELF = VerdureFeatures.MUSHROOM_SHELF.get().configured(FeatureConfiguration.NONE);
    public static final ConfiguredFeature<TreeConfiguration, ?> OAK_DAISIES = Feature.TREE.configured(new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new DaisiesDecorator())).build());
    public static final ConfiguredFeature<TreeConfiguration, ?> BIRCH_DAISIES = Feature.TREE.configured(new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(5, 2, 0), BlockStateProvider.simple(Blocks.BIRCH_LEAVES), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().decorators(List.of(new DaisiesDecorator())).build());

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
        registerConfiguredFeature("smooth_dirt_patch_swamp", SMOOTH_DIRT_PATCH_SWAMP);
        registerConfiguredFeature("patch_clover", PATCH_CLOVER);
        registerConfiguredFeature("patch_pebbles", PATCH_PEBBLES);
        registerConfiguredFeature("patch_rock", PATCH_ROCK);
        registerConfiguredFeature("patch_daisies", PATCH_DAISIES);
        registerConfiguredFeature("fallen_log", FALLEN_LOG);
        registerConfiguredFeature("mushroom_shelf", MUSHROOM_SHELF);
        registerConfiguredFeature("oak_daisies", OAK_DAISIES);
        registerConfiguredFeature("birch_daisies", BIRCH_DAISIES);
    }
}
