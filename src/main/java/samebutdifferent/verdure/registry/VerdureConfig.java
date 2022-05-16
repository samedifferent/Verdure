package samebutdifferent.verdure.registry;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

public class VerdureConfig {
    public static ForgeConfigSpec COMMON_CONFIG;
    
    // WORLD GENERATION SETTINGS
    public static final ForgeConfigSpec.BooleanValue GENERATE_BOULDER;
    public static final ForgeConfigSpec.BooleanValue GENERATE_SMOOTH_DIRT_PATCH;
    public static final ForgeConfigSpec.BooleanValue GENERATE_HUMUS_PATCH;
    public static final ForgeConfigSpec.BooleanValue GENERATE_CLOVER_PATCH;
    public static final ForgeConfigSpec.BooleanValue GENERATE_DAISIES_PATCH;
    public static final ForgeConfigSpec.BooleanValue GENERATE_PEBBLES;
    public static final ForgeConfigSpec.BooleanValue GENERATE_ROCK;
    public static final ForgeConfigSpec.BooleanValue GENERATE_FALLEN_LOG;
    public static final ForgeConfigSpec.BooleanValue GENERATE_DAISY_TREE;
    public static final ForgeConfigSpec.BooleanValue GENERATE_OAK_HOLLOW;
    public static final ForgeConfigSpec.BooleanValue GENERATE_FALLEN_LOG_NETHER;
    public static final ForgeConfigSpec.BooleanValue GENERATE_MUSHROOM_SHELF_SURFACE;
    public static final ForgeConfigSpec.BooleanValue GENERATE_MUSHROOM_SHELF_UNDERGROUND;
    public static final ForgeConfigSpec.BooleanValue GENERATE_HANGING_MOSS;
    public static final ForgeConfigSpec.BooleanValue GENERATE_TREE_ROOTS;
    public static final ForgeConfigSpec.BooleanValue GENERATE_TREE_BRANCHES;
    public static final ForgeConfigSpec.DoubleValue FALLEN_LEAVES_CHANCE;
    public static final ForgeConfigSpec.BooleanValue GENERATE_DARK_OAK_HUMUS;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        
        COMMON_BUILDER.push("World Generation Settings");
        GENERATE_BOULDER = COMMON_BUILDER.comment("Generate boulder").define("generateBoulder", true);
        GENERATE_SMOOTH_DIRT_PATCH = COMMON_BUILDER.comment("Generate smooth dirt patch").define("generateSmoothDirtPatch", true);
        GENERATE_HUMUS_PATCH = COMMON_BUILDER.comment("Generate humus patch in the jungle").define("generateHumusPatch", true);
        GENERATE_CLOVER_PATCH = COMMON_BUILDER.comment("Generate clover patch").define("generateCloverPatch", true);
        GENERATE_DAISIES_PATCH = COMMON_BUILDER.comment("Generate daisies patch").define("generateDaisiesPatch", true);
        GENERATE_PEBBLES = COMMON_BUILDER.comment("Generate pebbles").define("generatePebbles", true);
        GENERATE_ROCK = COMMON_BUILDER.comment("Generate rock").define("generateRock", true);
        GENERATE_FALLEN_LOG = COMMON_BUILDER.comment("Generate fallen log").define("generateFallenLog", true);
        GENERATE_DAISY_TREE = COMMON_BUILDER.comment("Generate daisy-decorated tree").define("generateOakDaisies", true);
        GENERATE_OAK_HOLLOW = COMMON_BUILDER.comment("Generate hollow log oak tree").define("generateOakHollow", true);
        GENERATE_FALLEN_LOG_NETHER = COMMON_BUILDER.comment("Generate fallen log").define("generateFallenLogNether", true);
        GENERATE_MUSHROOM_SHELF_SURFACE = COMMON_BUILDER.comment("Generate mushroom shelf on the surface").define("generateMushroomShelfSurface", true);
        GENERATE_MUSHROOM_SHELF_UNDERGROUND = COMMON_BUILDER.comment("Generate mushroom shelf underground").define("generateMushroomShelfUndergroundMin", true);
        GENERATE_HANGING_MOSS = COMMON_BUILDER.comment("Generate hanging moss ").define("generateHangingMoss", true);
        GENERATE_TREE_ROOTS = COMMON_BUILDER.comment("Trees will spawn with a block of rooted dirt underneath, rather than regular dirt.").define("generateTreeRoots", true);
        GENERATE_TREE_BRANCHES = COMMON_BUILDER.comment("Trees in forests will spawn with 2D branch blocks.").define("generateTreeBranches", true);
        FALLEN_LEAVES_CHANCE = COMMON_BUILDER.comment("Chance that fallen leaves will generate under a tree (in percentage). Set to 0 to disable this.").defineInRange("fallenLeavesChance", 0.1, 0.0, 1.0);
        GENERATE_DARK_OAK_HUMUS = COMMON_BUILDER.comment("Dark Oak trees will spawn with a patch of humus underneath.").define("generateDarkOakHumus", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading configEvent) { }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading configEvent) { }
}
