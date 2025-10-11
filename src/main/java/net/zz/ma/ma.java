package net.zz.ma;

import net.minecraft.world.item.CreativeModeTabs;
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
        items.ITEMS.register(modEventBus);
        entities.ENTITIES.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(items.SPEED_ARROW_ITEM);
            event.accept(items.BOLT_ARROW_ITEM);
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
            // ItemProperties.register(items.SPEED_ARROW_ITEM.get(), new ResourceLocation("pull"), (itemStack, clientWorld, livingEntity, seed) -> {
            //     if (livingEntity == null) {
            //         return 0.0F;
            //     }
            //     return livingEntity.getUseItem().getItem() instanceof BowItem ? (livingEntity.getTicksUsingItem()) / 20.0F : 0.0F;
            // });
            // ItemProperties.register(items.SPEED_ARROW_ITEM.get(), new ResourceLocation("pulling"), (itemStack, clientWorld, livingEntity, seed) -> {
            //     if (livingEntity == null) {
            //         return 0.0F;
            //     }
            //     return livingEntity.isUsingItem() && livingEntity.getUseItem().getItem() instanceof BowItem ? 1.0F : 0.0F;
            // });
        }
        @SubscribeEvent
        public static void entitySetup(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerEntityRenderer(entities.SPEEDARROW.get(), ArrowR::new);
            event.registerEntityRenderer(entities.BOLTARROW.get(), ArrowR::new);
        }
    }
}
