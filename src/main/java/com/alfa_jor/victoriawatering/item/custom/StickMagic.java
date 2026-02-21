package com.alfa_jor.victoriawatering.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;

public class StickMagic extends Item {


    public StickMagic(Properties properties){
        super(properties);

    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }

    public static ItemStack encantar(ItemStack stack){
        stack.enchant(Enchantments.KNOCKBACK, 100);
        return stack;
    }
}
