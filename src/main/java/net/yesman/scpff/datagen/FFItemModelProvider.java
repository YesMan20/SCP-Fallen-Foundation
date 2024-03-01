package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.FFBlocksRegistry;
import net.yesman.scpff.level.item.FFItemsRegistry;

public class FFItemModelProvider extends ItemModelProvider {
    public FFItemModelProvider(PackOutput gen, ExistingFileHelper existingFileHelper) {
        super(gen, SCPFf.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(FFItemsRegistry.SCP207);
        simpleItem(FFItemsRegistry.SCP500);
        simpleItem(FFItemsRegistry.SCP1025);
        simpleItem(FFItemsRegistry.SCP109);
        simpleItem(FFItemsRegistry.SCP268);
        simpleItem(FFItemsRegistry.SCP035);
        simpleItem(FFItemsRegistry.ITEMICON);
        simpleItem(FFItemsRegistry.SCPICON);
        simpleItem(FFItemsRegistry.BLOCKICON);
        simpleItem(FFItemsRegistry.ARMORYICON);
        simpleItem(FFItemsRegistry.KEYCARD1);
        simpleItem(FFItemsRegistry.KEYCARD2);
        simpleItem(FFItemsRegistry.KEYCARD3);
        simpleItem(FFItemsRegistry.KEYCARD4);
        simpleItem(FFItemsRegistry.KEYCARD5);
        simpleItem(FFItemsRegistry.CANDY1);
        simpleItem(FFItemsRegistry.CANDY2);
        simpleItem(FFItemsRegistry.CANDY3);
        simpleItem(FFItemsRegistry.CANDY4);
        simpleItem(FFItemsRegistry.MEDKIT);
        simpleItem(FFItemsRegistry.SCP500PILLBOTTLE);
        simpleItem(FFItemsRegistry.SCP939SPINE);
        simpleItem(FFItemsRegistry.DCLASS_ARMOR_CHESTPLATE);
        simpleItem(FFItemsRegistry.DCLASS_ARMOR_LEGGINGS);
        simpleItem(FFItemsRegistry.DCLASS_ARMOR_BOOTS);
        simpleItem(FFItemsRegistry.RESEARCHER_ARMOR_CHESTPLATE);
        simpleItem(FFItemsRegistry.RESEARCHER_ARMOR_LEGGINGS);
        simpleItem(FFItemsRegistry.RESEARCHER_ARMOR_BOOTS);
        simpleItem(FFItemsRegistry.GUARD_ARMOR_HELMET);
        simpleItem(FFItemsRegistry.GUARD_ARMOR_CHESTPLATE);
        simpleItem(FFItemsRegistry.GUARD_ARMOR_LEGGINGS);
        simpleItem(FFItemsRegistry.GUARD_ARMOR_BOOTS);
        simpleItem(FFItemsRegistry.NTF_ARMOR_HELMET);
        simpleItem(FFItemsRegistry.NTF_ARMOR_CHESTPLATE);
        simpleItem(FFItemsRegistry.NTF_ARMOR_LEGGINGS);
        simpleItem(FFItemsRegistry.FANTACY);
        simpleItem(FFItemsRegistry.SPRINT);
        simpleItem(FFItemsRegistry.PEBIS);
        simpleItem(FFItemsRegistry.MOUNTDELICIOUS);
        simpleItem(FFItemsRegistry.BONK_ATOMIC_PUNCH_RED);
        simpleItem(FFItemsRegistry.BONK_ATOMIC_PUNCH_BLU);

        simpleItem(FFItemsRegistry.SCP1023ARC, true);
        simpleItem(FFItemsRegistry.MOP, true);
        simpleItem(FFItemsRegistry.SLEDGEHAMMER, true);
        simpleItem(FFItemsRegistry.CROWBAR, true);
        simpleItem(FFItemsRegistry.SCP939DAGGER, true);

        spawnEggItem(FFItemsRegistry.SCP_049_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_058_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_106_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_131_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_111_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_173_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_650_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_939_SPAWN_EGG);
        spawnEggItem(FFItemsRegistry.SCP_1507_SPAWN_EGG);

        simpleItemWithTexture(FFItemsRegistry.NTF_ARMOR_BOOTS, new ResourceLocation(SCPFf.MOD_ID, "item/guard_boots"));

        blockItem(FFBlocksRegistry.COMPUTER);
        blockItem(FFBlocksRegistry.DESKLAMP);

        blockItemWithTexture(FFBlocksRegistry.METALDOOR, new ResourceLocation(SCPFf.MOD_ID, "item/metaldoor"));
        blockItemWithTexture(FFBlocksRegistry.REINFORCEDGLASS, new ResourceLocation(SCPFf.MOD_ID, "block/reinforcedglass"));
        blockItemWithTexture(FFBlocksRegistry.OFFICEDOOR, new ResourceLocation(SCPFf.MOD_ID, "item/officedoor"));

        trapDoorBlockItem(FFBlocksRegistry.VENT_COVER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return simpleItem(item, false);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, boolean handheld) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation(handheld ? "item/handheld" : "item/generated")).texture("layer0", new ResourceLocation(SCPFf.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder spawnEggItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItemWithTexture(RegistryObject<Item> item, ResourceLocation texture) {
        return withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", texture);
    }

    private ItemModelBuilder blockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(), new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath()));
    }

    private ItemModelBuilder blockItemWithTexture(RegistryObject<Block> block, ResourceLocation texture) {
        return withExistingParent(block.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", texture);
    }

    private ItemModelBuilder trapDoorBlockItem(RegistryObject<Block> block) {
        return withExistingParent(block.getId().getPath(), new ResourceLocation(SCPFf.MOD_ID, "block/" + block.getId().getPath() + "_bottom"));
    }
}
