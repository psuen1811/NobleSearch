package com.pakfortune.common;

import com.pakfortune.model.element.Branch;
import com.pakfortune.model.element.Stem;

import static java.lang.Math.abs;

public class GetBranchByStem {

    private static final LookupInterface lookup = new LookupImpl();

    public static String calculate(String stem, String location) {
        // 取地支序數
        int branchOrdinal = lookup.getIfPresent(Branch.class, location).ordinal();
        // 由序數計算飛遁天干
        int numOfJump = (FiveTigerHop.hop(stem).ordinal() +
                (abs(branchOrdinal - Branch.寅.ordinal()) % Branch.values().length)) % Stem.values().length;

        return Stem.values()[numOfJump].name() + location;
    }
}
