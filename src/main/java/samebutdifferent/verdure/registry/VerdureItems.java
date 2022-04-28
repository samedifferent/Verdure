package samebutdifferent.verdure.registry;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.item.TallHangingMossBlockItem;

public class VerdureItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Verdure.MOD_ID);

    public static final RegistryObject<Item> TALL_HANGING_MOSS = ITEMS.register("tall_hanging_moss", () -> new TallHangingMossBlockItem(VerdureBlocks.TALL_HANGING_MOSS.get(), new Item.Properties().tab(Verdure.TAB)));
}
