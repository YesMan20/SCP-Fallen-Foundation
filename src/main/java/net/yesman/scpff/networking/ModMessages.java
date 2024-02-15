package net.yesman.scpff.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.networking.packet.Packet;
import net.yesman.scpff.networking.packet.S2C.BlinkS2CPacket;
import net.yesman.scpff.networking.packet.S2C.EnableMovementPacketS2CPacket;
import net.yesman.scpff.networking.packet.S2C.Update2521InfoS2CPacket;

public class ModMessages {

    private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(SCPFf.MOD_ID, "messages"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    private static int packetId = 0;

    private static int id() {
        return packetId++;
    }

    public static void register() {
        registerPacket(EnableMovementPacketS2CPacket.class, NetworkDirection.PLAY_TO_CLIENT);
        registerPacket(Update2521InfoS2CPacket.class, NetworkDirection.PLAY_TO_CLIENT);
        registerPacket(BlinkS2CPacket.class, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    private static <P extends Packet> void registerPacket(Class<P> msgClass, NetworkDirection direction) {
        INSTANCE.messageBuilder(msgClass, id(), direction)
                .decoder(byteBuf -> {
                    try {
                        return msgClass.getConstructor(FriendlyByteBuf.class).newInstance(byteBuf);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .encoder(Packet::toBytes)
                .consumerMainThread((msg, supplier) -> msg.handle(supplier.get()))
                .add();
    }

}
