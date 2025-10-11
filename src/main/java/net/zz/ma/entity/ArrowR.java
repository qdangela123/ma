package net.zz.ma.entity;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Arrow;

public class ArrowR extends ArrowRenderer<Arrow>
{
    public ArrowR(EntityRendererProvider.Context context)
    {
        super(context);
    }
    public ResourceLocation getTextureLocation(Arrow entity)
    {
        return new ResourceLocation("ma", "textures/entity/arrow.png");
    }
}
