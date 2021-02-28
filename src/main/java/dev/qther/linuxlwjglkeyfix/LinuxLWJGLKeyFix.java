package dev.qther.linuxlwjglkeyfix;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(
        modid = LinuxLWJGLKeyFix.MODID,
        name = LinuxLWJGLKeyFix.MOD_NAME,
        version = LinuxLWJGLKeyFix.VERSION ,
        acceptableRemoteVersions = "*"
)
public class LinuxLWJGLKeyFix
{
    public static final String MODID = "linuxlwjglkeyfix";
    public static final String MOD_NAME = "LinuxLWJGLKeyFix";
    public static final String VERSION = "1.0.0";

    public static final Minecraft mc = Minecraft.getMinecraft();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (mc.thePlayer != null && Keyboard.isCreated()) {
            if (Keyboard.getEventKeyState()) {
                int keyCode = Keyboard.getEventKey();
                switch (keyCode) {
                    case 145: {
                        if (mc.gameSettings.keyBindsHotbar[1].getKeyCode() == 3) mc.thePlayer.inventory.currentItem = 1;
                        break;
                    }
                    case 144: {
                        if (mc.gameSettings.keyBindsHotbar[5].getKeyCode() == 7) mc.thePlayer.inventory.currentItem = 5;
                        break;
                    }
                }
            }
        }
    }
}
