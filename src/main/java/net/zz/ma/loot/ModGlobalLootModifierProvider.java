package net.zz.ma.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.zz.ma.items;
import net.zz.ma.ma;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider
{
    public ModGlobalLootModifierProvider(PackOutput output)
    {
        super(output,ma.MODID);
    }
    @Override
    protected void start()
    {
        add("blood_from_bat",new AddItemModifier(new LootItemCondition[]{
            new LootTableIdCondition.Builder(new ResourceLocation("entities/bat")).build()
        },items.BLOOD_ITEM.get()));
    }
}
