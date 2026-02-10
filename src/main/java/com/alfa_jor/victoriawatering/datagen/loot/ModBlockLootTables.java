package com.alfa_jor.victoriawatering.datagen.loot;

import com.alfa_jor.victoriawatering.block.ModBlocks;
import com.alfa_jor.victoriawatering.block.custom.CilantroCropblock;
import com.alfa_jor.victoriawatering.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import static net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition.hasBlockStateProperties;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        LootItemCondition.Builder age3 =
                LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CILANTRO_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CilantroCropblock.AGE, 3));
        LootItemCondition.Builder age4 =
                LootItemBlockStatePropertyCondition
                        .hasBlockStateProperties(ModBlocks.CILANTRO_CROP.get())
                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                .hasProperty(CilantroCropblock.AGE, 4));

        this.add(ModBlocks.CILANTRO_CROP.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable()
                                .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .when(age3.invert())
                                        .when(age4.invert())
                                        .add(LootItem.lootTableItem(ModItems.CILANTRO_SEEDS.get()))
                                )
                                .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .when(age3)
                                        .add(LootItem.lootTableItem(ModItems.CILANTRO.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                )
                                .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .when(age4)
                                        .add(LootItem.lootTableItem(ModItems.FLOWER_CILANTRO.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                )
                                .withPool(LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1))
                                        .when(age4)
                                        .add(LootItem.lootTableItem(ModItems.CILANTRO_SEEDS.get())
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f))))
                                )
                )
                );

        this.dropSelf(ModBlocks.SUNFLOWER_BLOCK.get());


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
