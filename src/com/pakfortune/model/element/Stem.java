package com.pakfortune.model.element;

import com.google.common.base.Enums;

@SuppressWarnings("NonAsciiCharacters")
public enum Stem {
    甲,        // 甲 (0)
    乙,        // 乙 (1)
    丙,        // 丙 (2)
    丁,        // 丁 (3)
    戊,        // 戊 (4)
    己,        // 己 (5)
    庚,        // 庚 (6)
    辛,        // 辛 (7)
    壬,        // 壬 (8)
    癸;        // 癸 (9)

    public static Stem getIfPresent(String name) {
        return Enums.getIfPresent(Stem.class, name).orNull();
    }
}