package net.zz.ma.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class VampireArrowE extends Arrow
{
    public VampireArrowE(EntityType<? extends Arrow> entityType, Level world)
    {
        super(entityType,world);
    }
    public VampireArrowE(Level level,LivingEntity owner)
    {
        super(level,owner);
    }
}
