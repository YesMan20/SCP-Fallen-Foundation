package net.yesman.scpff.level.item.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.yesman.scpff.level.tag.FFItemTags;

public class WeightedArmorItem extends ArmorItem {
    private final float weight;

    public WeightedArmorItem(float weight, ArmorMaterial materials, ArmorItem.Type type, Item.Properties properties) {
        super(materials, type, properties);
        this.weight = weight;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!player.isCreative()) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).is(FFItemTags.HAS_WEIGHT) && player.getItemBySlot(EquipmentSlot.CHEST).is(FFItemTags.HAS_WEIGHT) && player.getItemBySlot(EquipmentSlot.LEGS).is(FFItemTags.HAS_WEIGHT) && player.getItemBySlot(EquipmentSlot.FEET).is(FFItemTags.HAS_WEIGHT)) {
                // 0.1 is the default value for the players movement speed
                player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1F - weight);
            } else {
                player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1F);
            }
        } else {
            player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.1F);
        }
        super.onArmorTick(stack, level, player);
    }

    public float getWeight() {
        return this.weight;
    }
}
