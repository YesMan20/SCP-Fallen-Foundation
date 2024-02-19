package net.yesman.scpff.level.item;

import net.minecraft.world.item.*;
        import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.entity.FFEntitiesRegistry;
import net.yesman.scpff.level.item.custom.*;
        import net.yesman.scpff.level.item.scps.*;
        import net.yesman.scpff.level.item.custom.SodaItem;

public class FFItemsRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SCPFf.MOD_ID);

    public static final RegistryObject<Item> SCP207 = ITEMS.register("scp207", () -> new SCP207Item(new Item.Properties()
            .food(FFFoodsRegistry.SCP207).stacksTo(3)));

    public static final RegistryObject<Item> SCP500 = ITEMS.register("scp500", () -> new SCP500Item(new Item.Properties()
            .food(FFFoodsRegistry.SCP500).stacksTo(7)));

    public static final RegistryObject<Item> SCP1023ARC = ITEMS.register("scp1023arc", () -> new SCP1023ARC(Tiers.NETHERITE, 99999, -1.0f,
            new Item.Properties().rarity(Rarity.EPIC).durability(99999)));

    public static final RegistryObject<Item> SCP1025 = ITEMS.register("scp1025", () -> new SCP1025Item(new Item.Properties()
            .stacksTo(1)));

    public static final RegistryObject<Item> SCP109 = ITEMS.register("scp109", () -> new SCP109Item(new Item.Properties()
            .stacksTo(1).food(FFFoodsRegistry.SCP109)));

    public static final RegistryObject<Item> SCP268 = ITEMS.register("scp268", () -> new SCP268ArmorItem(FFArmorMaterialsRegistry.SCP_268, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> SCP035 = ITEMS.register("scp035", () -> new SCP035ArmorItem(FFArmorMaterialsRegistry.SCP_035, ArmorItem.Type.HELMET, new Item.Properties()));

    /** Icons for tabs **/

    public static final RegistryObject<Item> ITEMICON = ITEMS.register("itemicon", () -> new IgnoreOnLoad(new Item.Properties()));

    public static final RegistryObject<Item> SCPICON = ITEMS.register("scpicon", () -> new IgnoreOnLoad(new Item.Properties()));

    public static final RegistryObject<Item> BLOCKICON = ITEMS.register("blockicon", () -> new IgnoreOnLoad(new Item.Properties()));

    public static final RegistryObject<Item> ARMORYICON = ITEMS.register("armoryicon", () -> new IgnoreOnLoad(new Item.Properties()));

    /** Keycards **/

    public static final RegistryObject<Item> KEYCARD1 = ITEMS.register("keycard1", () -> new KeycardItem(new Item.Properties()
            .stacksTo(16), 1));

    public static final RegistryObject<Item> KEYCARD2 = ITEMS.register("keycard2", () -> new KeycardItem(new Item.Properties()
            .stacksTo(16),  2));

    public static final RegistryObject<Item> KEYCARD3 = ITEMS.register("keycard3", () -> new KeycardItem(new Item.Properties()
            .stacksTo(16), 3));

    public static final RegistryObject<Item> KEYCARD4 = ITEMS.register("keycard4", () -> new KeycardItem(new Item.Properties()
            .stacksTo(16), 4));

    public static final RegistryObject<Item> KEYCARD5 = ITEMS.register("keycard5", () -> new KeycardItem(new Item.Properties()
            .stacksTo(16), 5));

    /** Candy **/

    public static final RegistryObject<Item> CANDY1 = ITEMS.register("candy1", () -> new Item(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.CANDY)));

    public static final RegistryObject<Item> CANDY2 = ITEMS.register("candy2", () -> new Item(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.CANDY)));

    public static final RegistryObject<Item> CANDY3 = ITEMS.register("candy3", () -> new Item(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.CANDY)));

    public static final RegistryObject<Item> CANDY4 = ITEMS.register("candy4", () -> new Item(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.CANDY)));

    /** Generic Items **/

    public static final RegistryObject<Item> MOP = ITEMS.register("mop", () -> new MopItem(new ShearsItem.Properties().stacksTo(1).durability(64)));

    public static final RegistryObject<Item> SLEDGEHAMMER = ITEMS.register("sledgehammer", () -> new SledgeHammerItem(Tiers.IRON, 4, 1f,
            new Item.Properties().durability(100)));

    public static final RegistryObject<Item> MEDKIT = ITEMS.register("medkit", () -> new MedkitItem(new Item.Properties()
            .stacksTo(15)));

    public static final RegistryObject<Item> SCP500PILLBOTTLE = ITEMS.register("scp500pillbottle", () -> new BundleItem(new Item.Properties()
            .stacksTo(1)));

    public static final RegistryObject<Item> SCP939SPINE = ITEMS.register("scp939spine", () -> new Item(new Item.Properties()
            .stacksTo(64)));

    public static final RegistryObject<Item> SCP939DAGGER = ITEMS.register("scp939dagger", () -> new SwordItem(Tiers.WOOD, 5, 1.0f,
            new SwordItem.Properties().durability(110)));

    public static final RegistryObject<Item> FANTACY = ITEMS.register("fantacy", () -> new SodaItem(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.SODA)));

    public static final RegistryObject<Item> SPRINT = ITEMS.register("sprint", () -> new SodaItem(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.SODA)));

    public static final RegistryObject<Item> PEBIS = ITEMS.register("pebis", () -> new SodaItem(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.SODA)));

    public static final RegistryObject<Item> MOUNTDELICIOUS = ITEMS.register("mountdelicious", () -> new SodaItem(new Item.Properties()
            .stacksTo(3).food(FFFoodsRegistry.SODA)));

    /** SCP Spawn Eggs **/

    public static final RegistryObject<Item> SCP_049_SPAWN_EGG = ITEMS.register("scp_049_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_049, 3289650, 1820927, new Item.Properties()));

    public static final RegistryObject<Item> SCP_058_SPAWN_EGG = ITEMS.register("scp_058_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_058, 6755637, 16177620, new Item.Properties()));

    public static final RegistryObject<Item> SCP_106_SPAWN_EGG = ITEMS.register("scp_106_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_106, 0, 16777215, new Item.Properties()));

    public static final RegistryObject<Item> SCP_131_SPAWN_EGG = ITEMS.register("scp_131_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_131, 12669494, 56575, new Item.Properties()));

    public static final RegistryObject<Item> SCP_173_SPAWN_EGG = ITEMS.register("scp_173_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_173, 15385721, 16721446, new Item.Properties()));

    public static final RegistryObject<Item> SCP_650_SPAWN_EGG = ITEMS.register("scp_650_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_650, 0, 1710618, new Item.Properties()));

    public static final RegistryObject<Item> SCP_939_SPAWN_EGG = ITEMS.register("scp_939_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_939, 3342336, 10027008, new Item.Properties()));

    public static final RegistryObject<Item> SCP_1507_SPAWN_EGG = ITEMS.register("scp_1507_spawn_egg", () -> new ForgeSpawnEggItem(FFEntitiesRegistry.SCP_1507, 15164807, 16776241, new Item.Properties()));

    /** Armor Items **/

    public static final RegistryObject<Item> DCLASS_ARMOR_CHESTPLATE = ITEMS.register("dclass_shirt", () -> new DClassArmorItem(
            FFArmorMaterialsRegistry.DCLASS_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> DCLASS_ARMOR_LEGGINGS = ITEMS.register("dclass_leggings", () -> new DClassArmorItem(
            FFArmorMaterialsRegistry.DCLASS_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> DCLASS_ARMOR_BOOTS = ITEMS.register("dclass_boots", () -> new DClassArmorItem(
            FFArmorMaterialsRegistry.DCLASS_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> RESEARCHER_ARMOR_CHESTPLATE = ITEMS.register("researcher_suit", () -> new ResearcherArmorItem(
            FFArmorMaterialsRegistry.RESEARCHER_SUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> RESEARCHER_ARMOR_LEGGINGS = ITEMS.register("researcher_leggings", () -> new ResearcherArmorItem(
            FFArmorMaterialsRegistry.RESEARCHER_SUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> RESEARCHER_ARMOR_BOOTS = ITEMS.register("researcher_boots", () -> new ResearcherArmorItem(
            FFArmorMaterialsRegistry.RESEARCHER_SUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> GUARD_ARMOR_HELMET = ITEMS.register("guard_helmet", () -> new GuardArmorItem(
            0.01F, FFArmorMaterialsRegistry.GUARD_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> GUARD_ARMOR_CHESTPLATE = ITEMS.register("guard_chestplate", () -> new GuardArmorItem(
            0.01F, FFArmorMaterialsRegistry.GUARD_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> GUARD_ARMOR_LEGGINGS = ITEMS.register("guard_leggings", () -> new GuardArmorItem(
            0.01F, FFArmorMaterialsRegistry.GUARD_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> GUARD_ARMOR_BOOTS = ITEMS.register("guard_boots", () -> new GuardArmorItem(
            0.01F, FFArmorMaterialsRegistry.GUARD_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> NTF_ARMOR_HELMET = ITEMS.register("ntf_helmet", () -> new NtfArmorItem(
            FFArmorMaterialsRegistry.NTF_ARMOR, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> NTF_ARMOR_CHESTPLATE = ITEMS.register("ntf_chestplate", () -> new NtfArmorItem(
            FFArmorMaterialsRegistry.NTF_ARMOR, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> NTF_ARMOR_LEGGINGS = ITEMS.register("ntf_leggings", () -> new NtfArmorItem(
            FFArmorMaterialsRegistry.NTF_ARMOR, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> NTF_ARMOR_BOOTS = ITEMS.register("ntf_boots", () -> new NtfArmorItem(
            FFArmorMaterialsRegistry.NTF_ARMOR, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

