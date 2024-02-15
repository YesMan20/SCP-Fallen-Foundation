package net.yesman.scpff.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yesman.scpff.level.entity.scp.SCP2521;
import net.yesman.scpff.misc.RunnableCooldownHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlockEntity.class)
public abstract class SignBlockEntityMixin extends BlockEntity {

    @Unique
    @Final
    private Component[] messages;

    public SignBlockEntityMixin(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Inject(at = @At("TAIL"), method = "getUpdateTag")
    public void setInject(CallbackInfoReturnable<CompoundTag> cir) {
        for (Component message : this.messages) {
            if (SCP2521.has2521InString(message.getString())) {
                if (this.level == null) return;
                new SCP2521.SCP2521Event(this.worldPosition, this.level, null, () ->
                        RunnableCooldownHandler.addDelayedRunnable(() -> {
                            if (this.level.getBlockEntity(this.getBlockPos()) == this)
                                this.level.destroyBlock(this.getBlockPos(), false);
                        }, 100));
            }
        }
    }

}
