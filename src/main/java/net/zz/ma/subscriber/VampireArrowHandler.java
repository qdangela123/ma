package net.zz.ma.subscriber;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.phys.HitResult;
import net.zz.ma.ma;
import net.zz.ma.entity.VampireArrowE;
@Mod.EventBusSubscriber(modid=ma.MODID)
public class VampireArrowHandler
{
    private static float min(float a,float b)
    {
        return a<b?a:b;
    }
    @SubscribeEvent
    public static void onArrowHit(ProjectileImpactEvent event)
    {
        if(!(event.getProjectile() instanceof VampireArrowE arrow)||event.getRayTraceResult().getType()!=HitResult.Type.ENTITY)
        {
            return;
        }
        if(!(arrow.getOwner() instanceof LivingEntity owner))
        {
            return;
        }
        Entity hitEntity=((EntityHitResult) event.getRayTraceResult()).getEntity();
        if(!(hitEntity instanceof LivingEntity target))
        {
            return;
        }
        float targetHealth=target.getHealth();
        float ownerHealth=owner.getHealth();
        float ownerMaxHealth=owner.getMaxHealth();
        float heal;
        if(ownerHealth > ownerMaxHealth / 2)
        {
            heal=min(ownerMaxHealth-ownerHealth,targetHealth);
        }
        else
        {
            heal=min(ownerMaxHealth/2,targetHealth);
        }
        owner.heal(heal);
        target.hurt(target.damageSources().arrow(arrow,owner),heal);
        arrow.remove(RemovalReason.DISCARDED);
    }
}