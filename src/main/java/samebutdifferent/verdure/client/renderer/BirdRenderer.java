package samebutdifferent.verdure.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.client.model.BirdModel;
import samebutdifferent.verdure.entity.Bird;

@OnlyIn(Dist.CLIENT)
public class BirdRenderer extends MobRenderer<Bird, BirdModel> {
    public BirdRenderer(EntityRendererProvider.Context context) {
        super(context, new BirdModel(context.bakeLayer(BirdModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(Bird pEntity) {
        return new ResourceLocation(Verdure.MOD_ID, "textures/entity/bird.png");
    }

    @Override
    public float getBob(Bird pLivingBase, float pPartialTicks) {
        float f = Mth.lerp(pPartialTicks, pLivingBase.oFlap, pLivingBase.flap);
        float f1 = Mth.lerp(pPartialTicks, pLivingBase.oFlapSpeed, pLivingBase.flapSpeed);
        return (Mth.sin(f) + 1.0F) * f1;
    }
}
