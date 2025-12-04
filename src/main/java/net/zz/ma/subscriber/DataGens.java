package net.zz.ma.subscriber;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zz.ma.ma;
import net.zz.ma.loot.ModGlobalLootModifierProvider;

@Mod.EventBusSubscriber(modid=ma.MODID,bus=Mod.EventBusSubscriber.Bus.MOD)
public class DataGens
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator=event.getGenerator();
        PackOutput packOutput=generator.getPackOutput();
        generator.addProvider(event.includeServer(),new ModGlobalLootModifierProvider(packOutput));
    }
}
