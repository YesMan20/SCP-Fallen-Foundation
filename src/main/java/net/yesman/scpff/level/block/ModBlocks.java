package net.yesman.scpff.level.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SCPFf.MOD_ID);

    public static final RegistryObject<Block> HCWALL = registerBlock("hcwall",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> HCFLOOR = registerBlock("hcfloor",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METALWALL1 = registerBlock("metalwall1",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> METALWALL2 = registerBlock("metalwall2",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EZWALL1 = registerBlock("ezwall1",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> EZWALL2 = registerBlock("ezwall2",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TILES = registerBlock("tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f).requiresCorrectToolForDrops()));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
