package samebutdifferent.verdure.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DispenserMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import samebutdifferent.verdure.registry.VerdureBlockEntityTypes;

public class HollowLogBlockEntity extends RandomizableContainerBlockEntity {
    protected final NonNullList<ItemStack> items = NonNullList.withSize(9, ItemStack.EMPTY);

    public HollowLogBlockEntity(BlockPos pos, BlockState state) {
        super(VerdureBlockEntityTypes.HOLLOW_LOG.get(), pos, state);
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> pItems) {
        for (int i = 0; i < this.items.size(); i++) {
            this.setItem(i, pItems.get(i));
        }
    }

    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.verdure.hollow_log");
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new DispenserMenu(pContainerId, pInventory, this);
    }

    @Override
    public int getContainerSize() {
        return 9;
    }


    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items.clear();
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items);
        }
    }
}
