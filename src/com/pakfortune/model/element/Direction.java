package com.pakfortune.model.element;

@SuppressWarnings("NonAsciiCharacters")
public enum Direction {
    中,
    乾,
    兌,
    艮,
    離,
    坎,
    坤,
    震,
    巽;

    public static Direction findByValue(int value) {
        for (Direction v : values()) {
            if (v.ordinal() == value) {
                return v;
            }
        }
        return null;
    }
}
