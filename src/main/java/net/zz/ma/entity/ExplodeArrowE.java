package net.zz.ma.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class ExplodeArrowE extends Arrow
{
    public ExplodeArrowE(EntityType<? extends Arrow> entityType, Level world) {
        super(entityType,world);
    }
    public ExplodeArrowE(Level level,LivingEntity owner)
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
            // Explosion explosion = new Explosion(this.level(),null,null,null,hitPos.x,hitPos.y,hitPos.z,50,true,Explosion.BlockInteraction.DESTROY);
            // explosion.explode();
            // explosion.finalizeExplosion(true);
            this.level().explode(this,hitPos.x,hitPos.y,hitPos.z,10,true,Level.ExplosionInteraction.BLOCK);
            remove(RemovalReason.DISCARDED);
        }
    }
}
