package net.yesman.scpff.level.block.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
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

    public static final RegistryObject<BlockEntityType<FileCabinetBlockEntity>> FILECABINET = register("filecabinet", ModBlocks.FILECABINET, FileCabinetBlockEntity::new);

    public static final RegistryObject<BlockEntityType<LockerBlockEntity>> LOCKER = register("locker", ModBlocks.LOCKER, LockerBlockEntity::new);
    public static final RegistryObject<BlockEntityType<ContainmentBlockEntity>> CONTAINMENT_BLOCK = register("containment_block", ModBlocks.CONTAINMENT_CASE, ContainmentBlockEntity::new);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, RegistryObject<Block> registryObject, BlockEntityType.BlockEntitySupplier<? extends BlockEntity> factory) {
        RegistryObject<? extends BlockEntityType<? extends BlockEntity>> ret = BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(factory, registryObject.get()).build(null));
        return (RegistryObject<BlockEntityType<T>>) ret;
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
