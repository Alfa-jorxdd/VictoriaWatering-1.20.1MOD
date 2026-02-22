package com.alfa_jor.victoriawatering.events;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EffectsItemsEventMod {

    @SubscribeEvent
    public void effectTick(LivingEvent.LivingTickEvent event){

        if (!(event.getEntity() instanceof Player player)){ return;}

        if(!player.level().isClientSide()){
            ItemStack hand = event.getEntity().getMainHandItem();
            if(hand.hasTag()){
                if (hand.getTag().contains("victoria:fruit")){
                    applyEfectPlayer(hand, player);
                }
            }

        }
    }

    public void applyEfectPlayer(ItemStack stack, Player player){
        if (stack.getTag().getString("victoria:fruit") == "grana") {
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 3));
        }
    }
}
