package net.yesman.scpff.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.yesman.scpff.SCPFf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin extends Player {
    public AbstractClientPlayerMixin(Level level, BlockPos pos, float v, GameProfile profile) {
        super(level, pos, v, profile);
    }

    @Inject(method = "getCloakTextureLocation", at = @At(value = "HEAD"), cancellable = true)
    public void getCloakTextureLocation(CallbackInfoReturnable<ResourceLocation> cir) {
        String username = this.getDisplayName().getString();
        if (SCPFf.DEV_CAPE.contains(username)) cir.setReturnValue(new ResourceLocation(SCPFf.MOD_ID, "textures/misc/dev_cape.png"));
        if (SCPFf.CAPE_CAPE.contains(username)) cir.setReturnValue(new ResourceLocation(SCPFf.MOD_ID, "textures/misc/cape_cape.png"));
        if (SCPFf.LOLCAT_CAPE.contains(username)) cir.setReturnValue(new ResourceLocation(SCPFf.MOD_ID, "textures/misc/lolcat_cape.png"));
    }
}
