package samebutdifferent.verdure.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.feature.SmoothDirtPatchFeature;

public class VerdureFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Verdure.MOD_ID);

    public static final RegistryObject<SmoothDirtPatchFeature> SMOOTH_DIRT_PATCH = FEATURES.register("smooth_dirt_patch", () -> new SmoothDirtPatchFeature(DiskConfiguration.CODEC));
}
