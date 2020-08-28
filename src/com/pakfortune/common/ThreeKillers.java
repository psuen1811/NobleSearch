package com.pakfortune.common;

import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

/*
 真三煞計算
 */
public class ThreeKillers {

    public static String calculate(String stem, String location) {
        // 取地支序數
        int branchOrdinal = Branch.getIfPresent(location).ordinal();
        // 由序數計算飛遁天干
        int numOfJump = (FiveTigerHop.hop(stem).ordinal() +
                ((branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + location;
    }
}
