package net.yesman.scpff.level.block.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.yesman.scpff.level.block.decor.ContainmentCase;
import net.yesman.scpff.level.block.entity.ContainmentBlockEntity;

public class ContainmentCaseRenderer implements BlockEntityRenderer<ContainmentBlockEntity> {

    public ContainmentCaseRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(ContainmentBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        pPoseStack.pushPose();
        pPoseStack.translate(0.5F,0.5F,0.5F);
        pPoseStack.scale(0.5F,0.5F,0.5F);
        Direction FACING = pBlockEntity.getBlockState().getValue(ContainmentCase.FACING);
        pPoseStack.rotateAround(Axis.YP.rotationDegrees(FACING == Direction.NORTH ? 0 : FACING == Direction.SOUTH ? 0 : 90), 0,0,0);
        itemRenderer.renderStatic(pBlockEntity.currentItem, ItemDisplayContext.FIXED, 255, 0, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 0);
        pPoseStack.popPose();
    }
}
