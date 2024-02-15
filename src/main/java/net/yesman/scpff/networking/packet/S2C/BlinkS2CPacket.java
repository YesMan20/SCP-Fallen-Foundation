package net.yesman.scpff.networking.packet.S2C;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.yesman.scpff.client.overlays.BlinkOverlay;
import net.yesman.scpff.networking.packet.Packet;

public class BlinkS2CPacket extends Packet {

    private final int ticks;

    public BlinkS2CPacket(int ticks) {
        this.ticks = ticks;
    }

    public BlinkS2CPacket(FriendlyByteBuf buf) {
        this.ticks = buf.readInt();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(this.ticks);
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> {
            BlinkOverlay.currentBlinkTime = this.ticks;
            BlinkOverlay.maxBlinkTime = this.ticks;
        });
    }
}
