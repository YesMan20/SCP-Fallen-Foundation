package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.block.FFBlocksRegistry;

public class FFLanguageProvider extends LanguageProvider {
    public FFLanguageProvider(PackOutput output) {
        super(output, SCPFf.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(FFBlocksRegistry.MIRROR.get().getDescriptionId(), "Mirror");
    }
}
