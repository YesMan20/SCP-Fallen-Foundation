package net.yesman.scpff.level.entity.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.player.Player;
import net.yesman.scpff.level.entity.client.models.SCP035WitherSkeletonModel;
import net.yesman.scpff.level.entity.custom.SCP035WitherSkeleton;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class SCP035WitherSkeletonRenderer extends GeoReplacedEntityRenderer<Player, SCP035WitherSkeleton> {
    public SCP035WitherSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP035WitherSkeletonModel(), new SCP035WitherSkeleton());
    }

}
