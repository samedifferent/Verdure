package samebutdifferent.verdure.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import samebutdifferent.verdure.Verdure;
import samebutdifferent.verdure.registry.VerdureBlocks;

public class BlockTagGenerator extends BlockTagsProvider {
    public BlockTagGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Verdure.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(VerdureBlocks.SLATE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(VerdureBlocks.SMOOTH_DIRT.get());

        this.tag(BlockTags.DIRT)
                .add(VerdureBlocks.SMOOTH_DIRT.get());
    }
}
