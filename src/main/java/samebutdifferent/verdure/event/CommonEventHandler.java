package samebutdifferent.verdure.event;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdurePlacedFeatures;

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
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS);
                    }
                    if (location.equals(Biomes.FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_DAISIES);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.BIRCH_DAISIES);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_HOLLOW);
                    }
                    if (location.equals(Biomes.FLOWER_FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_WILDFLOWERS);
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.OAK_HOLLOW);
                    }
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_STONE);
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF);
                    addGrassyAreaFeatures(builder);
                }
                case PLAINS -> {
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG);
                    addGrassyAreaFeatures(builder);
                }
                case RIVER -> {
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE);
                }
                case JUNGLE -> {
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE);
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG);
                    addGrassyAreaFeatures(builder);
                }
                case TAIGA -> {
                    if (!location.equals(Biomes.OLD_GROWTH_PINE_TAIGA.location()) || !location.equals(Biomes.OLD_GROWTH_SPRUCE_TAIGA.location())) {
                        builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_DIORITE);
                    }
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF);
                    addGrassyAreaFeatures(builder);
                }
                case SAVANNA -> {
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_GRANITE);
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG_SAVANNA);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_ROCK);
                }
                case BEACH -> {
                    builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_ANDESITE);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_ROCK);
                }
                case SWAMP -> {
                    builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH_SWAMP);
                    builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.MUSHROOM_SHELF);
                    addGrassyAreaFeatures(builder);
                }
                case NETHER -> {
                    if (location.equals(Biomes.WARPED_FOREST.location()) || location.equals(Biomes.CRIMSON_FOREST.location())) {
                        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG_NETHER);
                    }
                }
            }
        }
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.UNDERGROUND_MUSHROOM_SHELF);
    }

    private static void addGrassyAreaFeatures(BiomeGenerationSettingsBuilder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_ROCK);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_DAISIES);
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
