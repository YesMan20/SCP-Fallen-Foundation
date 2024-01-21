package net.yesman.scpff.level.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.yesman.scpff.level.entity.ModEntity;

public class ChairEntity extends Entity {
    public ChairEntity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ChairEntity(Level level, BlockPos pos, Direction direction) {
        super(ModEntity.CHAIR.get(), level);
        this.setPos(pos.getX() + 0.5F, pos.getY() + 0.6F, pos.getZ() + 0.5F);
        this.setRot(direction.getOpposite().toYRot(), 0.0F);
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getPassengers().isEmpty() || this.level.isEmptyBlock(this.blockPosition())) {
            this.discard();
        }
    }

    @Override
    public double getPassengersRidingOffset() {
        return 0.0D;
    }

    @Override
    protected boolean canRide(Entity pVehicle) {
        return true;
    }
}
