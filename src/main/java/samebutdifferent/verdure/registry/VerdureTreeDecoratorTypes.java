package samebutdifferent.verdure.registry;

import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.worldgen.treedecorator.BranchDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.DaisiesDecorator;
import samebutdifferent.verdure.worldgen.treedecorator.HollowLogDecorator;

public class VerdureTreeDecoratorTypes {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = DeferredRegister.create(ForgeRegistries.TREE_DECORATOR_TYPES, Verdure.MOD_ID);

    public static final RegistryObject<TreeDecoratorType<DaisiesDecorator>> DAISIES = TREE_DECORATOR_TYPES.register("daisies", () -> new TreeDecoratorType<>(DaisiesDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<HollowLogDecorator>> HOLLOW_LOG = TREE_DECORATOR_TYPES.register("hollow_log", () -> new TreeDecoratorType<>(HollowLogDecorator.CODEC));
    public static final RegistryObject<TreeDecoratorType<BranchDecorator>> BRANCH = TREE_DECORATOR_TYPES.register("branch", () -> new TreeDecoratorType<>(BranchDecorator.CODEC));

}
