package net.zz.ma;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zz.ma.entity.BoltArrowE;
import net.zz.ma.entity.ExplodeArrowE;
import net.zz.ma.entity.KillerArrowE;
import net.zz.ma.entity.SpeedArrowE;
import net.zz.ma.entity.SuperTNTE;
public class entities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,ma.MODID);
    public static final RegistryObject<EntityType<SpeedArrowE>> SPEEDARROW = ENTITIES.register("speedarrowe",() -> EntityType.Builder.<SpeedArrowE>of(SpeedArrowE::new, MobCategory.MISC).sized(0.5f,0.5f).clientTrackingRange(4).updateInterval(20).build("speedarrowe"));
    public static final RegistryObject<EntityType<BoltArrowE>> BOLTARROW = ENTITIES.register("boltarrowe",() -> EntityType.Builder.<BoltArrowE>of(BoltArrowE::new,MobCategory.MISC).sized(0.5f,0.5f).clientTrackingRange(4).updateInterval(20).build("boltarrowe"));
    public static final RegistryObject<EntityType<ExplodeArrowE>> EXPLODEARROW = ENTITIES.register("explodearrowe",() -> EntityType.Builder.<ExplodeArrowE>of(ExplodeArrowE::new,MobCategory.MISC).sized(0.5f,0.5f).clientTrackingRange(4).updateInterval(20).build("explodearrowe"));
    public static final RegistryObject<EntityType<KillerArrowE>> KILLERARROW = ENTITIES.register("killerarrowe",() -> EntityType.Builder.<KillerArrowE>of(KillerArrowE::new,MobCategory.MISC).sized(0.5f,0.5f).clientTrackingRange(4).updateInterval(20).build("killerarrowe"));
    public static final RegistryObject<EntityType<SuperTNTE>> SUPERTNTE = ENTITIES.register("supertnte",() -> EntityType.Builder.<SuperTNTE>of(SuperTNTE::new,MobCategory.MISC).build("supertnte"));
}
