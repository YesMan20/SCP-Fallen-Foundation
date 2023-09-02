package net.yesman.scpff.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public abstract class Packet {

    public Packet() {}
    public Packet(FriendlyByteBuf buf) {}

    public abstract void toBytes(FriendlyByteBuf buf);

    public abstract void handle(NetworkEvent.Context context);

}
