package com.mycompany.app.treasuremap.enums;

public enum Orientation {
    NORTH("N"),
    SOUTH("S"),
    WEST("W"),
    EAST("E");

    private final String value;

    Orientation(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
