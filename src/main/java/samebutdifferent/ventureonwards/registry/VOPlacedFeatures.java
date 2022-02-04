package samebutdifferent.ventureonwards.registry;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import samebutdifferent.ventureonwards.VentureOnwards;

public class VOPlacedFeatures {



    public static PlacedFeature registerPlacedFeature(String pKey, PlacedFeature pPlacedFeature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(VentureOnwards.MOD_ID, pKey), pPlacedFeature);
    }

    public static void register() {

    }
}
