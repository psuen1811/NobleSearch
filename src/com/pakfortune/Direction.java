package com.pakfortune;

import java.util.Arrays;

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
        return Arrays.stream(values()).filter(v -> v.ordinal() == value).findFirst().orElse(null);
    }
}
