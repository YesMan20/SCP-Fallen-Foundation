package net.yesman.scpff.level.item.scps;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.SCP;

import java.util.Map;

public class SCP1025Item extends Item implements SCP {
    public SCP1025Item(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOOK_PAGE_TURN, SoundSource.PLAYERS, 1.0F, 0.9F);
        pPlayer.swing(pUsedHand);

        if (pLevel instanceof ServerLevel) {
            MobEffect pick = null;
            for (Map.Entry<ResourceKey<MobEffect>, MobEffect> effect : ForgeRegistries.MOB_EFFECTS.getEntries()) {
                MobEffect mobEffect = effect.getValue();
                if (RandomSource.create().nextFloat() > 0.9F && !effect.getValue().isBeneficial()) {
                    pick = mobEffect;
                    break;
                }
            }
            if (pick == null) {
                pick = MobEffects.CONFUSION;
            }
            pPlayer.addEffect(new MobEffectInstance(pick, RandomSource.create().nextInt(200, 1000)));
            pPlayer.displayClientMessage(Component.literal("You read a page about " + pick.getDisplayName().getString()), true);
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }
        return InteractionResultHolder.fail(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public Classification getClassification() {
        return Classification.SAFE;
    }

    @Override
    public String getNameId() {
        return "Encyclopedia of Diseases";
    }
}
