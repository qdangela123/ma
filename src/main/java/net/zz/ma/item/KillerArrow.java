package net.zz.ma.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.zz.ma.entity.KillerArrowE;

public class KillerArrow extends ArrowItem
{
    public KillerArrow(Properties builder)
    {
        super(builder);
    }
    @Override
    public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter)
    {
        return new KillerArrowE(world, shooter);
    }
}
