package net.zz.ma;

import com.mojang.serialization.Codec;

import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.loot.AddItemModifier;
public class loots
{
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER=DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,ma.MODID);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM=LOOT_MODIFIER.register("additem",AddItemModifier.CODEC);
}
