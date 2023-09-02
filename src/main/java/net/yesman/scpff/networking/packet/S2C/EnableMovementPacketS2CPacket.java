package net.yesman.scpff.networking.packet.S2C;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.yesman.scpff.data.client.GeneralClientData;
import net.yesman.scpff.networking.packet.Packet;

public class EnableMovementPacketS2CPacket extends Packet {

    private final boolean enabled;

    public EnableMovementPacketS2CPacket(boolean enabled) {
        this.enabled = enabled;
    }

    public EnableMovementPacketS2CPacket(FriendlyByteBuf buf) {
        this.enabled = buf.readBoolean();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(enabled);
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> GeneralClientData.canMove = this.enabled);
    }
}
