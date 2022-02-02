package samebutdifferent.ventureonwards;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import samebutdifferent.ventureonwards.registry.VOBlocks;
import samebutdifferent.ventureonwards.registry.VOItems;

@Mod(VentureOnwards.MOD_ID)
public class VentureOnwards {
    public static final String MOD_ID = "ventureonwards";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.OAK_LEAVES);
        }
    };

    public VentureOnwards() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        VOBlocks.BLOCKS.register(bus);
        VOItems.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
