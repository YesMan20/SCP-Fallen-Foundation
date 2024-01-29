package net.yesman.scpff;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public final class Components {
    public static MutableComponent literal(String str) {
        return Component.literal(str);
    }
}
