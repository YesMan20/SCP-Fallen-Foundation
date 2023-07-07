package net.yesman.scpff.level.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.custom.SCP049;
import net.yesman.scpff.level.entity.custom.SCP650;
import net.yesman.scpff.level.entity.goals.SCP049LookForPlayerGoal;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> MOD_ENTITES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SCPFf.MOD_ID);

    public static final RegistryObject<EntityType<SCP650>> SCP_650 = MOD_ENTITES.register("scp_650", () -> EntityType.Builder.of(SCP650::new, MobCategory.CREATURE).build(SCPFf.MOD_ID + ":scp_650"));
    public static final RegistryObject<EntityType<SCP049>> SCP_049 = MOD_ENTITES.register("scp_049", () -> EntityType.Builder.of(SCP049::new, MobCategory.CREATURE).build(SCPFf.MOD_ID + ":scp_650"));
}
