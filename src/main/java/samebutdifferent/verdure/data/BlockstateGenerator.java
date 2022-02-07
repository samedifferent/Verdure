package samebutdifferent.verdure.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;

public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Verdure.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(VerdureBlocks.DRIED_MUD.get());
        simpleBlock(VerdureBlocks.SMOOTH_DIRT.get());
    }

    private void crossModel(Block plant) {
        simpleBlock(plant, models().cross(plant.getRegistryName().getPath(), modLoc("block/" + plant.getRegistryName().getPath())));
    }
}
