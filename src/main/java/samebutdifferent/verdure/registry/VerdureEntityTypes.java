package samebutdifferent.verdure.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.entity.Bird;

public class VerdureEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Verdure.MOD_ID);

    public static final RegistryObject<EntityType<Bird>> BIRD = ENTITY_TYPES.register("bird", () -> EntityType.Builder.of(Bird::new, MobCategory.CREATURE).sized(0.5F, 0.9F).clientTrackingRange(8).build(new ResourceLocation(Verdure.MOD_ID, "bird").toString()));
}
