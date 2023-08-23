package net.yesman.scpff.level.item.scps;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.yesman.scpff.level.item.client.SCP035Renderer;
import net.yesman.scpff.level.item.client.SCP268Renderer;
import net.yesman.scpff.misc.Euclid;
import net.yesman.scpff.misc.Keter;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import java.util.function.Consumer;

@Keter
public class SCP035ArmorItem extends SCPArmorItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public SCP035ArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (player.isCreative()) return;
        CompoundTag tag = stack.getOrCreateTag();
        if (tag.get("healed") == null) {
            tag.putBoolean("healed", false);
        }
        if (!stack.getAllEnchantments().containsKey(Enchantments.BINDING_CURSE)) {
            stack.enchant(Enchantments.BINDING_CURSE, 1);
        }
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1));
        player.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, -1, 13));
        if (player.getHealth() < player.getMaxHealth() && !tag.getBoolean("healed")) {
            player.heal(1F);
        } else {
            tag.putBoolean("healed", true);
            player.addEffect(new MobEffectInstance(MobEffects.WITHER, -1, 2));
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 2));
        }
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return false;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private SCP035Renderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new SCP035Renderer();
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
