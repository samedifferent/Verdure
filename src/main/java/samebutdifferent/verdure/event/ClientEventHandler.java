package samebutdifferent.verdure.event;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;

@Mod.EventBusSubscriber(modid = Verdure.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.CLOVER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.BROWN_MUSHROOM_SHELF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.RED_MUSHROOM_SHELF.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.DAISIES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.BLUE_DAISIES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.PINK_DAISIES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.WILDFLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(Blocks.MOSS_CARPET, RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.HANGING_MOSS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.TALL_HANGING_MOSS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.OAK_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.BIRCH_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.WALL_ROOTS.get(), RenderType.cutout());
    }
}
