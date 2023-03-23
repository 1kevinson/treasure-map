package com.mycompany.app.treasuremap.enums;

public enum Code {
    MAP("C"),
    MOUNTAIN("M"),
    TREASURE("T"),
    ADVENTURER("A");

    private final String value;

    Code(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
