package net.yesman.scpff.level.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.ModEntity;
import net.yesman.scpff.level.item.custom.IgnoreOnLoad;
import net.yesman.scpff.level.item.custom.InstaKillItem;
import net.yesman.scpff.level.item.scps.*;


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

    public static final RegistryObject<Item> KEYCARD1 = ITEMS.register("keycard1", () -> new Item(new Item.Properties()
            .stacksTo(16)));

    public static final RegistryObject<Item> KEYCARD2 = ITEMS.register("keycard2", () -> new Item(new Item.Properties()
            .stacksTo(16)));

    public static final RegistryObject<Item> KEYCARD3 = ITEMS.register("keycard3", () -> new Item(new Item.Properties()
            .stacksTo(16)));

    public static final RegistryObject<Item> KEYCARD4 = ITEMS.register("keycard4", () -> new Item(new Item.Properties()
            .stacksTo(16)));

    public static final RegistryObject<Item> KEYCARD5 = ITEMS.register("keycard5", () -> new Item(new Item.Properties()
            .stacksTo(16)));

    /** Generic Items **/

    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit", () -> new MedkitItem(new Item.Properties()
            .stacksTo(15)
            .food(Foods.MEDKIT)));

    public static final RegistryObject<Item> SCP939SPINE = ITEMS.register("scp939spine", () -> new Item(new Item.Properties()
            .stacksTo(64)));

    public static final RegistryObject<Item> SCP939DAGGER = ITEMS.register("scp939dagger", () -> new SwordItem(Tiers.WOOD, 5, 1.3f,
            new Item.Properties().durability(110)));

    public static final RegistryObject<Item> INSTAKILL = ITEMS.register("instakill", () -> new InstaKillItem(Tiers.NETHERITE, 99999, 1.3f,
            new Item.Properties()));

    public static final RegistryObject<Item> SLEDGEHAMMER = ITEMS.register("sledgehammer", () -> new PickaxeItem(Tiers.IRON, 4, 1f,
        new Item.Properties().durability(100)));

    /** SCP Items **/

    public static final RegistryObject<Item> SCP268 = ITEMS.register("scp268", () -> new SCP268ArmorItem(ModArmorMaterials.SCP_268, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> SCP1025 = ITEMS.register("scp1025", () -> new SCP1025Item(new Item.Properties()
            .stacksTo(1)));

    public static final RegistryObject<ForgeSpawnEggItem> SCP_650_SPAWN_EGG = ITEMS.register("scp_650_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.SCP_650, 0, 1710618,
            new Item.Properties()));

    public static final RegistryObject<ForgeSpawnEggItem> SCP_049_SPAWN_EGG = ITEMS.register("scp_049_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.SCP_049, 3289650, 1820927,
            new Item.Properties()));

    public static final RegistryObject<Item> SCP109 = ITEMS.register("scp109", () -> new SCP109Item(new Item.Properties()
            .stacksTo(1)
            .food(Foods.SCP109)));

    /** Candy **/

    public static final RegistryObject<Item> CANDY1 = ITEMS.register("candy1", () -> new Item(new Item.Properties()
            .stacksTo(3)
            .food(Foods.CANDY1)));

    public static final RegistryObject<Item> CANDY2 = ITEMS.register("candy2", () -> new Item(new Item.Properties()
            .stacksTo(3)
            .food(Foods.CANDY2)));

    public static final RegistryObject<Item> CANDY3 = ITEMS.register("candy3", () -> new Item(new Item.Properties()
            .stacksTo(3)
            .food(Foods.CANDY3)));

    public static final RegistryObject<Item> CANDY4 = ITEMS.register("candy4", () -> new Item(new Item.Properties()
            .stacksTo(3)
            .food(Foods.CANDY4)));


    public static class Foods {
        public static final FoodProperties CANDY1 = new FoodProperties.Builder()
                .saturationMod(0.3f)
                .nutrition(4)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties CANDY2 = new FoodProperties.Builder()
                .saturationMod(0.3f)
                .nutrition(4)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties CANDY3 = new FoodProperties.Builder()
                .saturationMod(0.3f)
                .nutrition(4)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties CANDY4 = new FoodProperties.Builder()
                .saturationMod(0.3f)
                .nutrition(4)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties SCP109 = new FoodProperties.Builder()
                .nutrition(8)
                .saturationMod(0.7f)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties MEDKIT = new FoodProperties.Builder()
                .alwaysEat()
                .meat()
                .build();

        public static final FoodProperties SCP207 = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.9f)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 1f)
                .effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 1), 1f)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties SCP500 = new FoodProperties.Builder()
                .nutrition(7)
                .saturationMod(0.5f)
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
