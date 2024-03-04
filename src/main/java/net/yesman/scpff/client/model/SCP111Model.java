package net.yesman.scpff.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.TamableAnimal;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.renderer.entity.SCP111Renderer;
import net.yesman.scpff.level.entity.scp.SCP111;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SCP111Model<T extends SCP111> extends DefaultedEntityGeoModel<T> {
    public SCP111Model() {
        super(new ResourceLocation(SCPFf.MOD_ID, "scp111"), true);
    }

    @Override
    public ResourceLocation getTextureResource(SCP111 animatable) {
        return new ResourceLocation(SCP111Renderer.LOCATION_BY_VARIANT.get(animatable.getVariant()) + ".png");
    }
}
