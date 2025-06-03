package com.example.killaura.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fmlclient.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
    public static KeyMapping OPEN_GUI;

    public static void register() {
        OPEN_GUI = new KeyMapping("key.killaura.open_gui", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "key.categories.killaura");
        ClientRegistry.registerKeyBinding(OPEN_GUI);
    }

    @SubscribeEvent
    public static void onKey(InputEvent.KeyInputEvent event) {
        if (OPEN_GUI.isDown()) {
            Minecraft.getInstance().setScreen(new GuiKillauraSettings());
        }
    }
}
