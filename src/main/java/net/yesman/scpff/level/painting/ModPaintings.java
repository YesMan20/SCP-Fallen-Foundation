package net.yesman.scpff.level.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, SCPFf.MOD_ID);

    public static final RegistryObject<PaintingVariant> SODA = PAINTING_VARIANTS.register("soda",
            () -> new PaintingVariant(32, 32));

    public static final RegistryObject<PaintingVariant> MASON = PAINTING_VARIANTS.register("mason",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MYSTERIOUSROBOT = PAINTING_VARIANTS.register("mysteriousrobot",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> PROTECTPOSTER = PAINTING_VARIANTS.register("protectposter",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MEMETICPOSTER = PAINTING_VARIANTS.register("memeticposter",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> DCLASSPOSTER = PAINTING_VARIANTS.register("dclassposter",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> SCP106POSTER = PAINTING_VARIANTS.register("106poster",
            () -> new PaintingVariant(16, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
