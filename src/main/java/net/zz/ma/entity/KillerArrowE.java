package net.zz.ma.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class KillerArrowE extends Arrow
{
    public KillerArrowE(EntityType<? extends Arrow> entityType, Level world) {
        super(entityType,world);
    }
    public KillerArrowE(Level level,LivingEntity owner)
    {
        super(level,owner);
    }
}
