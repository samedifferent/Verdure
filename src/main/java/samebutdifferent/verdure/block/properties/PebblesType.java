package samebutdifferent.verdure.block.properties;

import net.minecraft.util.StringRepresentable;

public enum PebblesType implements StringRepresentable {
    SAND("sand"),
    GRASS("grass"),
    SLATE("slate"),
    STONE("stone");

    private final String name;

    PebblesType(String type) {
        this.name = type;
    }

    @Override
    public String toString() {
        return this.getSerializedName();
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
