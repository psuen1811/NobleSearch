package com.pakfortune.model.element;

import com.google.common.base.Enums;

@SuppressWarnings("NonAsciiCharacters")
public enum Branch {
    子,    // 子 (0)
    丑,    // 丑 (1)
    寅,    // 寅 (2)
    卯,    // 卯 (3)
    辰,    // 辰 (4)
    巳,    // 巳 (5)
    午,    // 午 (6)
    未,    // 未 (7)
    申,    // 申 (8)
    酉,    // 酉 (9)
    戌,    // 戌 (10)
    亥;    // 亥 (11)

    public static Branch getIfPresent(String name) {
        return Enums.getIfPresent(Branch.class, name).orNull();
    }
}
