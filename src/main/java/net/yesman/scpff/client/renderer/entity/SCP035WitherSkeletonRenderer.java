package net.yesman.scpff.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.player.Player;
import net.yesman.scpff.client.model.SCP035WitherSkeletonModel;
import net.yesman.scpff.level.entity.scp.SCP035WitherSkeleton;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class SCP035WitherSkeletonRenderer extends GeoReplacedEntityRenderer<Player, SCP035WitherSkeleton> {
    public SCP035WitherSkeletonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SCP035WitherSkeletonModel(), new SCP035WitherSkeleton());
    }

}
