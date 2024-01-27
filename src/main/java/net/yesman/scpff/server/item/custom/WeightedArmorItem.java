package net.yesman.scpff.server.item.custom;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.yesman.scpff.server.item.FFItemTagsRegistry;

public class WeightedArmorItem extends ArmorItem {
    public float weight;

    public WeightedArmorItem(float weight, ArmorMaterial materials, ArmorItem.Type type, Item.Properties properties) {
        super(materials, type, properties);
        this.weight = weight;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (!player.isCreative()) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).is(FFItemTagsRegistry.HAS_WEIGHT) && player.getItemBySlot(EquipmentSlot.CHEST).is(FFItemTagsRegistry.HAS_WEIGHT) && player.getItemBySlot(EquipmentSlot.LEGS).is(FFItemTagsRegistry.HAS_WEIGHT) && player.getItemBySlot(EquipmentSlot.FEET).is(FFItemTagsRegistry.HAS_WEIGHT)) {
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
