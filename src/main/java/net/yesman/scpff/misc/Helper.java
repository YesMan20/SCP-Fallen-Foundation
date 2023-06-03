package net.yesman.scpff.misc;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.*;

public class Helper {

    public static BlockHitResult getEntityPOVHitResultBlock(Level pLevel, LivingEntity livingEntity, ClipContext.Fluid pFluidMode, double distance) {
        float f = livingEntity.getXRot();
        float f1 = livingEntity.getYRot();
        Vec3 vec3 = livingEntity.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f3 = Mth.sin(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
        float f4 = -Mth.cos(-f * ((float) Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float) Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = distance;
        Vec3 vec31 = vec3.add((double) f6 * d0, (double) f5 * d0, (double) f7 * d0);
        return pLevel.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, pFluidMode, livingEntity));
    }

    public static Vec3 calculateViewVector(float pXRot, float pYRot) {
        float f = pXRot * ((float) Math.PI / 180F);
        float f1 = -pYRot * ((float) Math.PI / 180F);
        float f2 = Mth.cos(f1);
        float f3 = Mth.sin(f1);
        float f4 = Mth.cos(f);
        float f5 = Mth.sin(f);
        return new Vec3((f3 * f4), (-f5), (f2 * f4));
    }

    @Nullable
    public static List<Entity> lookingAtInRange(LivingEntity livingEntity, double distance) {
        Vec3 startVec3 = new Vec3(livingEntity.getX(), livingEntity.getY(), livingEntity.getZ());
        Vec3 endVec3 = getEntityPOVHitResultBlock(livingEntity.level, livingEntity, ClipContext.Fluid.NONE, distance).getLocation();
        AABB aabb = new AABB(startVec3, endVec3);
        return new ArrayList<>(livingEntity.level.getEntities(livingEntity, aabb));
    }

}
