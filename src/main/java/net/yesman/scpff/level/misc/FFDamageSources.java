package net.yesman.scpff.level.misc;

import javax.annotation.Nullable;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class FFDamageSources {
    private final Registry<DamageType> damageTypes;

    private final DamageSource scp173;
    private final DamageSource barbedwire;
    private final DamageSource sledgehammer;


    public FFDamageSources(RegistryAccess pRegistry) {
        this.damageTypes = pRegistry.registryOrThrow(Registries.DAMAGE_TYPE);
        this.scp173 = this.source(FFDamageTypes.SCP173);
        this.barbedwire = this.source(FFDamageTypes.BARBEDWIRE);
        this.sledgehammer = this.source(FFDamageTypes.SLEDGEHAMMER);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey));
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, @Nullable Entity pEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pEntity);
    }

    private DamageSource source(ResourceKey<DamageType> pDamageTypeKey, Entity pCausingEntity, Entity pDirectEntity) {
        return new DamageSource(this.damageTypes.getHolderOrThrow(pDamageTypeKey), pCausingEntity, pDirectEntity);
    }

    public DamageSource scp173() {
        return this.scp173;
    }

    public DamageSource barbedwire() {
        return this.barbedwire;
    }

    public DamageSource sledgehammer() {
        return this.sledgehammer;
    }
}
