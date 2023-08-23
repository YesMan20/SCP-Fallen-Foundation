package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.yesman.scpff.SCPFf;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, SCPFf.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

    }
}
