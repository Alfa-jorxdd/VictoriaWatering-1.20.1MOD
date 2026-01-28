package com.alfa_jor.victoriawatering.item;

import com.alfa_jor.victoriawatering.ModFoods;
import com.alfa_jor.victoriawatering.VictoriaWatering;
import com.alfa_jor.victoriawatering.item.custom.WateringCanItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VictoriaWatering.MOD_ID);

    public static final RegistryObject<Item> WATERING_CAN = ITEMS.register("wateringcan",
            () -> new WateringCanItem(new Item.Properties())
    );

    public static final RegistryObject<Item> MANGO = ITEMS.register("mango",
            () -> new Item(new Item.Properties().food(ModFoods.MANGO))
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
