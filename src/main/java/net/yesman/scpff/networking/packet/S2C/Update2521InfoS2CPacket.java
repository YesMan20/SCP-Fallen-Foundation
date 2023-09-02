package net.yesman.scpff.networking.packet.S2C;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.yesman.scpff.data.client.GeneralClientData;
import net.yesman.scpff.networking.packet.Packet;

public class Update2521InfoS2CPacket extends Packet {

    private final boolean in2521Event;

    public Update2521InfoS2CPacket(boolean in) {
        this.in2521Event = in;
    }

    public Update2521InfoS2CPacket(FriendlyByteBuf buf) {
        this.in2521Event = buf.readBoolean();
    }

    @Override
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(in2521Event);
    }

    @Override
    public void handle(NetworkEvent.Context context) {
        context.enqueueWork(() -> GeneralClientData.in2521Event = this.in2521Event);
    }
}
