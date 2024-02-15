package net.yesman.scpff.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.yesman.scpff.level.block.decor.LockerBlock;
import net.yesman.scpff.level.misc.FFSoundsRegistry;

public class LockerBlockEntity extends RandomizableContainerBlockEntity {
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        protected void onOpen(Level level, BlockPos blockPos, BlockState blockState) {
            LockerBlockEntity.this.playSound(blockState, FFSoundsRegistry.LOCKEROPEN.get());
        }

        protected void onClose(Level level, BlockPos blockPos, BlockState blockState) {
            LockerBlockEntity.this.playSound(blockState, FFSoundsRegistry.LOCKERCLOSE.get());
        }

        protected void openerCountChanged(Level level, BlockPos blockPos, BlockState blockState, int p_155069_, int p_155070_) {
        }

        protected boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu) {
                Container container = ((ChestMenu) player.containerMenu).getContainer();
                return container == LockerBlockEntity.this;
            } else {
                return false;
            }
        }
    };

    public LockerBlockEntity(BlockPos position, BlockState state) {
        super(FFBlockEntitiesRegistry.LOCKER.get(), position, state);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items);
        }
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items);
        }
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    @Override
    public Component getDefaultName() {
        return Component.literal("locker");
    }

    public AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
        return ChestMenu.threeRows(pId, pPlayer, this);
    }

    public void startOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    public void stopOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.items)
            if (!itemstack.isEmpty())
                return false;
        return true;
    }

    protected boolean isOwnContainer(Player p_155355_) {
        if (!(p_155355_.containerMenu instanceof ChestMenu)) {
            return false;
        } else {
            Container container = ((ChestMenu) p_155355_.containerMenu).getContainer();
            return container == LockerBlockEntity.this || container instanceof CompoundContainer && ((CompoundContainer) container).contains(LockerBlockEntity.this);
        }
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Locker");
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        return true;
    }

    private void playSound(BlockState state, SoundEvent sound) {
        if (level == null) return;

        Vec3i cabinetFacingVector = state.getValue(LockerBlock.FACING).getNormal();
        double x = (double) worldPosition.getX() + 0.5D + (double) cabinetFacingVector.getX() / 2.0D;
        double y = (double) worldPosition.getY() + 0.5D + (double) cabinetFacingVector.getY() / 2.0D;
        double z = (double) worldPosition.getZ() + 0.5D + (double) cabinetFacingVector.getZ() / 2.0D;
        level.playSound(null, x, y, z, sound, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }
}
