package net.zz.ma;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.block.SuperTNT;

public class blocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,ma.MODID);
    public static final RegistryObject<Block> SUPERTNT = register("supertnt",() -> new SuperTNT(BlockBehaviour.Properties.copy(Blocks.TNT)));
    public static <T extends Block> RegistryObject<T> register(String name,Supplier<T> block)
    {
        RegistryObject<T> object = BLOCKS.register(name,block);
        items.ITEMS.register(name,() -> new BlockItem(object.get(),new Item.Properties()));
        return object;
    }
}
