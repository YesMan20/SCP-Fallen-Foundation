package net.yesman.scpff.misc;

import com.google.common.math.DoubleMath;
import it.unimi.dsi.fastutil.doubles.DoubleList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.SliceShape;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

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

    public static Entity lookingAtInRange(LivingEntity livingEntity, double distance) {
        if (livingEntity != null) {
            Vec3 vec3 = livingEntity.getEyePosition();
            for (int x = 0; x < distance; x++) {
                Vec3 vec31 = calculateViewVector(livingEntity.getXRot(), livingEntity.getYRot()).scale(x);
                Vec3 vec32 = vec3.add(vec31);
                if (livingEntity.level.getBlockState(BlockPos.containing(vec32.x, vec32.y, vec32.z)).isAir()) {
                    AABB aabb = livingEntity.getBoundingBox().expandTowards(vec31).inflate(1.0D);
                    double i = x * x;
                    Predicate<Entity> predicate = (entity) -> !entity.isSpectator() && entity.isPickable();
                    EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(livingEntity, vec3, vec32, aabb, predicate, i);
                    if (entityhitresult != null) {
                        if (vec3.distanceToSqr(entityhitresult.getLocation()) < i) {
                            return entityhitresult.getEntity();
                        }
                    }
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public static DamageSource damageSource(ResourceKey<DamageType> damageType, Level level) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(damageType));
    }
}
