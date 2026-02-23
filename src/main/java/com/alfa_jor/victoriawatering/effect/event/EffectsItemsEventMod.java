package com.alfa_jor.victoriawatering.effect.event;

import com.alfa_jor.victoriawatering.Class;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectsItemsEventMod {

    @SubscribeEvent
    public void effectTick(LivingEvent.LivingTickEvent event){
        if (!(event.getEntity() instanceof Player player)){ return;}

        if(!player.level().isClientSide()){
            ItemStack hand = event.getEntity().getMainHandItem();//<----SOLO ADMITE LA MANO MAIN
            if(hand.hasTag()){
                if (hand.getTag().contains("Fruit")){
                    applyEfectPlayer(hand, player);
                }
            }

        }
    }

    public void applyEfectPlayer(ItemStack stack, Player player){
        String id = stack.getTag().getString("Fruit");
        ResourceLocation resourceLocation = ResourceLocation.parse(id);
        Item fruit = ForgeRegistries.ITEMS.getValue(resourceLocation);

        MobEffectInstance effectInstance = Class.getEffect(fruit);
        if (effectInstance != null){
            player.addEffect(effectInstance);
        }
    }
}
