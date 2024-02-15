package net.yesman.scpff.level.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FFServerConfigsRegistry {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue SCP173CRAP;
    public static final ForgeConfigSpec.BooleanValue SCP106CORROSION;

    static {
        BUILDER.push("Configs for SCP Fallen Foundation");

        SCP173CRAP = BUILDER.comment("Enable/Disable SCP-173 Feces")
                .define("SCP173 Feces On/Off", true);

        SCP106CORROSION = BUILDER.comment("Enable/Disable SCP-106 Corrosion")
                .define("SCP106 Corrosion On/Off", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
