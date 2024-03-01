package net.yesman.scpff.client.renderer.entity;

import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.client.model.SCP106Model;
import net.yesman.scpff.client.model.SCP111Model;
import net.yesman.scpff.level.entity.scp.SCP106;
import net.yesman.scpff.level.entity.scp.SCP111;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class SCP111Renderer extends GeoEntityRenderer<SCP111> {
    public static final Map<SCP111.Variants, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(SCP111.Variants.class), (p_114874_) -> {
                p_114874_.put(SCP111.Variants.SLIMYBELLY,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111slimybelly"));
                p_114874_.put(SCP111.Variants.GLOWDRAKE,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111glowdrake"));
                p_114874_.put(SCP111.Variants.GOOWYVERN,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111goowyvern"));
                p_114874_.put(SCP111.Variants.GUNKYVERN,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111gunkyvern"));
                p_114874_.put(SCP111.Variants.OOZEDRAKE,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111oozedrake"));
                p_114874_.put(SCP111.Variants.BLOBWORM,
                        new ResourceLocation(SCPFf.MOD_ID, "textures/entity/scp111/scp111blobworm"));
            });

    public SCP111Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP111Model());
        this.shadowRadius = 0.5F;
    }

}
