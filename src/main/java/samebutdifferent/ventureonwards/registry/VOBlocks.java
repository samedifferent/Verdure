package samebutdifferent.ventureonwards.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.ventureonwards.VentureOnwards;
import samebutdifferent.ventureonwards.block.PebbleBlock;

import java.util.function.Supplier;

public class VOBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VentureOnwards.MOD_ID);

    public static final RegistryObject<Block> PEBBLE = registerBlock("pebble", PebbleBlock::new);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VOBlocks.BLOCKS.register(name, block);
        VOItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(VentureOnwards.TAB)));
        return toReturn;
    }
}
