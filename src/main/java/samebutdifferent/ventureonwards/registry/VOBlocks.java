package samebutdifferent.ventureonwards.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.ventureonwards.VentureOnwards;
import samebutdifferent.ventureonwards.block.PebblesBlock;
import samebutdifferent.ventureonwards.block.RockBlock;

import java.util.function.Supplier;

public class VOBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VentureOnwards.MOD_ID);

    public static final RegistryObject<Block> PEBBLES = registerBlock("pebbles", () -> new PebblesBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.2F)));
    public static final RegistryObject<Block> ROCK = registerBlock("rock", () -> new RockBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.4F)));
    public static final RegistryObject<Block> CLOVER = registerBlock("clover", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> SMOOTH_DIRT = registerBlock("smooth_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VOBlocks.BLOCKS.register(name, block);
        VOItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(VentureOnwards.TAB)));
        return toReturn;
    }
}
