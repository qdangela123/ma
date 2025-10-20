package net.zz.ma.entity;

import javax.annotation.Nullable;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;

public class SuperTNTE extends PrimedTnt
{
    public SuperTNTE(EntityType<? extends PrimedTnt> entityType,Level world)
    {
        super(entityType,world);
    }
    public SuperTNTE(Level world,double x,double y,double z,@Nullable LivingEntity player)
    {
        super(world,x,y,z,player);
    }
    @Override
    protected void explode()
    {
        this.level().explode(this,this.getX(),this.getY(0.0625D),this.getZ(),20,true,Level.ExplosionInteraction.TNT);
    }
}
