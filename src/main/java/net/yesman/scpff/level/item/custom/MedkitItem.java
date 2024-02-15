package net.yesman.scpff.level.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
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
        int healthHealed = player.getRandom().nextInt(6, 9);

        player.getItemInHand(hand).shrink(1);
        player.getCooldowns().addCooldown(this, 35);
        player.heal(healthHealed);
        player.swing(hand);
        player.displayClientMessage(Component.literal("Restored " + healthHealed + " Health Points").withStyle(ChatFormatting.GREEN), true);
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1.0F, 1.0F);
        return super.use(level, player, hand);
    }
}
