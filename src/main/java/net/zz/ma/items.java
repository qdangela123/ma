package net.zz.ma;

import java.util.function.Supplier;

import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.item.BoltArrow;
import net.zz.ma.item.ExplodeArrow;
import net.zz.ma.item.SpeedArrow;
// import net.minecraft.world.item.ArrowItem;

public class items
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ma.MODID);
    public static final RegistryObject<Item> SPEED_ARROW_ITEM = ITEMS.register("speedarrow",() -> new SpeedArrow(new Item.Properties()));
    public static final RegistryObject<Item> BOLT_ARROW_ITEM = ITEMS.register("boltarrow",() -> new BoltArrow(new Item.Properties()));
    public static final RegistryObject<Item> EXPLODE_ARROW_ITEM = ITEMS.register("explodearrow",() -> new ExplodeArrow(new Item.Properties()));
    public static class UniversalDispenseItemBehavior extends AbstractProjectileDispenseBehavior
    {
        private final Supplier<? extends EntityType<? extends AbstractArrow>> arrowEntityType;
        public UniversalDispenseItemBehavior(Supplier<? extends EntityType<? extends AbstractArrow>> arrowEntityType) {
            this.arrowEntityType = arrowEntityType;
        }
        @Override
        protected Projectile getProjectile(Level world, Position pos, ItemStack itemstack)
        {
            AbstractArrow arrow = arrowEntityType.get().create(world);
            arrow.setPos(pos.x(),pos.y(),pos.z());
            return arrow;
        }
    }
}
