package net.ronondex2009;



import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(essence_of_harmony.mod_id)
public class essence_of_harmony {
    //keep the modid which will be used always for something
    public static final String mod_id = "essence_of_harmony";
    //directly reference a blah blah blah logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public essence_of_harmony() 
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        //adding ourselves as a listener because we like evesedropping or something idk I never modded before
        eventBus.addListener(this::commonSetup);

        //I dont know what this does
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO HOW ARE YOU?");
    }

    @SubscribeEvent
    public void onServerStart(ServerStartingEvent event)
    {

    }
}
