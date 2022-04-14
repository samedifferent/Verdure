package samebutdifferent.verdure.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.block.*;

import java.util.function.Supplier;

public class VerdureBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Verdure.MOD_ID);

    public static final RegistryObject<Block> PEBBLES = registerBlock("pebbles", () -> new PebblesBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.2F)));
    public static final RegistryObject<Block> ROCK = registerBlock("rock", () -> new RockBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.4F)));
    public static final RegistryObject<Block> CLOVER = registerBlock("clover", () -> new CloverBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> SMOOTH_DIRT = registerBlock("smooth_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> BROWN_MUSHROOM_SHELF = BLOCKS.register("brown_mushroom_shelf", () -> new MushroomShelfBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).noCollission().instabreak().sound(SoundType.GRASS).lightLevel((state) -> 1)));
    public static final RegistryObject<Block> RED_MUSHROOM_SHELF = BLOCKS.register("red_mushroom_shelf", () -> new MushroomShelfBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_RED).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DAISIES = registerBlock("daisies", () -> new MultifaceBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BLUE_DAISIES = registerBlock("blue_daisies", () -> new MultifaceBlock(BlockBehaviour.Properties.copy(DAISIES.get())));
    public static final RegistryObject<Block> PINK_DAISIES = registerBlock("pink_daisies", () -> new MultifaceBlock(BlockBehaviour.Properties.copy(DAISIES.get())));
    public static final RegistryObject<Block> WILDFLOWERS = registerBlock("wildflowers", () -> new MultifaceBlock(BlockBehaviour.Properties.copy(DAISIES.get())));
    public static final RegistryObject<Block> SLATE = registerBlock("slate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> DRIED_MUD = registerBlock("dried_mud", () -> new DriedMudBlock(BlockBehaviour.Properties.of(Material.DIRT).strength(0.8F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> HOLLOW_LOG = registerBlock("hollow_log", () -> new HollowLogBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F).sound(SoundType.WOOD)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VerdureBlocks.BLOCKS.register(name, block);
        VerdureItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(Verdure.TAB)));
        return toReturn;
    }
}
