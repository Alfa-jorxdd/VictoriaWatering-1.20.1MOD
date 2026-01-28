package com.alfa_jor.victoriawatering;

import com.alfa_jor.victoriawatering.block.ModBlocks;
import com.alfa_jor.victoriawatering.item.ModCreativeModTabs;
import com.alfa_jor.victoriawatering.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("victoriawatering")

public class VictoriaWatering
{
    public static final String MOD_ID = "victoriawatering";
    private static final Logger LOGGER = LogUtils.getLogger();

    public VictoriaWatering(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        //PESTAÑA CREATIVO
        ModCreativeModTabs.register(bus);

        //OBJETOS
        ModItems.register(bus);
        ModBlocks.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.WATERING_CAN);
            event.accept(ModItems.MANGO);
        }
    }

    @SubscribeEvent
    public void onServerSarting(ServerStartingEvent event){

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){

        }
    }

    //Push de prueba a GitHub :)
}
