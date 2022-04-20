package samebutdifferent.verdure.registry;


import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

public class VerdureConfig {
    public static ForgeConfigSpec COMMON_CONFIG;

    public static final ForgeConfigSpec.IntValue BOULDER_RARITY;
    public static final ForgeConfigSpec.IntValue SMOOTH_DIRT_PATCH_RARITY;
    public static final ForgeConfigSpec.IntValue HUMUS_PATCH_RARITY;
    public static final ForgeConfigSpec.IntValue CLOVER_PATCH_RARITY;
    public static final ForgeConfigSpec.IntValue DAISIES_PATCH_RARITY;
    public static final ForgeConfigSpec.IntValue FALLEN_LOG_RARITY;
    public static final ForgeConfigSpec.IntValue DAISY_TREE_RARITY;
    public static final ForgeConfigSpec.IntValue OAK_HOLLOW_RARITY;

    public static final ForgeConfigSpec.IntValue FALLEN_LOG_NETHER_COUNT;
    public static final ForgeConfigSpec.IntValue PEBBLES_RARITY;
    public static final ForgeConfigSpec.IntValue ROCK_RARITY;
    public static final ForgeConfigSpec.IntValue MUSHROOM_SHELF_SURFACE_COUNT;
    public static final ForgeConfigSpec.IntValue MUSHROOM_SHELF_UNDERGROUND_COUNT_MIN;
    public static final ForgeConfigSpec.IntValue MUSHROOM_SHELF_UNDERGROUND_COUNT_MAX;
    public static final ForgeConfigSpec.IntValue HANGING_MOSS_COUNT;

    public static final ForgeConfigSpec.BooleanValue GENERATE_TREE_ROOTS;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment(
                " These features use the Rarity Placement Modifier.",
                " This means the chance of a feature generating in a chunk is 1/rarityPerChunk.",
                " Set it to 1 for the feature to spawn in every chunk, 10000 to remove the feature, or anywhere in between.");

        COMMON_BUILDER.push("Rarity-Based Feature Placements");
        BOULDER_RARITY = COMMON_BUILDER.comment("Boulder rarity per chunk").defineInRange("boulderRarityPerChunk", 4, 1, 10000);
        SMOOTH_DIRT_PATCH_RARITY = COMMON_BUILDER.comment("Smooth dirt patch rarity per chunk").defineInRange("smoothDirtPatchRarityPerChunk", 7, 1, 10000);
        HUMUS_PATCH_RARITY = COMMON_BUILDER.comment("Humus patch rarity per chunk in the jungle").defineInRange("humusPatchRarityPerChunk", 4, 1, 10000);
        CLOVER_PATCH_RARITY = COMMON_BUILDER.comment("Clover patch rarity per chunk").defineInRange("cloverPatchRarityPerChunk", 5, 1, 10000);
        DAISIES_PATCH_RARITY = COMMON_BUILDER.comment("Daisies patch rarity per chunk").defineInRange("daisiesPatchRarityPerChunk", 14, 1, 10000);
        PEBBLES_RARITY = COMMON_BUILDER.comment("Pebbles rarity").defineInRange("pebblesRarityPerChunk", 2, 1, 10000);
        ROCK_RARITY = COMMON_BUILDER.comment("Rock rarity").defineInRange("rockRarityPerChunk", 2, 1, 10000);
        FALLEN_LOG_RARITY = COMMON_BUILDER.comment("Fallen log rarity per chunk").defineInRange("fallenLogRarityPerChunk", 7, 1, 10000);
        DAISY_TREE_RARITY = COMMON_BUILDER.comment("Daisy-decorated tree rarity per chunk").defineInRange("oakDaisiesRarityPerChunk", 13, 1, 10000);
        OAK_HOLLOW_RARITY = COMMON_BUILDER.comment("Hollow Log oak tree rarity per chunk").defineInRange("oakHollowRarityPerChunk", 10, 1, 10000);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment(
                " These features use the Count Placement Modifier.",
                " This means the higher the number, the more often it will generate.",
                " Set it to 0 to remove the feature.");
        COMMON_BUILDER.push("Count-Based Feature Placements");
        FALLEN_LOG_NETHER_COUNT = COMMON_BUILDER.comment("Fallen log count on each layer in the nether biomes").defineInRange("fallenLogNetherCount", 3, 0, 512);
        MUSHROOM_SHELF_SURFACE_COUNT = COMMON_BUILDER.comment("Mushroom shelf count on the surface").defineInRange("mushroomShelfSurfaceCount", 256, 0, 512);
        MUSHROOM_SHELF_UNDERGROUND_COUNT_MIN = COMMON_BUILDER.comment("Mushroom shelf underground count min value").defineInRange("mushroomShelfUndergroundCountMin", 104, 0, 512);
        MUSHROOM_SHELF_UNDERGROUND_COUNT_MAX = COMMON_BUILDER.comment("Mushroom shelf undeground count max value").defineInRange("mushroomShelfUndergroundCountMax", 157, 0, 512);
        HANGING_MOSS_COUNT = COMMON_BUILDER.comment("Hanging moss count").defineInRange("hangingMossCount", 128, 0, 512);

        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Other World Generation Settings");
        GENERATE_TREE_ROOTS = COMMON_BUILDER.comment("Naturally generated trees will spawn with 2 blocks of rooted dirt underneath").define("generateTreeRoots", true);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Gameplay Settings");
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) { }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading configEvent) { }
}
