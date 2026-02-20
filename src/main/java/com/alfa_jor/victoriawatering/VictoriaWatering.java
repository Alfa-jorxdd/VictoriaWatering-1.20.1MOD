package com.alfa_jor.victoriawatering;

import com.alfa_jor.victoriawatering.block.ModBlocks;
import com.alfa_jor.victoriawatering.block.entity.ModBlockEntities;
import com.alfa_jor.victoriawatering.item.ModCreativeModTabs;
import com.alfa_jor.victoriawatering.item.ModItems;
import com.alfa_jor.victoriawatering.screen.MagicComposterScreen;
import com.alfa_jor.victoriawatering.screen.ModMenuTypes;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
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

        ModMenuTypes.register(bus);

        ModBlockEntities.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event){

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event){

    }

    @SubscribeEvent
    public void onServerSarting(ServerStartingEvent event){

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents{
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event){


            MenuScreens.register(ModMenuTypes.MAGIC_COMPOSTER_MENU.get(), MagicComposterScreen::new);
        }
    }

    //Push de prueba a GitHub :)
}
