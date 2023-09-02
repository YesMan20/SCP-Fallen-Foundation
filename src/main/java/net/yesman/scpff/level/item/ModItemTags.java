package net.yesman.scpff.level.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.SCPFf;

import java.util.List;

public class ModItemTags {

    public static final List<Item> CANDIES = getTag("candies");

    private static List<Item> getTag(String tag) {
       return ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(SCPFf.MOD_ID, tag))).stream().toList();
    }

}
