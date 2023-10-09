package net.yesman.scpff.level.entity.ai.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.yesman.scpff.level.entity.custom.SCP106;

public class SCP106WalkThroughDoorsGoal extends Goal {

    public final SCP106 scp106;
    public BlockPos doorPos = BlockPos.ZERO;
    public boolean hasDoor;
    public boolean passed;
    public float doorOpenDirX;
    public float doorOpenDirZ;

    public SCP106WalkThroughDoorsGoal(SCP106 scp106) {
        this.scp106 = scp106;
        GroundPathNavigation navigation = (GroundPathNavigation) this.scp106.getNavigation();
        navigation.setCanPassDoors(true);
        navigation.setCanOpenDoors(true);
    }

    @Override
    public boolean canUse() {
        if (this.hasDoorInPath()) {
            this.scp106.noPhysics = true;
            return true;
        }
        return false;
    }

    public boolean hasDoorInPath() {
        if (!this.scp106.horizontalCollision) {
            return false;
        } else {
            GroundPathNavigation groundpathnavigation = (GroundPathNavigation) this.scp106.getNavigation();
            Path path = groundpathnavigation.getPath();
            if (path != null && !path.isDone() && groundpathnavigation.canOpenDoors()) {
                for (int i = 0; i < Math.min(path.getNextNodeIndex() + 2, path.getNodeCount()); ++i) {
                    Node node = path.getNode(i);
                    this.doorPos = new BlockPos(node.x, node.y + 1, node.z);
                    if (!(this.scp106.distanceToSqr(this.doorPos.getX(), this.scp106.getY(), this.doorPos.getZ()) > 2.0D)) {
                        this.hasDoor = this.scp106.level.getBlockState(this.doorPos).getBlock() instanceof DoorBlock;
                        if (this.hasDoor) {
                            return true;
                        }
                    }
                }

                this.doorPos = this.scp106.blockPosition().above();
                this.hasDoor = this.scp106.level.getBlockState(this.doorPos).getBlock() instanceof DoorBlock;
                return this.hasDoor;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean canContinueToUse() {
        return !this.passed;
    }

    @Override
    public void start() {
        this.passed = false;
        this.doorOpenDirX = (float) ((double) this.doorPos.getX() + 0.5D - this.scp106.getX());
        this.doorOpenDirZ = (float) ((double) this.doorPos.getZ() + 0.5D - this.scp106.getZ());
    }

    @Override
    public void stop() {
        this.scp106.noPhysics = false;
        this.scp106.setNoGravity(false);
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }


    public void tick() {
        float f = (float) ((double) this.doorPos.getX() + 0.5D - this.scp106.getX());
        float f1 = (float) ((double) this.doorPos.getZ() + 0.5D - this.scp106.getZ());
        float f2 = this.doorOpenDirX * f + this.doorOpenDirZ * f1;
        if (f2 < 0.0F) {
            this.passed = true;
        }

    }
}
