package net.zz.ma;

import net.minecraft.client.renderer.entity.TntRenderer;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DispenserBlock;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.entity.ArrowR;


import org.slf4j.Logger;
@Mod(ma.MODID)
public class ma
{
    public static final String MODID = "ma";
    public static final Logger LOGGER = LogUtils.getLogger();
    public ma(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        blocks.BLOCKS.register(modEventBus);
        items.ITEMS.register(modEventBus);
        entities.ENTITIES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        DispenserBlock.registerBehavior(items.SPEED_ARROW_ITEM.get(),new items.UniversalDispenseItemBehavior(entities.SPEEDARROW));
        DispenserBlock.registerBehavior(items.BOLT_ARROW_ITEM.get(),new items.UniversalDispenseItemBehavior(entities.BOLTARROW));
        DispenserBlock.registerBehavior(items.EXPLODE_ARROW_ITEM.get(),new items.UniversalDispenseItemBehavior(entities.EXPLODEARROW));
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            for(RegistryObject<Item> item:items.ITEMS.getEntries())
            {
                if(item.get() instanceof ArrowItem)
                {
                    event.accept(item);
                }
            }
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
        @SubscribeEvent
        public static void entitySetup(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerEntityRenderer(entities.SPEEDARROW.get(), ArrowR::new);
            event.registerEntityRenderer(entities.BOLTARROW.get(), ArrowR::new);
            event.registerEntityRenderer(entities.EXPLODEARROW.get(), ArrowR::new);
            event.registerEntityRenderer(entities.SUPERTNTE.get(), TntRenderer::new);
        }
    }
}
