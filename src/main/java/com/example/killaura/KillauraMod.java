package com.example.killaura;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod("killaura")
@EventBusSubscriber(modid = "killaura", bus = Bus.MOD, value = Dist.CLIENT)
public class KillauraMod {
    public KillauraMod() {}

    public static void onClientSetup(final FMLClientSetupEvent event) {
        // Setup code here
    }
}
