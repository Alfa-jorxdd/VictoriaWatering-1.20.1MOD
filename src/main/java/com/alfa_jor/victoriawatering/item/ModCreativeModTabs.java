package com.alfa_jor.victoriawatering.item;

import com.alfa_jor.victoriawatering.VictoriaWatering;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, VictoriaWatering.MOD_ID
    );

    public static final RegistryObject<CreativeModeTab> VICWAT_TAB = CREATIVE_MOD_TABS.register("vicwat_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MANGO.get()))
                    .title(Component.translatable("creativetab.vicwat_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WATERING_CAN.get());
                        output.accept(ModItems.MANGO.get());
                    })
                    .build()
            );

    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
