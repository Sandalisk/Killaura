package com.example.killaura.common;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;

import java.io.*;

public class NeuralInterface {
    private static final String MODEL_PATH = "killaura_model.dat";
    private static float modelRotation = 0.0f;

    public static void trainModel(Player target) {
        // Заглушка: обучение на основе позиции цели
        float deltaYaw = target.getYRot() - Minecraft.getInstance().player.getYRot();
        modelRotation += deltaYaw * 0.01f;
        saveModel();
    }

    public static float getRotation() {
        return modelRotation;
    }

    public static void saveModel() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MODEL_PATH))) {
            oos.writeFloat(modelRotation);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadModel() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MODEL_PATH))) {
            modelRotation = ois.readFloat();
        } catch (IOException e) {
            modelRotation = 0.0f;
        }
    }

    public static void resetModel() {
        modelRotation = 0.0f;
        saveModel();
    }
}
