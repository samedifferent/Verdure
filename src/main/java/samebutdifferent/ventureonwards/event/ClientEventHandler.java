package samebutdifferent.ventureonwards.event;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import samebutdifferent.ventureonwards.VentureOnwards;
import samebutdifferent.ventureonwards.registry.VOBlocks;

@Mod.EventBusSubscriber(modid = VentureOnwards.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(VOBlocks.CLOVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VOBlocks.BROWN_MUSHROOM_SHELF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VOBlocks.RED_MUSHROOM_SHELF.get(), RenderType.cutout());
    }
}
