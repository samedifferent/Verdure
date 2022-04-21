package samebutdifferent.verdure.event;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;
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
                    if (location.equals(Biomes.BIRCH_FOREST.location()) || location.equals(Biomes.OLD_GROWTH_BIRCH_FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS.getHolder().get());
                    }
                    if (location.equals(Biomes.FOREST.location())) {
//                        builder.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).removeIf(placedFeatureSupplier -> CodecUtils.serializeAndCompareFeature(placedFeatureSupplier.value(), VegetationPlacements.TREES_BIRCH_AND_OAK.value()));
//                        builder.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).add(VerdurePlacedFeatures.TREES_BIRCH_AND_OAK.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_HOLLOW.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FANCY_OAK_HOLLOW.getHolder().get());
                    }
                    if (location.equals(Biomes.FLOWER_FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_HOLLOW.getHolder().get());
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FANCY_OAK_HOLLOW.getHolder().get());
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
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.HUMUS_PATCH.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case TAIGA -> {
                    if (!location.equals(Biomes.OLD_GROWTH_PINE_TAIGA.location()) || !location.equals(Biomes.OLD_GROWTH_SPRUCE_TAIGA.location())) {
                        builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_DIORITE.getHolder().get());
                    }
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG.getHolder().get());
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF.getHolder().get());
                    addGrassyAreaFeatures(builder);
                }
                case SAVANNA -> {
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
    public static void onPlace(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();
        Level level = player.level;
        ItemStack stack = event.getItemStack();
        if (level.getBlockState(event.getPos()).is(BlockTags.LOGS) || level.getBlockState(event.getPos()).is(BlockTags.DIRT) || level.getBlockState(event.getPos()).is(BlockTags.STONE_ORE_REPLACEABLES)) {
            if (event.getFace().getAxis().getPlane() == Direction.Plane.HORIZONTAL) {
                BlockPos pos = event.getHitVec().getBlockPos().relative(event.getFace());
                if (level.isEmptyBlock(pos)) {
                    if (stack.is(Items.BROWN_MUSHROOM)) {
                        placeMushroomShelf(event, player, level, pos, stack, VerdureBlocks.BROWN_MUSHROOM_SHELF.get());
                    } else if (stack.is(Items.RED_MUSHROOM)) {
                        placeMushroomShelf(event, player, level, pos, stack, VerdureBlocks.RED_MUSHROOM_SHELF.get());
                    }
                }
            }
        }
    }

    private static void placeMushroomShelf(PlayerInteractEvent.RightClickBlock event, Player player, Level level, BlockPos pos, ItemStack stack, Block mushroomShelf) {
        BlockState state = mushroomShelf.getStateForPlacement(new BlockPlaceContext(player, event.getHand(), stack, event.getHitVec()));
        level.setBlockAndUpdate(pos, state);
        player.swing(event.getHand());
        mushroomShelf.defaultBlockState().getBlock().setPlacedBy(level, pos, state, player, stack);
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer)player, pos, stack);
        }
        level.gameEvent(player, GameEvent.BLOCK_PLACE, pos);
        SoundType soundtype = state.getSoundType(level, pos, player);
        level.playSound(player, pos, soundtype.getPlaceSound(), SoundSource.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }
    }


}
