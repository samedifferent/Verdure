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
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_CLOVER);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_PEBBLES);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.PATCH_ROCK);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VerdurePlacedFeatures.DAISIES);
    }
}
