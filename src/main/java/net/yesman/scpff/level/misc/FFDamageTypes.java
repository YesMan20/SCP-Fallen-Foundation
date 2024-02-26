package net.yesman.scpff.level.misc;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.*;
import net.yesman.scpff.SCPFf;

public class FFDamageTypes {
    public static final ResourceKey<DamageType> SCP173 = register("scp173");
    public static final ResourceKey<DamageType> BARBEDWIRE = register("barbedwire");
    public static final ResourceKey<DamageType> SLEDGEHAMMER = register("sledgehammer");

    private static ResourceKey<DamageType> register(String name)
    {
        return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(SCPFf.MOD_ID, name));
    }
}
