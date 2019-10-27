package com.saist.listcoords;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

@Mod(modid = ListCoords.MODID, name = ListCoords.NAME, version = ListCoords.VERSION)
public class ListCoords  {
    public static final String MODID = "listcoords";
    public static final String NAME = "Kyle's Coords Finder";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.getMessage().getUnformattedText();
        System.out.println("message is: " + message);
        if(message.equals("<" + Minecraft.getMinecraft().player.getName() + "> $coords")) {
        	String pos = String.valueOf(Minecraft.getMinecraft().player.posX) + " " + String.valueOf(Minecraft.getMinecraft().player.posY) + " " + String.valueOf(Minecraft.getMinecraft().player.posZ);
        	String view_angle = "Pitch: " + Minecraft.getMinecraft().player.getPitchYaw().x + " \nYaw: " + Minecraft.getMinecraft().player.getPitchYaw().y;
        	Helper.printMessageNaked(pos);
        	Helper.printMessageNaked(view_angle);
        	event.setMessage(null);
        }
    }
}
