package com.alfa_jor.victoriawatering.item;

import com.alfa_jor.victoriawatering.ModFoods;
import com.alfa_jor.victoriawatering.VictoriaWatering;
import com.alfa_jor.victoriawatering.block.ModBlocks;
import com.alfa_jor.victoriawatering.item.custom.WateringCanItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VictoriaWatering.MOD_ID);

    public static final RegistryObject<Item> WATERING_CAN = ITEMS.register("wateringcan",
            () -> new WateringCanItem(new Item.Properties().stacksTo(1))
    );
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(ModFoods.MANGO))
    );
    public static final RegistryObject<Item> CILANTRO_SEEDS = ITEMS.register("cilantro_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CILANTRO_CROP.get(),new Item.Properties())
    );
    public static final RegistryObject<Item> CILANTRO = ITEMS.register("cilantro",
            () -> new Item(new Item.Properties())
    );
    public static final RegistryObject<Item> FLOWER_CILANTRO = ITEMS.register("flower_cilantro",
            () -> new Item(new Item.Properties())
    );

    public static final RegistryObject<Item> GRANA = ITEMS.register("grana",
            () -> new Item(new Item.Properties().food(ModFoods.GRANA)));

    public static final RegistryObject<Item> GRANA_SEEDS = ITEMS.register("grana_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GRANA_CROP.get(),new Item.Properties())
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
