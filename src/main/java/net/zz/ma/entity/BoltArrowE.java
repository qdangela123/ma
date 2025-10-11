package net.zz.ma.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class BoltArrowE extends Arrow
{
    public BoltArrowE(EntityType<? extends Arrow> type,Level level)
    {
        super(type,level);
    }
    public BoltArrowE(Level level,LivingEntity owner)
    {
        super(level,owner);
    }
    @Override
    protected void onHit(HitResult result)
    {
        super.onHit(result);
        if(!this.level().isClientSide)
        {
            Vec3 hitPos = result.getLocation();
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT,this.level());
            bolt.setPos(hitPos);
            this.level().addFreshEntity(bolt);
        }
    }
}