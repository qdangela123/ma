package net.zz.ma.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.zz.ma.entity.SpeedArrowE;


public class SpeedArrow extends ArrowItem
{
    public SpeedArrow(Properties builder)
    {
        super(builder);
    }
    @Override
    public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter)
    {
        Arrow a = new Arrow(world, shooter);
        a.setNoGravity(true);
        Vec3 x = a.getDeltaMovement();
        a.setDeltaMovement(x.multiply(2,2,2));
        a.setBaseDamage(a.getBaseDamage() * 4);
        return a;
    }
}
