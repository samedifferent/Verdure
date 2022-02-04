package samebutdifferent.verdure.block.properties;

import net.minecraft.util.StringRepresentable;

public enum PebbleType implements StringRepresentable {
    SAND("sand"),
    GRASS("grass"),
    STONE("stone");

    private final String name;

    private PebbleType(String type) {
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
