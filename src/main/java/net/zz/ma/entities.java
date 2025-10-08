package net.zz.ma;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.entity.SpeedArrowE;
public class entities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,ma.MODID);
    public static final RegistryObject<EntityType<SpeedArrowE>> SPEEDARROW = ENTITIES.register("speedarrowe",() -> EntityType.Builder.<SpeedArrowE>of(SpeedArrowE::new, MobCategory.MISC).sized(0.5f,0.5f).clientTrackingRange(4).updateInterval(20).build("torchflower_arrow"));
}
