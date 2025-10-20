package net.zz.ma.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.zz.ma.entity.SuperTNTE;

public class SuperTNT extends TntBlock
{
    public SuperTNT(BlockBehaviour.Properties properties)
    {
        super(properties);
    }
    @Override
    public void onCaughtFire(BlockState state, Level world, BlockPos pos, @Nullable net.minecraft.core.Direction face, @Nullable LivingEntity igniter) {
        if(!world.isClientSide)
        {
            SuperTNTE primedtnt = new SuperTNTE(world,(double)pos.getX()+0.5D,(double)pos.getY(),(double)pos.getZ()+0.5D,igniter);
            world.addFreshEntity(primedtnt);
            world.playSound((Player)null,primedtnt.getX(),primedtnt.getY(),primedtnt.getZ(),SoundEvents.TNT_PRIMED, SoundSource.BLOCKS,1.0F,1.0F);
            world.gameEvent(igniter,GameEvent.PRIME_FUSE,pos);
        }
    }
    @Override
    public void wasExploded(Level world,BlockPos pos,Explosion explosion)
    {
        if (!world.isClientSide)
        {
            PrimedTnt primedtnt = new SuperTNTE(world,(double)pos.getX()+0.5D,(double)pos.getY(),(double)pos.getZ()+0.5D,explosion.getIndirectSourceEntity());
            primedtnt.setFuse(1);
            world.addFreshEntity(primedtnt);
        }
    }
}