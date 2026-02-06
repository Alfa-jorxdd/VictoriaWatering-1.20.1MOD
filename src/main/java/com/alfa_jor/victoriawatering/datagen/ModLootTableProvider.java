package com.alfa_jor.victoriawatering.datagen;

import com.alfa_jor.victoriawatering.datagen.loot.ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider{

    public static final LootTableProvider create(PackOutput packOutput){
        return new LootTableProvider(packOutput, Set.of(), List.of(
           new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }

}
