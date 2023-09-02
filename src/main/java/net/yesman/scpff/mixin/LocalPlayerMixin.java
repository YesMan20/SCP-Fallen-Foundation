package net.yesman.scpff.mixin;

import net.minecraft.client.player.LocalPlayer;
import net.yesman.scpff.data.client.GeneralClientData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Inject(at = @At("HEAD"), method = "drop", cancellable = true)
    public void dropInject(boolean pFullStack, CallbackInfoReturnable<Boolean> cir) {
        if (!GeneralClientData.in2521Event) {
            cir.setReturnValue(false);
        }
    }

}
