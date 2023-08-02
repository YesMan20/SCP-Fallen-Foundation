package net.yesman.scpff.level.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class WeightedArmorItem extends ArmorItem {
    public static float weight;

    public WeightedArmorItem(float weight, ArmorMaterial materials, ArmorItem.Type type, Item.Properties properties) {
        super(materials, type, properties);
        this.weight = weight;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        // Item must be added to the 'weighted' item tag to work
        TagKey<Item> weightItem = ItemTags.create(new ResourceLocation("scpff:weighted"));

        if (!player.isCreative()) {
            if (player.getItemBySlot(EquipmentSlot.HEAD).is(weightItem) && player.getItemBySlot(EquipmentSlot.CHEST).is(weightItem) && player.getItemBySlot(EquipmentSlot.LEGS).is(weightItem) && player.getItemBySlot(EquipmentSlot.FEET).is(weightItem)) {
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
}
