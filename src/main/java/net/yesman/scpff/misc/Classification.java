package net.yesman.scpff.misc;

import net.minecraft.ChatFormatting;

public enum Classification {
    SAFE("Safe", ChatFormatting.GREEN),
    EUCLID("Euclid", ChatFormatting.GOLD),
    KETER("Keter", ChatFormatting.RED),
    OTHER("Other", ChatFormatting.DARK_GRAY);

    private final String name;
    private final ChatFormatting textColor;

    Classification(String name, ChatFormatting textColor) {
        this.name = name;
        this.textColor = textColor;
    }

    public String getName() {
        return this.name;
    }

    public ChatFormatting getColor() {
        return this.textColor;
    }
}
