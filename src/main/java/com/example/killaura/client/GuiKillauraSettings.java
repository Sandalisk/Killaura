package com.example.killaura.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;

public class GuiKillauraSettings extends Screen {
    private Button toggleAuraButton;

    public GuiKillauraSettings() {
        super(new TextComponent("Killaura Settings"));
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int y = this.height / 4;

        toggleAuraButton = new Button(centerX - 100, y, 200, 20, new TextComponent("Toggle Killaura"), b -> {
            KillauraConfig.enabled = !KillauraConfig.enabled;
            b.setMessage(new TextComponent("Killaura: " + (KillauraConfig.enabled ? "ON" : "OFF")));
        });
        this.addRenderableWidget(toggleAuraButton);
    }

    @Override
    public void render(PoseStack stack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(stack);
        drawCenteredString(stack, this.font, this.title.getString(), this.width / 2, 20, 0xFFFFFF);
        super.render(stack, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
