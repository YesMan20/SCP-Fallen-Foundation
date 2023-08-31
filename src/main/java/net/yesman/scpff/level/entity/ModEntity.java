package net.yesman.scpff.level.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.*;
import net.yesman.scpff.level.entity.goals.SCP049LookForPlayerGoal;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> MOD_ENTITES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SCPFf.MOD_ID);

    public static final RegistryObject<EntityType<SCP650>> SCP_650 = MOD_ENTITES.register("scp_650", () -> EntityType.Builder.of(SCP650::new, MobCategory.CREATURE).build(SCPFf.MOD_ID + ":scp_650"));
    public static final RegistryObject<EntityType<SCP049>> SCP_049 = MOD_ENTITES.register("scp_049", () -> EntityType.Builder.of(SCP049::new, MobCategory.MONSTER).build(SCPFf.MOD_ID + ":scp_049"));
    public static final RegistryObject<EntityType<SCP939>> SCP_939 = MOD_ENTITES.register("scp_939", () -> EntityType.Builder.of(SCP939::new, MobCategory.MONSTER).sized(1f, 1f).build(SCPFf.MOD_ID + ":scp_939"));
    public static final RegistryObject<EntityType<SCP1507>> SCP_1507 = MOD_ENTITES.register("scp_1507", () -> EntityType.Builder.of(SCP1507::new, MobCategory.CREATURE).sized(1f, 1.2f).build(SCPFf.MOD_ID + ":scp_1507"));
    public static final RegistryObject<EntityType<SCP173>> SCP_173 = MOD_ENTITES.register("scp_173", () -> EntityType.Builder.of(SCP173::new, MobCategory.MONSTER).build(SCPFf.MOD_ID + ":scp_173"));

}
