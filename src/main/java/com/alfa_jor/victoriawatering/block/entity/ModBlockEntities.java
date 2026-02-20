package com.alfa_jor.victoriawatering.block.entity;

import com.alfa_jor.victoriawatering.VictoriaWatering;
import com.alfa_jor.victoriawatering.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//3
public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCKS_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, VictoriaWatering.MOD_ID);


    public static final RegistryObject<BlockEntityType<MagicComposterBlockEntity>> MAGIC_COMPOSTER_BE =
            BLOCKS_ENTITIES.register("magic_composter_be", () ->
                    BlockEntityType.Builder.of(MagicComposterBlockEntity::new,
                            ModBlocks.MAGIC_COMPOSTER.get()).build(null));

    public static void register(IEventBus bus){
        BLOCKS_ENTITIES.register(bus);
    }

}
