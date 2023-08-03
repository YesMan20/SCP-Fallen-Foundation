package net.yesman.scpff.level.item.client;

import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.item.scps.SCP035ArmorItem;
import net.yesman.scpff.level.item.scps.SCP268ArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class SCP035Model extends GeoModel<SCP035ArmorItem> {
    @Override
    public ResourceLocation getModelResource(SCP035ArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "geo/armor/scp035.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SCP035ArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "textures/armor/scp035_leak.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SCP035ArmorItem animatable) {
        return new ResourceLocation(SCPFf.MOD_ID, "animations/scp035.animation.json");
    }
}
