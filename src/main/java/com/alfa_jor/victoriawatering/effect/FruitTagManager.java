package com.alfa_jor.victoriawatering.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class FruitTagManager {

    public static ItemStack insertTagItem(ItemStack weapon, Item fruit){
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(fruit);
        weapon.getOrCreateTag().putString("Fruit", id.toString());
        return weapon;
    }
}
