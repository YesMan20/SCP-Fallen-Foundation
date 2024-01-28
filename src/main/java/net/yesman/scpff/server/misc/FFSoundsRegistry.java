package net.yesman.scpff.server.misc;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;

public class FFSoundsRegistry {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SCPFf.MOD_ID);

    public static final RegistryObject<SoundEvent> SCP058BEATING = registerSoundEvent("scp058beating");
    public static final RegistryObject<SoundEvent> SCP049BREATHING = registerSoundEvent("scp049breathing");
    public static final RegistryObject<SoundEvent> SCP106BREATHING = registerSoundEvent("scp106breathing");
    public static final RegistryObject<SoundEvent> SCP131AMBIENT = registerSoundEvent("scp131ambient");
    public static final RegistryObject<SoundEvent> SCP131HURT = registerSoundEvent("scp131hurt");

    public static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(SCPFf.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
