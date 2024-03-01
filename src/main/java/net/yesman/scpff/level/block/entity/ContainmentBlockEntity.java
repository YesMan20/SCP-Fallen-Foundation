package net.yesman.scpff.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ContainmentBlockEntity extends BlockEntity {

    public ItemStack currentItem = ItemStack.EMPTY;

    public ContainmentBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(FFBlockEntitiesRegistry.CONTAINMENT_BLOCK.get(), pPos, pBlockState);
    }

    public ItemStack getDisplayedStack() {
        return currentItem;
    }

    /**
     * Updates the currently displayed item in the case.
     *
     * @param player Player that interacted with the case.
     * @param stack  New item stack.
     */
    public void updateItem(Player player, ItemStack stack) {
        ItemStack updatedStack = stack.copyWithCount(1);
        stack.shrink(1);
        player.getInventory().add(this.currentItem);
        this.currentItem = updatedStack;
        assert this.level != null;
        setChanged();
        this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag) {
        super.saveAdditional(pTag);
        pTag.put("item", this.currentItem.save(new CompoundTag()));
    }

    @Override
    public void load(@NotNull CompoundTag pTag) {
        super.load(pTag);
        if (pTag.contains("item")) {
            this.currentItem = ItemStack.of(pTag.getCompound("item"));
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}
