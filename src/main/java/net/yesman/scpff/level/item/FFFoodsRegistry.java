package net.yesman.scpff.level.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FFFoodsRegistry {
    public static final FoodProperties CANDY = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.3f).alwaysEat().fast().build();

    public static final FoodProperties SCP109 = new FoodProperties.Builder()
            .nutrition(8).saturationMod(0.7f).alwaysEat().fast().build();

    public static final FoodProperties SCP207 = new FoodProperties.Builder()
            .nutrition(6).saturationMod(0.9f).alwaysEat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 1), 1f).build();

    public static final FoodProperties SCP500 = new FoodProperties.Builder()
            .nutrition(7).saturationMod(0.5f).alwaysEat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 3), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 3), 1f).build();
}
