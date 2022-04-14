package samebutdifferent.verdure.registry;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.block.entity.HollowLogBlockEntity;

public class VerdureBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Verdure.MOD_ID);

    public static final RegistryObject<BlockEntityType<HollowLogBlockEntity>> HOLLOW_LOG = BLOCK_ENTITY_TYPES.register("hollow_log", () -> BlockEntityType.Builder.of(HollowLogBlockEntity::new, VerdureBlocks.HOLLOW_LOG.get()).build(null));
}
