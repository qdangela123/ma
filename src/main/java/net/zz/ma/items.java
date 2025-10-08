package net.zz.ma;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.item.SpeedArrow;
// import net.minecraft.world.item.ArrowItem;

public class items
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ma.MODID);
    public static final RegistryObject<Item> SPEED_ARROW_ITEM = ITEMS.register("speedarrow",()->new SpeedArrow(new Item.Properties()));
}
