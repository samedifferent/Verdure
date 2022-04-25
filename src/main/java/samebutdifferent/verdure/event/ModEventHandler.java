package samebutdifferent.verdure.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.entity.Bird;
import samebutdifferent.verdure.registry.VerdureBlocks;
import samebutdifferent.verdure.registry.VerdureEntityTypes;

import java.util.Map;

@Mod.EventBusSubscriber(modid = Verdure.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {
    @SubscribeEvent
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerCompostables();
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(VerdureEntityTypes.BIRD.get(), Bird.createAttributes().build());
    }

    @SubscribeEvent
    public static void onComplete(FMLLoadCompleteEvent event) {
        SpawnPlacements.register(VerdureEntityTypes.BIRD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules);
    }

    private static void registerCompostables() {
        compostibleBlocks(0.3F, VerdureBlocks.CLOVER.get());
        compostibleBlocks(0.3F, VerdureBlocks.DAISIES.get());
        compostibleBlocks(0.3F, VerdureBlocks.BLUE_DAISIES.get());
        compostibleBlocks(0.3F, VerdureBlocks.PINK_DAISIES.get());
        compostibleBlocks(0.3F, VerdureBlocks.WILDFLOWERS.get());
        compostibleBlocks(0.3F, VerdureBlocks.HANGING_MOSS.get());
        compostibleBlocks(0.3F, VerdureBlocks.FALLEN_OAK_LEAVES.get());
        compostibleBlocks(0.3F, VerdureBlocks.FALLEN_BIRCH_LEAVES.get());
        compostibleBlocks(0.3F, VerdureBlocks.FALLEN_SPRUCE_LEAVES.get());
        compostibleBlocks(0.3F, VerdureBlocks.FALLEN_JUNGLE_LEAVES.get());
        compostibleBlocks(0.3F, VerdureBlocks.FALLEN_ACACIA_LEAVES.get());
        compostibleBlocks(0.3F, VerdureBlocks.FALLEN_DARK_OAK_LEAVES.get());
    }

    private static void compostibleBlocks(float chance, ItemLike item) {
        ComposterBlock.COMPOSTABLES.put(item.asItem(), chance);
    }
}
