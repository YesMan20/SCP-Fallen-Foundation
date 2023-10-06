package net.yesman.scpff.level.block.Scp;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;
import net.yesman.scpff.SCPFf;
import net.yesman.scpff.level.block.decor.HorizontalDecorationBlock;

import java.util.List;

public class SCP330Block extends HorizontalDecorationBlock {
    private static int interactCount = 0;

    public SCP330Block(Properties properties) {
        super(properties, box(3, 0, 3, 13, 3, 13));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        List<Item> candy = ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation(SCPFf.MOD_ID, "candies"))).stream().toList();
        Item item = candy.get(RandomSource.create().nextInt(candy.size()));
        level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5F, pos.getY() + 0.2F, pos.getZ() + 0.5F, new ItemStack(item)));
        if (!level.isClientSide) {
            if (!player.isCreative()) {
                if (interactCount >= 2) {
                    player.hurt(level.damageSources().magic(), 100.0F);
                    interactCount = 0;
                } else {
                    interactCount++;
                }
                SCPFf.LOGGER.info("scp-330 ineractCount: " + interactCount);
            }
        } else {
            return InteractionResult.sidedSuccess(true);
        }
        return super.use(state, level, pos, player, hand, hit);
    }
}
