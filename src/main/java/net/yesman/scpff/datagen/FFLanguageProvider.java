package net.yesman.scpff.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.FFBlocksRegistry;
import net.yesman.scpff.level.entity.FFEntitiesRegistry;
import net.yesman.scpff.level.item.FFItemsRegistry;
import net.yesman.scpff.level.misc.FFPaintingsRegistry;

public class FFLanguageProvider extends LanguageProvider {
    public FFLanguageProvider(PackOutput output) {
        super(output, SCPFf.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Blocks
        addBlock(FFBlocksRegistry.MIRROR, "Mirror");
        addBlock(FFBlocksRegistry.HCWALL, "Heavy Containment Wall");
        addBlock(FFBlocksRegistry.HCWALL_STAIRS, "Heavy Containment Wall Stairs");
        addBlock(FFBlocksRegistry.HCWALL_SLAB, "Heavy Containment Wall Slab");
        addBlock(FFBlocksRegistry.BRICKWALL1, "White Brick Wall Bottom");
        addBlock(FFBlocksRegistry.BRICKWALL2, "White Brick Wall Middle");
        addBlock(FFBlocksRegistry.BRICKWALL3, "White Brick Wall Top");
        addBlock(FFBlocksRegistry.HCFLOOR, "Grated Floor");
        addBlock(FFBlocksRegistry.HCFLOOR_SLAB, "Grated Floor Slab");
        addBlock(FFBlocksRegistry.HCFLOOR_STAIRS, "Grated Floor Stairs");
        addBlock(FFBlocksRegistry.METALWALL1, "Metal Plated Wall Bottom");
        addBlock(FFBlocksRegistry.METALWALL2, "Metal Plated Wall Top");
        addBlock(FFBlocksRegistry.EZWALL1, "Entrance Wall Bottom");
        addBlock(FFBlocksRegistry.EZWALL2, "Entrance Wall Top");
        addBlock(FFBlocksRegistry.WHITE_CONCRETE_STAIRS, "White Concrete Stairs");
        addBlock(FFBlocksRegistry.WHITE_CONCRETE_SLAB, "White Concrete Slab");
        addBlock(FFBlocksRegistry.GRAY_CONCRETE_STAIRS, "Gray Concrete Stairs");
        addBlock(FFBlocksRegistry.GRAY_CONCRETE_SLAB, "Gray Concrete Slab");
        addBlock(FFBlocksRegistry.TILE, "Tile");
        addBlock(FFBlocksRegistry.BIG_TILE_STAIRS, "Big Tile Stairs");
        addBlock(FFBlocksRegistry.BIG_TILE_SLAB, "Big Tile Slab");
        addBlock(FFBlocksRegistry.TILES, "Tiles");
        addBlock(FFBlocksRegistry.TILE_STAIRS, "Tiles Stairs");
        addBlock(FFBlocksRegistry.TILE_SLAB, "Tiles Slab");
        addBlock(FFBlocksRegistry.LCWALL1, "Light Containment Wall Bottom");
        addBlock(FFBlocksRegistry.LCWALL2, "Light Containment Wall Middle");
        addBlock(FFBlocksRegistry.LCWALL3, "Light Containment Wall Top");
        addBlock(FFBlocksRegistry.REINFORCEDIRON, "Block of Reinforced Iron");
        addBlock(FFBlocksRegistry.CAUTIONLINE, "Caution Line");
        addBlock(FFBlocksRegistry.CAUTIONLINE_STAIRS, "Caution Line Stairs");
        addBlock(FFBlocksRegistry.CAUTIONLINE_SLAB, "Caution Line Slab");
        addBlock(FFBlocksRegistry.VENT_COVER, "Vent Cover");
        addBlock(FFBlocksRegistry.VENTBLOCK, "Vent Block");
        addBlock(FFBlocksRegistry.COMPUTER, "Personal Computer");
        addBlock(FFBlocksRegistry.CHAIR, "Chair");
        addBlock(FFBlocksRegistry.PAPERSTACK, "Stack Of Papers");
        addBlock(FFBlocksRegistry.PAPER, "Paper");
        addBlock(FFBlocksRegistry.TRASHBIN, "Trash Bin");
        addBlock(FFBlocksRegistry.BULLETINBOARD, "Bulletin Board");
        addBlock(FFBlocksRegistry.PIPE, "Pipe");
        addBlock(FFBlocksRegistry.PIPECORNER, "Pipe Corner");
        addBlock(FFBlocksRegistry.PIPESIDE, "Pipe Side");
        addBlock(FFBlocksRegistry.DESKLAMP, "Desk Lamp");
        addBlock(FFBlocksRegistry.FACILITYLIGHT, "Facility Light");
        addBlock(FFBlocksRegistry.SAFELABEL, "Safe Label");
        addBlock(FFBlocksRegistry.EUCLIDLABEL, "Euclid Label");
        addBlock(FFBlocksRegistry.KETERLABEL, "Keter Label");
        addBlock(FFBlocksRegistry.ELECTRICALBOX, "Electrical Box");
        addBlock(FFBlocksRegistry.FIREEXTINGUISHERCASE, "Fire Extinguisher Case");
        addBlock(FFBlocksRegistry.VENDINGMACHINERED, "Red Vending Machine");
        addBlock(FFBlocksRegistry.VENDINGMACHINEBLU, "Blue Vending Machine");
        addBlock(FFBlocksRegistry.CATWALKFENCE, "Catwalk Fence A");
        addBlock(FFBlocksRegistry.CATWALKFENCE2, "Catwalk Fence B");
        addBlock(FFBlocksRegistry.CATWALKBLOCK, "Catwalk Floor");
        addBlock(FFBlocksRegistry.CATWALKSTAIRS, "Catwalk Stairs");
        addBlock(FFBlocksRegistry.FILECABINET, "File Cabinet");
        addBlock(FFBlocksRegistry.WALLLIGHT, "Wall Light");
        addBlock(FFBlocksRegistry.FLOODLIGHTS, "Flood Lights");
        addBlock(FFBlocksRegistry.WIRES, "Wires");
        addBlock(FFBlocksRegistry.CRATE, "Crate");
        addBlock(FFBlocksRegistry.LOCKER, "Locker");
        addBlock(FFBlocksRegistry.MICROSCOPE, "Microscope");
        addBlock(FFBlocksRegistry.SCALE, "Scale");
        addBlock(FFBlocksRegistry.BEAKERS, "Beakers");
        addBlock(FFBlocksRegistry.TESTTUBES, "Test Tubes");
        addBlock(FFBlocksRegistry.SERVERSRACK, "Server Racks");
        addBlock(FFBlocksRegistry.INTERCOMMICROPHONE, "Intercom Microphone");
        addBlock(FFBlocksRegistry.INTERCOMSPEAKER, "Intercom Speaker");
        addBlock(FFBlocksRegistry.TRUSSBEAM, "Truss Beam");
        addBlock(FFBlocksRegistry.TRUSSBEAM_FENCE, "Truss Beam Fence");
        addBlock(FFBlocksRegistry.SCP173CRAP, "SCP-173 Feces");
        addBlock(FFBlocksRegistry.SCP106CORROSIONLAYER, "SCP-106 Corrosion Layer");
        addBlock(FFBlocksRegistry.SCP106CORROSION, "SCP-106 Corrosion Block");
        addBlock(FFBlocksRegistry.CONTAINMENT_CASE, "Containment Case");
        addBlock(FFBlocksRegistry.CONTAINMENT_CASE_BOTTOM, "Containment Case Bottom");
        addBlock(FFBlocksRegistry.SCP_330, "SCP-330");
        addBlock(FFBlocksRegistry.METALDOOR, "Metal Door");

        // Items
        addItem(FFItemsRegistry.SCP207, "SCP-207");
        addItem(FFItemsRegistry.SCP268, "SCP-268");
        addItem(FFItemsRegistry.SCP500, "SCP-500");
        addItem(FFItemsRegistry.SCP109, "SCP-109");
        addItem(FFItemsRegistry.SCP1025, "SCP-1025");
        addItem(FFItemsRegistry.SCP035, "SCP-035");
        addItem(FFItemsRegistry.CANDY1, "Purple Candy");
        addItem(FFItemsRegistry.CANDY2, "Red Candy");
        addItem(FFItemsRegistry.CANDY3, "Yellow Candy");
        addItem(FFItemsRegistry.CANDY4, "Green Candy");
        addItem(FFItemsRegistry.SCP1023ARC, "SCP-1023-ARC - A Telekill Sword");
        addItem(FFItemsRegistry.SLEDGEHAMMER, "Sledgehammer");
        addItem(FFItemsRegistry.MOP, "Mop");
        addItem(FFItemsRegistry.MEDKIT, "Medical Kit");
        addItem(FFItemsRegistry.SCP500PILLBOTTLE, "Pill Bottle");
        addItem(FFItemsRegistry.SCP939SPINE, "SCP-939 Spine");
        addItem(FFItemsRegistry.SCP939DAGGER, "SCP-939 Dagger");
        addItem(FFItemsRegistry.KEYCARD1, "Keycard - §eLevel 1");
        addItem(FFItemsRegistry.KEYCARD2, "Keycard - §6Level 2");
        addItem(FFItemsRegistry.KEYCARD3, "Keycard - §6Level 3");
        addItem(FFItemsRegistry.KEYCARD4, "Keycard - §6Level 4");
        addItem(FFItemsRegistry.KEYCARD5, "Keycard - §6Level 5");
        addItem(FFItemsRegistry.DCLASS_ARMOR_CHESTPLATE, "Class-D Shirt");
        addItem(FFItemsRegistry.DCLASS_ARMOR_LEGGINGS, "Class-D Pants");
        addItem(FFItemsRegistry.DCLASS_ARMOR_BOOTS, "Class-D Boots");
        addItem(FFItemsRegistry.GUARD_ARMOR_HELMET, "Guard Helmet");
        addItem(FFItemsRegistry.GUARD_ARMOR_CHESTPLATE, "Guard Chestplate");
        addItem(FFItemsRegistry.GUARD_ARMOR_LEGGINGS, "Guard Pants");
        addItem(FFItemsRegistry.GUARD_ARMOR_BOOTS, "Guard Boots");
        addItem(FFItemsRegistry.NTF_ARMOR_HELMET, "NTF Helmet");
        addItem(FFItemsRegistry.NTF_ARMOR_CHESTPLATE, "NTF Chestplate");
        addItem(FFItemsRegistry.NTF_ARMOR_LEGGINGS, "NTF Pants");
        addItem(FFItemsRegistry.NTF_ARMOR_BOOTS, "NTF Boots");
        addItem(FFItemsRegistry.RESEARCHER_ARMOR_CHESTPLATE, "Researcher Suit");
        addItem(FFItemsRegistry.RESEARCHER_ARMOR_LEGGINGS, "Researcher Pants");
        addItem(FFItemsRegistry.RESEARCHER_ARMOR_BOOTS, "Researcher Boots");
        addItem(FFItemsRegistry.FANTACY, "Fantacy");
        addItem(FFItemsRegistry.SPRINT, "Sprint");
        addItem(FFItemsRegistry.PEBIS, "Pebis");
        addItem(FFItemsRegistry.MOUNTDELICIOUS, "Mount Delicious");
        addItem(FFItemsRegistry.BONK_ATOMIC_PUNCH_RED, "Red Bonk Atomic Punch");
        addItem(FFItemsRegistry.BONK_ATOMIC_PUNCH_BLU, "Blue Bonk Atomic Punch");
        addItem(FFItemsRegistry.SCP_049_SPAWN_EGG, "SCP-049 Spawn Egg");
        addItem(FFItemsRegistry.SCP_131_SPAWN_EGG, "SCP-131 Spawn Egg");
        addItem(FFItemsRegistry.SCP_650_SPAWN_EGG, "SCP-650 Spawn Egg");
        addItem(FFItemsRegistry.SCP_058_SPAWN_EGG, "SCP-058 Spawn Egg");
        addItem(FFItemsRegistry.SCP_939_SPAWN_EGG, "SCP-939 Spawn Egg");
        addItem(FFItemsRegistry.SCP_106_SPAWN_EGG, "SCP-106 Spawn Egg");
        addItem(FFItemsRegistry.SCP_173_SPAWN_EGG, "SCP-173 Spawn Egg");
        addItem(FFItemsRegistry.SCP_1507_SPAWN_EGG, "SCP-1507 Spawn Egg");

        // Entities
        addEntityType(FFEntitiesRegistry.SCP_650, "SCP-650");
        addEntityType(FFEntitiesRegistry.SCP_173, "SCP-173");
        addEntityType(FFEntitiesRegistry.SCP_131, "SCP-131");
        addEntityType(FFEntitiesRegistry.SCP_049, "SCP-049");
        addEntityType(FFEntitiesRegistry.SCP_1507, "SCP-1507");
        addEntityType(FFEntitiesRegistry.SCP_939, "SCP-939");
        addEntityType(FFEntitiesRegistry.SCP_106, "SCP-106");
        addEntityType(FFEntitiesRegistry.SCP_058, "SCP-058");
        addEntityType(FFEntitiesRegistry.SCP_2521, "SCP-§4●●|●●●●●|●●|●");

        // Paintings
        addPainting(FFPaintingsRegistry.SODA, "SODA!!!!!", "Lucent");
        addPainting(FFPaintingsRegistry.SAFETYFIRST, "Safety First Poster", "The Foundation");
        addPainting(FFPaintingsRegistry.MASON, "Mason Troy Adams", "Lucent");
        addPainting(FFPaintingsRegistry.MYSTERIOUSROBOT, "Mysterious Robot", "NEWBLOOD");
        addPainting(FFPaintingsRegistry.PROTECTPOSTER, "Protect Poster", "The Foundation");
        addPainting(FFPaintingsRegistry.MEMETICPOSTER, "Memetic Poster", "The Foundation");
        addPainting(FFPaintingsRegistry.SCP106POSTER, "SCP-106 Poster", "The Foundation");
        addPainting(FFPaintingsRegistry.DCLASSPOSTER, "Class-D Poster", "The Foundation");

        // Tooltips
        add("tooltip.scpff.decoration_block", "Can be used with White Concrete");
        add("tooltip.scpff.sledgehammer", "Cycles through SCP variants");

        // Creative tabs
        add("itemGroup.scpff_items", "SCP FF - Items");
        add("itemGroup.scpff_blocks", "SCP FF - Facility Blocks");
        add("itemGroup.scpff_scps", "SCP FF - SCPs");
        add("itemGroup.scpff_armory", "SCP FF - Combat");

        add("sounds.scpff.locker_open", "Locker opening");
        add("sounds.scpff.locker_close", "Locker closing");
        add("sounds.scpff.stinger", "Stinger");
        add("sounds.scpff.scp173_kill", "Neck breaking");
        add("sounds.scpff.scp058beating", "Heart beats");
        add("sounds.scpff.scp131ambient", "Beeping");
        add("sounds.scpff.scp131hurt", "SCP-131 Hurt");
        add("sounds.scpff.scp049breathing", "Breathing");
        add("sounds.scpff.scp106breathing", "Heavy breathing");

        // Death messages
        add("death.attack.scp173", "%1$s\'s neck was snapped");
        add("death.attack.scp173.player", "%1$s\'s neck was snapped while fighting %2$s");
    }

    private void addPainting(RegistryObject<PaintingVariant> painting, String title, String author) {
        add("painting.scpff." + painting.getId().getPath() + ".title", title);
        add("painting.scpff." + painting.getId().getPath() + ".author", author);
    }
}
