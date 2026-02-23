package com.alfa_jor.victoriawatering.item;

import com.alfa_jor.victoriawatering.ModFoods;
import com.alfa_jor.victoriawatering.VictoriaWatering;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoodItems {

    public static final DeferredRegister<Item> FOODS =
            DeferredRegister.create(ForgeRegistries.ITEMS, VictoriaWatering.MOD_ID);

    public static final RegistryObject<Item> MANGO = FOODS.register("mango",
            () -> new Item(new Item.Properties().food(ModFoods.MANGO))
    );

    public static final RegistryObject<Item> GRANA = FOODS.register("grana",
            () -> new Item(new Item.Properties().food(ModFoods.GRANA)));

    public static final RegistryObject<Item> CILANTRO = FOODS.register("cilantro",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus bus){
        FOODS.register(bus);
    }
}
