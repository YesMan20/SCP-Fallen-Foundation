package net.yesman.scpff.level.misc;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;

public class FFPaintingsRegistry {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, SCPFf.MOD_ID);

    public static final RegistryObject<PaintingVariant> SAFETYFIRST = PAINTING_VARIANTS.register("safetyfirstposter",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> SURVEILLANCEPOSTER = PAINTING_VARIANTS.register("surveillanceposter",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> MEMETICPOSTER = PAINTING_VARIANTS.register("memeticposter",
            () -> new PaintingVariant(16, 16));

    public static final RegistryObject<PaintingVariant> SCP173POSTER = PAINTING_VARIANTS.register("scp173poster",
            () -> new PaintingVariant(16, 32));


    public static final RegistryObject<PaintingVariant> SAFELABEL = PAINTING_VARIANTS.register("safelabel",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> EUCLIDLABEL = PAINTING_VARIANTS.register("euclidlabel",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> KETERLABEL = PAINTING_VARIANTS.register("keterlabel",
            () -> new PaintingVariant(16, 16));
    public static final RegistryObject<PaintingVariant> THAUMIELLABEL = PAINTING_VARIANTS.register("thaumiellabel",
            () -> new PaintingVariant(16, 16));

    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}
