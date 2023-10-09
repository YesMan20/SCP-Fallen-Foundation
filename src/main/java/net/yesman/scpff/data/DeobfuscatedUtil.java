package net.yesman.scpff.data;

import net.minecraft.world.entity.Mob;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.lang.reflect.Method;

public class DeobfuscatedUtil {

    public static final Method MobAmbientSound = ObfuscationReflectionHelper.findMethod(Mob.class, "m_7515_");

}
