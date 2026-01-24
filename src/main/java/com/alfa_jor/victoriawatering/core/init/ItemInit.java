package com.alfa_jor.victoriawatering.core.init;

import com.alfa_jor.victoriawatering.VictoriaWatering;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    //En anteriores versiones solo se pasaba el register, ahora se debe pasar tmb el modid
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VictoriaWatering.MOD_ID);

    public static final RegistryObject<Item> PRIMER_ITEM = ITEMS.register("primer_item",
            () -> new Item(new Item.Properties())
    );
}
