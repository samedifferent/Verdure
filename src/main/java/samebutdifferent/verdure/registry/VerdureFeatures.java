package samebutdifferent.verdure.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.feature.*;

public class VerdureFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Verdure.MOD_ID);

    public static final RegistryObject<DitheredDiskFeature> DITHERED_DISK = FEATURES.register("dithered_disk", () -> new DitheredDiskFeature(DiskConfiguration.CODEC));
    public static final RegistryObject<FallenLogFeature> FALLEN_LOG = FEATURES.register("fallen_log", () -> new FallenLogFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<MushroomShelfFeature> MUSHROOM_SHELF = FEATURES.register("mushroom_shelf", () -> new MushroomShelfFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<UndergroundMushroomShelfFeature> UNDERGROUND_MUSHROOM_SHELF = FEATURES.register("underground_mushroom_shelf", () -> new UndergroundMushroomShelfFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistryObject<HangingMossFeature> HANGING_MOSS = FEATURES.register("hanging_moss", () -> new HangingMossFeature(SimpleBlockConfiguration.CODEC));

}
