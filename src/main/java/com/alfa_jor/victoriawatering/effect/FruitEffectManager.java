package com.alfa_jor.victoriawatering.effect;

import com.alfa_jor.victoriawatering.ModFoods;
import com.alfa_jor.victoriawatering.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.enchantment.Enchantments;

public class FruitEffectManager  {

    private static final int INPUT_1 = 0;
    private static final int INPUT_2 = 1;


    public FruitEffectManager(){

    }

    public static ItemStack enchantItem(ItemStack stack1, ItemStack stack2 ){

        if(manager(stack1, INPUT_1) && manager(stack2, INPUT_2)){
            return enchant(stack1, stack2);

        } else {
            return stack1.EMPTY;
        }


    }

    private static boolean manager(ItemStack stack, int INPUT) {
        boolean aux = false;

        switch (INPUT){
            case INPUT_1 -> aux = stack.getItem() instanceof SwordItem;
            case INPUT_2 -> aux = stack.getItem() == ModItems.GRANA.get();
            default -> aux = false;
        }

        return aux;
    }


    public static ItemStack enchant(ItemStack arma, ItemStack fruit){

        if (fruit.is(fruit.getItem())){
            arma.enchant(Enchantments.SHARPNESS, 6);
        }

        return arma;

    }
}
