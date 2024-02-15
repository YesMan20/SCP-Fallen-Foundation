package net.yesman.scpff.client.overlays;

import net.minecraftforge.client.gui.overlay.IGuiOverlay;

import java.awt.*;

public class BlinkOverlay {

    public static int maxBlinkTime = 20;
    public static int currentBlinkTime = 0;

    public static final IGuiOverlay BLINK = (gui, guiGraphics, partialTicks, screenWidth, screenHeight) -> {
        if (currentBlinkTime > 0) {
            int alpha = (int) ((float) currentBlinkTime / (float) maxBlinkTime);
            guiGraphics.fill(0, 0, screenWidth, screenHeight, new Color(0, 0, 0, Math.max(255 * alpha, 255)).getRGB());
        }
    };

}
