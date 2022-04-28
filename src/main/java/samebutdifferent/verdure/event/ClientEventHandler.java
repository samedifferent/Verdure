package samebutdifferent.verdure.event;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
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
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.FALLEN_OAK_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.FALLEN_BIRCH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.FALLEN_SPRUCE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.FALLEN_JUNGLE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.FALLEN_ACACIA_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(VerdureBlocks.FALLEN_DARK_OAK_LEAVES.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void registerBlockColors(ColorHandlerEvent.Block event) {
        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(),
                VerdureBlocks.FALLEN_OAK_LEAVES.get(), VerdureBlocks.FALLEN_JUNGLE_LEAVES.get(), VerdureBlocks.FALLEN_ACACIA_LEAVES.get(), VerdureBlocks.FALLEN_DARK_OAK_LEAVES.get(),
                VerdureBlocks.OAK_BRANCH.get());
        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> FoliageColor.getEvergreenColor(), VerdureBlocks.FALLEN_SPRUCE_LEAVES.get());
        event.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> FoliageColor.getBirchColor(), VerdureBlocks.FALLEN_BIRCH_LEAVES.get(), VerdureBlocks.BIRCH_BRANCH.get());
    }

    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event) {
        event.getItemColors().register((pStack, pTintIndex) -> {
            BlockState blockstate = ((BlockItem)pStack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(blockstate, null, null, pTintIndex);
        }, VerdureBlocks.FALLEN_OAK_LEAVES.get(), VerdureBlocks.FALLEN_JUNGLE_LEAVES.get(), VerdureBlocks.FALLEN_ACACIA_LEAVES.get(), VerdureBlocks.FALLEN_DARK_OAK_LEAVES.get(), VerdureBlocks.FALLEN_SPRUCE_LEAVES.get(), VerdureBlocks.FALLEN_BIRCH_LEAVES.get());
    }
}
