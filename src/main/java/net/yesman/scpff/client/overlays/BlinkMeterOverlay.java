package net.yesman.scpff.client.overlays;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.minecraft.client.gui.Gui;
import net.yesman.scpff.SCPFf;

public class BlinkMeterOverlay {
    private static final ResourceLocation EMPTY_BARS = new ResourceLocation(SCPFf.MOD_ID,
            "textures/overlay/blink/empty_bars.png");
    private static final ResourceLocation FULL_BARS = new ResourceLocation(SCPFf.MOD_ID,
            "textures/overlay/blink/bars.png");
    private static final ResourceLocation OUTLINE = new ResourceLocation(SCPFf.MOD_ID,
            "textures/overlay/blink/outline.png");


    /*public static final IGuiOverlay BLINK_METER = ((gui, guiGraphics, screenWidth, screenHeight) -> {

    });*/
}
