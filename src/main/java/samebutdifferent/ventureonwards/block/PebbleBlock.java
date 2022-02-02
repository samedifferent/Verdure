package samebutdifferent.ventureonwards.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;
import samebutdifferent.ventureonwards.block.properties.PebbleType;

public class PebbleBlock extends Block {
    public static final EnumProperty<PebbleType> TYPE = EnumProperty.create("type", PebbleType.class);

    public PebbleBlock() {
        super(Properties.of(Material.DECORATION).noOcclusion().sound(SoundType.STONE).strength(0.4F));
        this.registerDefaultState(this.getStateDefinition().any().setValue(TYPE, PebbleType.GRASS));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos().below());
        if (state == Blocks.SAND.defaultBlockState()) {
            return super.getStateForPlacement(context).setValue(TYPE, PebbleType.SAND);
        } else if (state == Blocks.STONE.defaultBlockState()) {
            return super.getStateForPlacement(context).setValue(TYPE, PebbleType.STONE);
        } else {
            return super.getStateForPlacement(context).setValue(TYPE, PebbleType.GRASS);
        }
    }

    
}
