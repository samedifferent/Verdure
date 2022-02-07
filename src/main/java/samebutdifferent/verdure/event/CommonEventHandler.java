package samebutdifferent.verdure.event;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdurePlacedFeatures;

@Mod.EventBusSubscriber(modid = Verdure.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();
        switch (event.getCategory()) {
            case FOREST -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_STONE);
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
            }
            case PLAINS -> {
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
            }
            case RIVER -> builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE);
            case JUNGLE -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_SLATE);
                builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, VerdurePlacedFeatures.SMOOTH_DIRT_PATCH);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
            }
            case TAIGA -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_DIORITE);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
            }
            case SAVANNA -> {
                builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_GRANITE);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
                builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
            }
            case BEACH -> builder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, VerdurePlacedFeatures.BOULDER_ANDESITE);
        }
    }
}
