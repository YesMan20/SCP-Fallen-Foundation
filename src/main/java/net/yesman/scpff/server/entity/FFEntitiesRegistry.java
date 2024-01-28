package net.yesman.scpff.server.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.entity.scp.*;

public class FFEntitiesRegistry {
    public static final DeferredRegister<EntityType<?>> MOD_ENTITES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SCPFf.MOD_ID);

    public static final RegistryObject<EntityType<SCP650>> SCP_650 = register("scp_650", EntityType.Builder.of(SCP650::new, MobCategory.CREATURE));
    public static final RegistryObject<EntityType<SCP049>> SCP_049 = register("scp_049", EntityType.Builder.of(SCP049::new, MobCategory.MONSTER));
    public static final RegistryObject<EntityType<SCP106>> SCP_106 = register("scp_106", EntityType.Builder.of(SCP106::new, MobCategory.MONSTER));
    public static final RegistryObject<EntityType<SCP939>> SCP_939 = register("scp_939", EntityType.Builder.of(SCP939::new, MobCategory.MONSTER).sized(1.0f, 1f));
    public static final RegistryObject<EntityType<SCP1507>> SCP_1507 = register("scp_1507", EntityType.Builder.of(SCP1507::new, MobCategory.CREATURE).sized(1f, 1.2f));
    public static final RegistryObject<EntityType<SCP173>> SCP_173 = register("scp_173", EntityType.Builder.of(SCP173::new, MobCategory.MONSTER));
    public static final RegistryObject<EntityType<SCP058>> SCP_058 = register("scp_058", EntityType.Builder.of(SCP058::new, MobCategory.MONSTER).sized(0.7f, 0.7f));
    public static final RegistryObject<EntityType<SCP2521>> SCP_2521 = register("scp_2521", EntityType.Builder.of(SCP2521::new, MobCategory.MONSTER).noSummon());
    public static final RegistryObject<EntityType<SCP131>> SCP_131 = register("scp_131", EntityType.Builder.of(SCP131::new, MobCategory.CREATURE).sized(0.7f, 0.7f));

    public static final RegistryObject<EntityType<ChairEntity>> CHAIR = register("chair", EntityType.Builder.<ChairEntity>of(ChairEntity::new, MobCategory.MISC).sized(0.0F, 0.0F));

    private static<E extends Entity> RegistryObject<EntityType<E>> register(String id, EntityType.Builder<E> builder) {
        return MOD_ENTITES.register(id, () -> builder.build(id));
    }
}
