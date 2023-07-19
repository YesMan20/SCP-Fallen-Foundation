package net.yesman.scpff.level.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ModArmorMaterials implements ArmorMaterial {
    public static final ArmorMaterial SCP_268 = new ModArmorMaterials(55, 1, 15, SoundEvents.ARMOR_EQUIP_LEATHER, "scp_268", 0.0F, 0.0F);


    private final int durability, defense, enchantment;
    private final SoundEvent sound;
    private final String name;
    private final float toughness, knockbackR;

    public ModArmorMaterials(int durability, int defense, int enchantment, SoundEvent sound, String name, float toughness, float knockbackR) {
        this.durability = durability;
        this.defense = defense;
        this.enchantment = enchantment;
        this.sound = sound;
        this.name = name;
        this.toughness = toughness;
        this.knockbackR = knockbackR;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return durability;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return defense;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantment;
    }

    @Override
    public SoundEvent getEquipSound() {
        return sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackR;
    }
}
