package net.yesman.scpff.level.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.yesman.scpff.SCPFf;

public class FFItemTags {
    public static final TagKey<Item> CANDIES = getTag("candies");
    public static final TagKey<Item> HAS_WEIGHT = getTag("has_weight");

    private static TagKey<Item> getTag(String tag) {
       return TagKey.create(Registries.ITEM, new ResourceLocation(SCPFf.MOD_ID, tag));
    }
}
