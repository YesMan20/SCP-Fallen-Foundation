package net.yesman.scpff.mixin;

import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.yesman.scpff.data.PlayerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerPacketListenerMixin {

    @Shadow public abstract ServerPlayer getPlayer();

    @Inject(at = @At("HEAD"), method = "handlePlayerAction", cancellable = true)
    public void handleInject(ServerboundPlayerActionPacket pPacket, CallbackInfo ci) {
        PlayerData data = PlayerData.getData(this.getPlayer());
        if (data.in2521Event()) {
            ci.cancel();
        }
    }
}
