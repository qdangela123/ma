package net.zz.ma.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SpeedArrowR extends ArrowRenderer<SpeedArrowE>
{
    public SpeedArrowR(EntityRendererProvider.Context context)
    {
        super(context);
    }
    public ResourceLocation getTextureLocation(SpeedArrowE entity)
    {
        return new ResourceLocation("ma", "textures/entity/arrow.png");
    }
}
