package net.yesman.scpff.server.item.scps;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class SCP1023ARC extends SwordItem {
    public SCP1023ARC(Tier tier, int damage, float speed, Properties property) {
        super(tier, damage, speed, property);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        player.swing(hand);
        target.kill();
        return super.interactLivingEntity(stack, player, target, hand);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
