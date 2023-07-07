package net.yesman.scpff.level.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.ModBlocks;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SCPFf.MOD_ID);

    public static final RegistryObject<BlockEntityType<FileCabinetBlockEntity>> FILECABINET =
            BLOCK_ENTITIES.register("filecabinet", () ->
                    BlockEntityType.Builder.of(FileCabinetBlockEntity::new,
                            ModBlocks.FILECABINET.get()).build(null));

    public static final RegistryObject<BlockEntityType<FileCabinetBlockEntity>> LOCKER =
            BLOCK_ENTITIES.register("locker", () ->
                    BlockEntityType.Builder.of(FileCabinetBlockEntity::new,
                            ModBlocks.LOCKER.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
