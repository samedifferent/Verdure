package samebutdifferent.verdure.registry;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import samebutdifferent.verdure.Verdure;

public class VerdurePlacedFeatures {



    public static PlacedFeature registerPlacedFeature(String pKey, PlacedFeature pPlacedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Verdure.MOD_ID, pKey), pPlacedFeature);
    }

    public static void register() {

    }
}
