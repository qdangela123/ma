package net.zz.ma.subscriber;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.phys.HitResult;
import net.zz.ma.ma;
import net.zz.ma.entity.KillerArrowE;
@Mod.EventBusSubscriber(modid=ma.MODID)
public class KillerArrowHandler
{
    @SubscribeEvent
    public static void onArrowHit(ProjectileImpactEvent event)
    {
        if(!(event.getProjectile() instanceof KillerArrowE arrow)||event.getRayTraceResult().getType()!=HitResult.Type.ENTITY)
        {
            return;
        }
        Entity hitEntity=((EntityHitResult) event.getRayTraceResult()).getEntity();
        if(!(hitEntity instanceof LivingEntity livingTarget))
        {
            return;
        }
        float currentHealth=livingTarget.getHealth();
        float damage=500;
        if(currentHealth<=300)
        {
            damage=currentHealth;
        }
        else if(currentHealth<=1100)
        {
            damage=(currentHealth-300)/4+300;
        }
        arrow.level().explode(arrow,hitEntity.getX(),hitEntity.getY(),hitEntity.getZ(),damage,false,Level.ExplosionInteraction.BLOCK);
        arrow.remove(RemovalReason.DISCARDED);
    }
}