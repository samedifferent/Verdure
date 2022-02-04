package samebutdifferent.ventureonwards.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import samebutdifferent.ventureonwards.VentureOnwards;
import samebutdifferent.ventureonwards.registry.VOConfiguredFeatures;
import samebutdifferent.ventureonwards.registry.VOPlacedFeatures;

@Mod.EventBusSubscriber(modid = VentureOnwards.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            VOConfiguredFeatures.register();
            VOPlacedFeatures.register();
        });
    }
}
