package net.yesman.scpff.level.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.item.custom.IgnoreOnLoad;
import net.yesman.scpff.level.item.scps.MedkitItem;
import net.yesman.scpff.level.item.scps.SCP109Item;
import net.yesman.scpff.level.item.scps.SCP207Item;
import net.yesman.scpff.level.item.scps.SCP500Item;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SCPFf.MOD_ID);

    public static final RegistryObject<Item> SCP207 = ITEMS.register("scp207", () -> new SCP207Item(new Item.Properties()
            .food(Foods.SCP207)
            .stacksTo(3)));
    public static final RegistryObject<Item> SCP500 = ITEMS.register("scp500", () -> new SCP500Item(new Item.Properties()
            .food(Foods.SCP500)
            .stacksTo(7)));

    /** Icons for tabs **/

    public static final RegistryObject<IgnoreOnLoad> ITEMICON = ITEMS.register("itemicon", () -> new IgnoreOnLoad(new Item.Properties()));

    public static final RegistryObject<IgnoreOnLoad> SCPICON = ITEMS.register("scpicon", () -> new IgnoreOnLoad(new Item.Properties()));

    public static final RegistryObject<IgnoreOnLoad> BLOCKICON = ITEMS.register("blockicon", () -> new IgnoreOnLoad(new Item.Properties()));

    public static final RegistryObject<IgnoreOnLoad> ARMORYICON = ITEMS.register("armoryicon", () -> new IgnoreOnLoad(new Item.Properties()));

    /** Keycards **/

    public static final RegistryObject<Item> KEYCARD1 = ITEMS.register("keycard1", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KEYCARD2 = ITEMS.register("keycard2", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KEYCARD3 = ITEMS.register("keycard3", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KEYCARD4 = ITEMS.register("keycard4", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> KEYCARD5 = ITEMS.register("keycard5", () -> new Item(new Item.Properties()));

    /** Generic Items **/

    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit", () -> new MedkitItem(new Item.Properties()
            .stacksTo(15)
            .food(Foods.MEDKIT)));

    /** SCP Items **/

    public static final RegistryObject<ForgeSpawnEggItem> SCP_650_SPAWN_EGG = ITEMS.register("scp_650_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.SCP_650, 0, 1710618,
            new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> SCP_049_SPAWN_EGG = ITEMS.register("scp_049_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.SCP_049, 3289650, 1820927,
            new Item.Properties()));

    public static final RegistryObject<Item> SCP109 = ITEMS.register("scp109", () -> new SCP109Item(new Item.Properties()
            .stacksTo(1)
            .food(Foods.SCP109)));

    public static class Foods {
        public static final FoodProperties SCP109 = new FoodProperties.Builder()
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties MEDKIT = new FoodProperties.Builder()
                .alwaysEat()
                .meat()
                .build();

        public static final FoodProperties SCP207 = new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(0.2f)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 1f)
                .effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 1), 1f)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties SCP500 = new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(0.2f)
                .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 3), 1f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 3), 1f)
                .alwaysEat()
                .fast()
                .build();
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
