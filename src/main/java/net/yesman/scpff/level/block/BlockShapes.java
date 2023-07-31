package net.yesman.scpff.level.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

import static net.minecraft.world.level.block.Block.box;

public class BlockShapes {
    // Setup block shapes here:

    public static final VoxelShape BLOCK = box(0, 0, 0, 16, 16, 16);

    public static final VoxelShape CAT_WALK_BLOCK = box(0, 14, 0, 16, 16, 16);
    public static final VoxelShape WALL_LIGHT_BLOCK = box(2, 1, 2, 14, 12, 14);
    public static final VoxelShape CARPET = box(0, 0, 0, 16, 1, 16);
    public static final VoxelShape BEAKERS = box(1, 0, 1, 15, 2, 15);
    public static final VoxelShape PIPE = box(3, 0, 3, 13, 16, 13);
    public static final VoxelShape TRASH_BIN = box(3, 0, 3, 13, 14, 13);

    public static final VoxelShape STEEL_CANISTER = Shapes.or(box(3, 0, 3, 13, 15, 13), box(4, 18, 4, 12, 20, 12));

    // Rotated shapes:

    public static final VoxelShape CAT_WALK_STAIRS_N = Stream.of(
            Block.box(0, 14, 0, 16, 16, 8),
            Block.box(0, 6, 8, 16, 8, 16),
            Block.box(12, 6, 6, 14, 14, 8),
            Block.box(2, 6, 6, 4, 14, 8),
            Block.box(2, 0, 14, 4, 6, 16),
            Block.box(12, 0, 14, 14, 6, 16)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CAT_WALK_STAIRS_E = Stream.of(
            Block.box(0, 14, 8, 16, 16, 16),
            Block.box(0, 6, 0, 16, 8, 8),
            Block.box(2, 6, 8, 4, 14, 10),
            Block.box(12, 6, 8, 14, 14, 10),
            Block.box(12, 0, 0, 14, 6, 2),
            Block.box(2, 0, 0, 4, 6, 2)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CAT_WALK_STAIRS_S = Stream.of(
            Block.box(0, 14, 0, 8, 16, 16),
            Block.box(8, 6, 0, 16, 8, 16),
            Block.box(6, 6, 2, 8, 14, 4),
            Block.box(6, 6, 12, 8, 14, 14),
            Block.box(14, 0, 12, 16, 6, 14),
            Block.box(14, 0, 2, 16, 6, 4)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CAT_WALK_STAIRS_W = Stream.of(
            Block.box(8, 14, 0, 16, 16, 16),
            Block.box(0, 6, 0, 8, 8, 16),
            Block.box(8, 6, 12, 10, 14, 14),
            Block.box(8, 6, 2, 10, 14, 4),
            Block.box(0, 0, 2, 2, 6, 4),
            Block.box(0, 0, 12, 2, 6, 14)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();
    public static final VoxelShape CAT_WALK_FENCE_S = box(0, 0, 0, 16, 16, 2);
    public static final VoxelShape CAT_WALK_FENCE_N = box(0, 0, 14, 16, 16, 16);
    public static final VoxelShape CAT_WALK_FENCE_E = box(0, 0, 0, 2, 16, 16);
    public static final VoxelShape CAT_WALK_FENCE_W = box(14, 0, 0, 16, 16, 16);

    public static final VoxelShape TRUSSBEAM_FENCE_S = box(0, 0, 7, 16, 16, 9);
    public static final VoxelShape TRUSSBEAM_FENCE_N = box(0, 0, 7, 16, 16, 9);
    public static final VoxelShape TRUSSBEAM_FENCE_E = box(7, 0, 0, 9, 16, 16);
    public static final VoxelShape TRUSSBEAM_FENCE_W = box(7, 0, 0, 9, 16, 16);

    public static final VoxelShape MICROSCOPE_S = box(4, 0, 3, 12, 14, 14);
    public static final VoxelShape MICROSCOPE_N = box(4, 0, 2, 12, 14, 13);
    public static final VoxelShape MICROSCOPE_E = box(3, 0, 4, 14, 14, 12);
    public static final VoxelShape MICROSCOPE_W = box(2, 0, 4, 13, 14, 12);

    public static final VoxelShape SCALE_S = box(4, 0, 2, 12, 2, 13);
    public static final VoxelShape SCALE_N = box(4, 0, 3, 12, 2, 14);
    public static final VoxelShape SCALE_E = box(2, 0, 4, 13, 2, 12);
    public static final VoxelShape SCALE_W = box(3, 0, 4, 14, 2, 12);

    public static final VoxelShape TEST_TUBES_S = box(1, 0, 4, 15, 6, 10);
    public static final VoxelShape TEST_TUBES_N = box(1, 0, 6, 15, 6, 12);
    public static final VoxelShape TEST_TUBES_E = box(4, 0, 1, 10, 6, 15);
    public static final VoxelShape TEST_TUBES_W = box(6, 0, 1, 12, 6, 15);

    public static final VoxelShape INTERCOM_MICROPHONE_S = box(5, 0, 3, 11, 10, 16);
    public static final VoxelShape INTERCOM_MICROPHONE_N = box(5, 0, 0, 11, 10, 13);
    public static final VoxelShape INTERCOM_MICROPHONE_E = box(3, 0, 5, 16, 10, 11);
    public static final VoxelShape INTERCOM_MICROPHONE_W = box(0, 0, 5, 13, 10, 11);

    public static final VoxelShape INTERCOM_SPEAKER_S = box(2, 0, 0, 11, 12, 8);
    public static final VoxelShape INTERCOM_SPEAKER_N = box(5, 0, 8, 14, 12, 16);
    public static final VoxelShape INTERCOM_SPEAKER_E = box(0, 0, 5, 8, 12, 14);
    public static final VoxelShape INTERCOM_SPEAKER_W = box(8, 0, 2, 16, 12, 11);

    public static final VoxelShape PAPER_STACK_S = box(4, 0, 2, 13, 4, 14);
    public static final VoxelShape PAPER_STACK_N = box(3, 0, 2, 12, 4, 14);
    public static final VoxelShape PAPER_STACK_E = box(2, 0, 3, 14, 4, 12);
    public static final VoxelShape PAPER_STACK_W = box(2, 0, 4, 14, 4, 13);

    public static final VoxelShape FIRE_EXTINGUISHER_S = box(3, 0, 0, 13, 22, 9);
    public static final VoxelShape FIRE_EXTINGUISHER_N = box(3, 0, 7, 13, 22, 16);
    public static final VoxelShape FIRE_EXTINGUISHER_E = box(0, 0, 3, 9, 22, 13);
    public static final VoxelShape FIRE_EXTINGUISHER_W = box(7, 0, 3, 16, 22, 13);

    public static final VoxelShape ELECTRICAL_BOX_S = box(3, 2, 0, 13, 15, 3);
    public static final VoxelShape ELECTRICAL_BOX_N = box(3, 2, 13, 13, 15, 16);
    public static final VoxelShape ELECTRICAL_BOX_E = box(0, 2, 3, 3, 15, 13);
    public static final VoxelShape ELECTRICAL_BOX_W = box(13, 2, 3, 16, 15, 13);

    public static final VoxelShape LABEL_S = box(0, 2, 0, 16, 14, 1);
    public static final VoxelShape LABEL_N = box(0, 2, 15, 16, 14, 16);
    public static final VoxelShape LABEL_E = box(0, 2, 0, 1, 14, 16);
    public static final VoxelShape LABEL_W = box(15, 2, 0, 16, 14, 16);


    public static final VoxelShape COMPUTER_S = Shapes.or(box(2.5, 0, 0, 13.5, 4, 11), box(2.5, 0, 11, 13.5, 1, 16), box(2.5, 5, 8.5, 13.5, 14, 9.5), box(3, 5.5, 0.5, 13, 13.5, 8.5));
    public static final VoxelShape COMPUTER_N = Shapes.or(box(2.5, 0, 0, 13.5, 1, 5), box(2.5, 0, 5, 13.5, 4, 16), box(2.5, 5, 6.5, 13.5, 14, 7.5), box(3, 5.5, 7.5, 13, 13.5, 15.5));
    public static final VoxelShape COMPUTER_E = Shapes.or(box(0, 0, 2.5, 11, 4, 13.5), box(11, 0, 2.5, 16, 1, 13.5), box(8.5, 5, 2.5, 9.5, 14, 13.5), box(0.5, 5.5, 3, 8.5, 13.5, 13));
    public static final VoxelShape COMPUTER_W = Shapes.or(box(0, 0, 2.5, 5, 1, 13.5), box(5, 0, 2.5, 16, 4, 13.5), box(6.5, 5, 2.5, 7.5, 14, 13.5), box(7.5, 5.5, 3, 15.5, 13.5, 13));

    public static final VoxelShape DESK_LAMP_S = Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(6.5, 12.92, 10.27, 9.5, 15.92, 19.27));
    public static final VoxelShape DESK_LAMP_N = Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(6.5, 12.92, -3.27, 9.5, 15.92, 5.73));
    public static final VoxelShape DESK_LAMP_E = Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(10.27, 12.91, 6.5, 19.27, 15.91, 9.5));
    public static final VoxelShape DESK_LAMP_W = Shapes.or(box(5, 0, 5, 11, 2, 11), box(7, 2, 7, 9, 3, 9), box(-3.27, 12.92, 6.5, 5.73, 15.92, 9.5));
}
