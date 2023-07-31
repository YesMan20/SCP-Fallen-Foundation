package net.yesman.scpff.level.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.yesman.scpff.level.block.ModBlocks;

public class MopItem extends Item {
    public MopItem(Properties pProperties) {
        super(pProperties);
    }

    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide && !pState.is(BlockTags.FIRE)) {
            pStack.hurtAndBreak(1, pEntityLiving, (p_43076_) -> {
                p_43076_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });
        }
        return pState.is(ModBlocks.SCP173CRAP.get()) || super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    public boolean isCorrectToolForDrops(BlockState pBlock) {
        return pBlock.is(ModBlocks.SCP173CRAP.get());
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        if (!pState.is(ModBlocks.SCP173CRAP.get())) {
            if (pState.is(ModBlocks.SCP173CRAP.get())) {
                return 5.0F;
            }
        }
        return 15.0F;
    }
}
