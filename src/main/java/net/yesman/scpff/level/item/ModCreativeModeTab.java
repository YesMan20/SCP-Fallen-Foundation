package net.yesman.scpff.level.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ITEMS_TAB = new CreativeModeTab("itemstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ITEMICON.get());
        }
    };
    public static final CreativeModeTab BLOCK_TAB = new CreativeModeTab("blockstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BLOCKICON.get());
        }
    };
    public static final CreativeModeTab SCP_TAB = new CreativeModeTab("scpstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SCPICON.get());
        }
    };
    public static final CreativeModeTab ARMORY_TAB = new CreativeModeTab("armorytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ARMORYICON.get());
        }
    };
}
