package net.yesman.scpff.level.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MedkitItem extends Item {
    public MedkitItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // I don't know what values to put, so you can change these

        player.getItemInHand(hand).shrink(1);
        player.getCooldowns().addCooldown(this, 35);
        player.heal(10.0F);
        player.swing(hand);
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.CHAIN_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
        return super.use(level, player, hand);
    }
}
