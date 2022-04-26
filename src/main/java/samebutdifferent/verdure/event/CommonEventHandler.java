package samebutdifferent.verdure.event;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.block.WallRootsBlock;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureConfig;
import samebutdifferent.verdure.registry.VerdureEntityTypes;
import samebutdifferent.verdure.registry.VerdurePlacedFeatures;
import samebutdifferent.verdure.util.CodecUtils;

@Mod.EventBusSubscriber(modid = Verdure.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        ResourceLocation location = event.getName();

        if (location != null) {
            switch (event.getCategory()) {
                case FOREST -> {
                    if (location.equals(Biomes.BIRCH_FOREST.location())) {
                        replaceTrees(event, location, VegetationPlacements.TREES_BIRCH, VerdurePlacedFeatures.TREES_BIRCH);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS.getHolder().get());
                    }
                    if (location.equals(Biomes.OLD_GROWTH_BIRCH_FOREST.location())) {
                        replaceTrees(event, location, VegetationPlacements.BIRCH_TALL, VerdurePlacedFeatures.BIRCH_TALL);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS.getHolder().get());
                    }
                    if (location.equals(Biomes.FOREST.location())) {
                        replaceTrees(event, location, VegetationPlacements.TREES_BIRCH_AND_OAK, VerdurePlacedFeatures.TREES_BIRCH_AND_OAK);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_HOLLOW.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FANCY_OAK_HOLLOW.getHolder().get());
                        event.getSpawns().addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(VerdureEntityTypes.BIRD.get(), 12, 2, 3));
                    }
                    if (location.equals(Biomes.FLOWER_FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_HOLLOW.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FANCY_OAK_HOLLOW.getHolder().get());
                    }
                    if (VerdureConfig.GENERATE_DARK_OAK_HUMUS.get()) {
                        replaceTrees(event, Biomes.DARK_FOREST.location(), VegetationPlacements.DARK_FOREST_VEGETATION, VerdurePlacedFeatures.DARK_FOREST_VEGETATION);
                    }
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_STONE.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case PLAINS -> {
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case RIVER -> {
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE.getHolder().get());
                }
                case JUNGLE -> {
                    replaceTrees(event, Biomes.SPARSE_JUNGLE.location(), VegetationPlacements.TREES_SPARSE_JUNGLE, VerdurePlacedFeatures.TREES_SPARSE_JUNGLE);
                    replaceTrees(event, Biomes.JUNGLE.location(), VegetationPlacements.TREES_JUNGLE, VerdurePlacedFeatures.TREES_JUNGLE);
                    replaceTrees(event, Biomes.BAMBOO_JUNGLE.location(), VegetationPlacements.TREES_JUNGLE, VerdurePlacedFeatures.TREES_JUNGLE);
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.HUMUS_PATCH.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case TAIGA -> {
                    if (location.equals(Biomes.TAIGA.location()) || location.equals(Biomes.SNOWY_TAIGA.location())) {
                        builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_DIORITE.getHolder().get());
                    }
                    replaceTrees(event, Biomes.TAIGA.location(), VegetationPlacements.TREES_TAIGA, VerdurePlacedFeatures.TREES_TAIGA);
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case SAVANNA -> {
                    replaceTrees(event, Biomes.SAVANNA.location(), VegetationPlacements.TREES_SAVANNA, VerdurePlacedFeatures.TREES_SAVANNA);
                    replaceTrees(event, Biomes.WINDSWEPT_SAVANNA.location(), VegetationPlacements.TREES_WINDSWEPT_SAVANNA, VerdurePlacedFeatures.TREES_WINDSWEPT_SAVANNA);
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_GRANITE.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG_SAVANNA.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PEBBLES.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.ROCK.getHolder().get());
                }
                case BEACH -> {
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_ANDESITE.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PEBBLES.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.ROCK.getHolder().get());
                }
                case SWAMP -> {
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH_SWAMP.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case NETHER -> {
                    if (location.equals(Biomes.WARPED_FOREST.location()) || location.equals(Biomes.CRIMSON_FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG_NETHER.getHolder().get());
                    }
                }
                case UNDERGROUND -> {
                    if (location.equals(Biomes.LUSH_CAVES.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.HANGING_MOSS.getHolder().get());
                    }
                }
            }
        }
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.UNDERGROUND_MUSHROOM_SHELF.getHolder().get());
    }

    private static void replaceTrees(BiomeLoadingEvent event, ResourceLocation biomeLocation, Holder<PlacedFeature> originalFeature, RegistryObject<PlacedFeature> replacementFeature) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        ResourceLocation location = event.getName();
        if (location != null && location.equals(biomeLocation)) {
            if (VerdureConfig.GENERATE_TREE_BRANCHES.get() || VerdureConfig.FALLEN_LEAVES_CHANCE.get() > 0) {
                builder.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).removeIf(placedFeatureSupplier -> CodecUtils.serializeAndCompareFeature(placedFeatureSupplier.value(), originalFeature.value()));
                builder.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(replacementFeature.getHolder().get());
                Verdure.LOGGER.debug("Replaced " + originalFeature.unwrapKey().get().location() + " in " + location + " with " + replacementFeature.getId());
            }
        }
    }

    private static void addGrassyAreaFeatures(BiomeGenerationSettingsBuilder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PEBBLES.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.ROCK.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_DAISIES.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_DAISIES_BLUE.getHolder().get());
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_DAISIES_PINK.getHolder().get());
    }

    @SubscribeEvent
    public static void onServerStarted(ServerStartedEvent event) {
        CodecUtils.clearCache();
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();
        Level level = player.level;
        ItemStack stack = event.getItemStack();
        if (WallRootsBlock.canAttachTo(level, event.getPos(), event.getFace())) {
            if (event.getFace().getAxis().getPlane() == Direction.Plane.HORIZONTAL) {
                BlockPos pos = event.getHitVec().getBlockPos().relative(event.getFace());
                if (level.isEmptyBlock(pos)) {
                    if (stack.is(Items.BROWN_MUSHROOM)) {
                        placeBlock(event, player, level, pos, stack, VerdureBlocks.BROWN_MUSHROOM_SHELF.get());
                    } else if (stack.is(Items.RED_MUSHROOM)) {
                        placeBlock(event, player, level, pos, stack, VerdureBlocks.RED_MUSHROOM_SHELF.get());
                    } else if (stack.is(Items.HANGING_ROOTS)) {
                        placeBlock(event, player, level, pos, stack, VerdureBlocks.WALL_ROOTS.get());
                    }
                }
            }
        }
    }

    private static void placeBlock(PlayerInteractEvent.RightClickBlock event, Player player, Level level, BlockPos pos, ItemStack stack, Block block) {
        BlockState state = block.getStateForPlacement(new BlockPlaceContext(player, event.getHand(), stack, event.getHitVec()));
        if (state != null && block.canSurvive(state, level, pos)) {
            level.setBlockAndUpdate(pos, state);
            player.swing(event.getHand());
            block.defaultBlockState().getBlock().setPlacedBy(level, pos, state, player, stack);
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, pos, stack);
            }
            level.gameEvent(player, GameEvent.BLOCK_PLACE, pos);
            SoundType soundtype = state.getSoundType(level, pos, player);
            level.playSound(player, pos, soundtype.getPlaceSound(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockToolModification(BlockEvent.BlockToolModificationEvent event) {
        if (event.getToolAction().equals(ToolActions.HOE_TILL)) {
            if (event.getState().is(VerdureBlocks.SMOOTH_DIRT.get())) {
                event.setFinalState(Blocks.FARMLAND.defaultBlockState());
            }
        }
    }
}
