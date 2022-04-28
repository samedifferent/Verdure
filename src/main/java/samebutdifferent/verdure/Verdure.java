package samebutdifferent.verdure;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import samebutdifferent.verdure.registry.*;

@Mod(Verdure.MOD_ID)
public class Verdure {
    public static final String MOD_ID = "verdure";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(VerdureBlocks.CLOVER.get().asItem());
        }
    };

    public Verdure() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, VerdureConfig.COMMON_CONFIG);

        VerdureBlocks.BLOCKS.register(bus);
        VerdureItems.ITEMS.register(bus);
        VerdureBlockEntityTypes.BLOCK_ENTITY_TYPES.register(bus);
        VerdureFeatures.FEATURES.register(bus);
        VerdureTreeDecoratorTypes.TREE_DECORATOR_TYPES.register(bus);
        VerdureConfiguredFeatures.CONFIGURED_FEATURES.register(bus);
        VerdurePlacedFeatures.PLACED_FEATURES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
