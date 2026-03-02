package com.alfa_jor.victoriawatering.effect;

import com.alfa_jor.victoriawatering.item.ModFoodItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.function.Supplier;

public class FruitEffect {

    private static final HashMap<Item, Supplier<MobEffectInstance>> FRUIT = new HashMap<>();

    static {
        FRUIT.put(ModFoodItems.GRANA.get(), () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,100,2));
        FRUIT.put(ModFoodItems.MANGO.get(), () -> new MobEffectInstance(MobEffects.REGENERATION,100,2));
        FRUIT.put(ModFoodItems.CILANTRO.get(), () -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100,2));
    }

    public static boolean containFruit(Item fruit){
        if (FRUIT.containsKey(fruit)){
            return true;
        }
        return false;
    }

    public static MobEffectInstance getEffect(Item fruit){
        Supplier<MobEffectInstance> supplier = FRUIT.get(fruit);
        return supplier != null ? supplier.get() : null;
    }
}
