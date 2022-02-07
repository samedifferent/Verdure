package samebutdifferent.verdure.event;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
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
        switch (event.getCategory()) {
            case FOREST -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_STONE);
                addGrassyAreaFeatures(builder);
            }
            case PLAINS -> {
                addGrassyAreaFeatures(builder);
            }
            case RIVER -> builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE);
            case JUNGLE -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE);
                addGrassyAreaFeatures(builder);
            }
            case TAIGA -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_DIORITE);
                addGrassyAreaFeatures(builder);
            }
            case SAVANNA -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_GRANITE);
                addGrassyAreaFeatures(builder);
            }
            case BEACH -> builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_ANDESITE);
        }
    }

    private static void addGrassyAreaFeatures(BiomeGenerationSettingsBuilder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.FALLEN_LOG);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_ROCK);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.DAISIES);
    }

    @SubscribeEvent
    public static void onPlace(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHitVec().getDirection().getAxis().getPlane() == Direction.Plane.HORIZONTAL && event.getItemStack().is(Items.BROWN_MUSHROOM)) {
            event.setCanceled(true);
            event.getEntity().level.setBlockAndUpdate(event.getPos(), VerdureBlocks.BROWN_MUSHROOM_SHELF.get().getStateForPlacement(new BlockPlaceContext(event.getPlayer(), event.getHand(), new ItemStack(VerdureBlocks.BROWN_MUSHROOM_SHELF.get()), event.getHitVec())));
        } else if (event.getHitVec().getDirection().getAxis().getPlane() == Direction.Plane.HORIZONTAL && event.getItemStack().is(Items.RED_MUSHROOM)) {
            event.setCanceled(true);
            event.getEntity().level.setBlockAndUpdate(event.getPos(), VerdureBlocks.RED_MUSHROOM_SHELF.get().getStateForPlacement(new BlockPlaceContext(event.getPlayer(), event.getHand(), new ItemStack(VerdureBlocks.RED_MUSHROOM_SHELF.get()), event.getHitVec())));
        }
    }
}
