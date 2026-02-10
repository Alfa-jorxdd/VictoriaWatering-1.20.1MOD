package com.alfa_jor.victoriawatering;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties MANGO = new FoodProperties.Builder().nutrition(5).fast().
            saturationMod(0.5f).effect(()-> new MobEffectInstance(
                    MobEffects.DAMAGE_BOOST, 1200, 1), 1.0f).effect(
                            new MobEffectInstance(
                                    MobEffects.DAMAGE_RESISTANCE, 1200, 1), 1.0f).build();

    public static final FoodProperties GRANA = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.5f).effect(() -> new MobEffectInstance(
                    MobEffects.DAMAGE_BOOST, 50, 0), 1.0f).build();
}
