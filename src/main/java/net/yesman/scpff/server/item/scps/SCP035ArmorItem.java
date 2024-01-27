package net.yesman.scpff.server.item.scps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.server.item.client.SCP035Model;
import net.yesman.scpff.misc.Classification;
import net.yesman.scpff.misc.SCP;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class SCP035ArmorItem extends ArmorItem implements SCP {
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
            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                return new SCP035Model(Minecraft.getInstance().getEntityModels().bakeLayer(SCP035Model.LAYER_LOCATION));
            }
        });
    }

    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return SCPFf.MOD_ID + ":textures/armor/scp035.png";
    }

    @Override
    public Classification getClassification() {
        return Classification.KETER;
    }
}
