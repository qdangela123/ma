package net.zz.ma.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class SpeedArrowE extends Arrow
{
    public SpeedArrowE(EntityType<? extends Arrow> type,Level level)
    {
        super(type,level);
        this.setNoGravity(true);
    }
    public SpeedArrowE(Level level,LivingEntity owner)
    {
        super(level,owner);
        this.setNoGravity(true);
    }
}