package com.alfa_jor.victoriawatering.effect.event;

import com.alfa_jor.victoriawatering.effect.FruitEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectsItemsEventMod {

    private static final String fruitKey = "Fruit";

    @SubscribeEvent
    public void effectTick(LivingEvent.LivingTickEvent event){
        if (!(event.getEntity() instanceof Player player)){ return;}

        if(!player.level().isClientSide()){
            ItemStack handMain = event.getEntity().getMainHandItem();
            ItemStack handOff = event.getEntity().getOffhandItem();
            if(handMain.hasTag() && handMain.getTag().contains(fruitKey)){
                applyEfectPlayer(handMain, player);
            }
            if(handOff.hasTag() && handOff.getTag().contains(fruitKey)){
                applyEfectPlayer(handOff, player);
            }
        }
    }

    public void applyEfectPlayer(ItemStack stack, Player player){
        if (stack.getTag() != null){
            String id = stack.getTag().getString(fruitKey);
            ResourceLocation resourceLocation = ResourceLocation.parse(id);
            Item fruit = ForgeRegistries.ITEMS.getValue(resourceLocation);

            MobEffectInstance effectInstance = FruitEffect.getEffect(fruit);
            if (effectInstance != null){
                player.addEffect(effectInstance);
            }
        }
    }
}
