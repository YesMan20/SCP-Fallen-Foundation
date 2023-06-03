package net.yesman.scpff.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.entity.ModEntity;
import net.yesman.scpff.item.scps.MEDKITItem;
import net.yesman.scpff.item.scps.SCP207Item;
import net.yesman.scpff.item.scps.SCP500Item;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SCPFf.MOD_ID);

            public static final RegistryObject<Item> SCP207 = ITEMS.register("scp207", () -> new SCP207Item(new Item.Properties()
                            .tab(ModCreativeModeTab.ITEMS_TAB)
                            .food(Foods.SCP207)
                            .stacksTo(3)));
    public static final RegistryObject<Item> SCP500 = ITEMS.register("scp500", () -> new SCP500Item(new Item.Properties()
            .tab(ModCreativeModeTab.ITEMS_TAB)
            .food(Foods.SCP500)
            .stacksTo(7)));
    public static final RegistryObject<Item> ITEMICON = ITEMS.register("itemicon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCPICON = ITEMS.register("scpicon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOCKICON = ITEMS.register("blockicon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ARMORYICON = ITEMS.register("armoryicon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCP_650_SPAWN_EGG = ITEMS.register("scp_650_spawn_egg", () -> new ForgeSpawnEggItem(ModEntity.SCP_650, 0, 1710618,
            new Item.Properties().tab(ModCreativeModeTab.SCP_TAB)));
    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit", () -> new MEDKITItem(new Item.Properties()
            .stacksTo(15)
            .tab(ModCreativeModeTab.ITEMS_TAB)
            .food(Foods.MEDKIT)));

    public static class Foods {
        public static final FoodProperties MEDKIT = new FoodProperties.Builder()
                .alwaysEat()
                .meat()
                .build();

        public static final FoodProperties SCP207 = new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(0.2f)
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 0.9f)
                .effect(() -> new MobEffectInstance(MobEffects.WITHER, 400, 1), 0.9f)
                .alwaysEat()
                .fast()
                .build();

        public static final FoodProperties SCP500 = new FoodProperties.Builder()
                .nutrition(4)
                .saturationMod(0.2f)
                .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600, 3), 0.9f)
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 3), 0.9f)
                .alwaysEat()
                .fast()
                .build();
    }


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
