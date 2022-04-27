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

    public static final RegistryObject<Block> PEBBLES = registerBlock("pebbles", () -> new PebblesBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.2F).noCollission()));
    public static final RegistryObject<Block> ROCK = registerBlock("rock", () -> new RockBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.4F).noCollission()));
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
    public static final RegistryObject<Block> HANGING_MOSS = registerBlock("hanging_moss", () -> new HangingMossBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.MOSS)));
    public static final RegistryObject<Block> TALL_HANGING_MOSS = BLOCKS.register("tall_hanging_moss", () -> new TallHangingMossBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_GREEN).noCollission().instabreak().sound(SoundType.MOSS)));
    public static final RegistryObject<Block> HUMUS = registerBlock("humus", () -> new SnowyDirtBlock(BlockBehaviour.Properties.of(Material.DIRT, MaterialColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> FALLEN_OAK_LEAVES = registerBlock("fallen_oak_leaves", () -> new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0F).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> FALLEN_BIRCH_LEAVES = registerBlock("fallen_birch_leaves", () -> new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0F).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> FALLEN_SPRUCE_LEAVES = registerBlock("fallen_spruce_leaves", () -> new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0F).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> FALLEN_JUNGLE_LEAVES = registerBlock("fallen_jungle_leaves", () -> new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0F).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> FALLEN_ACACIA_LEAVES = registerBlock("fallen_acacia_leaves", () -> new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0F).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> FALLEN_DARK_OAK_LEAVES = registerBlock("fallen_dark_oak_leaves", () -> new FallenLeavesBlock(BlockBehaviour.Properties.of(Material.CLOTH_DECORATION).strength(0F).sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> OAK_BRANCH = registerBlock("oak_branch", () -> new BranchBlock(Blocks.OAK_LOG, VerdureBlocks.FALLEN_OAK_LEAVES.get(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noCollission().noOcclusion().strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BIRCH_BRANCH = registerBlock("birch_branch", () -> new BranchBlock(Blocks.BIRCH_LOG, VerdureBlocks.FALLEN_OAK_LEAVES.get(), BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).noCollission().noOcclusion().strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WALL_ROOTS = BLOCKS.register("wall_roots", () -> new WallRootsBlock(BlockBehaviour.Properties.copy(Blocks.HANGING_ROOTS)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = VerdureBlocks.BLOCKS.register(name, block);
        VerdureItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(Verdure.TAB)));
        return toReturn;
    }
}
